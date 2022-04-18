package com.clog.clog.global

import io.jsonwebtoken.Jwts
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class GlobalFilter: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val author = request.getHeader("authorization")
        if (author == null)
        val token = author.substring("Bearer ".length)
        println(author)
        Jwts.parser().setSigningKey(author).
        filterChain.doFilter(request, response)
    }

}