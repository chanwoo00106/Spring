package a.a.a.global

import com.fasterxml.jackson.databind.ObjectMapper
import com.msg.gauth.global.exception.ErrorResponse
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthenticationException(
    private val objectMapper: ObjectMapper
): AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException?
    ) {
        val error = ErrorCode.UNATHORIZED
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = error.code
        response.writer.write(objectMapper.writeValueAsString(ErrorResponse(error)))
    }
}