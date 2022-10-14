package a.a.a.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import javax.servlet.http.HttpServletRequest


@Component
class TokenProvider(
    private val jwtProperties: JwtProperties,
    @Value("\${jwt.secret}") secretKey: String?,
) {
    var key: Key? = null

    companion object {
        const val ACCESS_TYPE = "access"
        const val ACCESS_EXP = 60L * 10 // 10 min
        const val TOKEN_PREFIX = "Bearer "
    }

    init {
        val keyBytes = Decoders.BASE64.decode(secretKey)
        this.key = Keys.hmacShaKeyFor(keyBytes)
    }

    fun generateToken(id: String): String {
        return Jwts.builder()
            .signWith(key, SignatureAlgorithm.HS256)
            .setSubject(id)
            .claim("type", ACCESS_TYPE)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + ACCESS_EXP * 1000))
            .compact()
    }

    fun getToken(req: HttpServletRequest): String? {
        val authorization = req.getHeader("Authorization") ?: return null
        return if (authorization.startsWith(TOKEN_PREFIX)) authorization.replace(TOKEN_PREFIX, "") else null
    }

    fun parseToken(token: String): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(this.key)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw Exception()
        } catch (e: Exception) {
            throw Exception()
        }
    }

    fun getTokenId(req: HttpServletRequest): String? {
        val token = getToken(req)
        if (!token.isNullOrBlank()) {
            val body = parseToken(token)
            return body.subject
        }

        return null
    }
}