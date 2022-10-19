package a.a.a.filter

import org.springframework.stereotype.Component
import javax.servlet.*

@Component
class TestFilter: Filter {
    override fun init(filterConfig: FilterConfig?) {
        println("형우 씹덕")
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        println("--------------------시작--------------------")
        chain.doFilter(request, response)
        println("--------------------끝--------------------")
    }
}