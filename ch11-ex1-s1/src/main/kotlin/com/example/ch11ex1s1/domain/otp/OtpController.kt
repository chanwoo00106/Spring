package com.example.ch11ex1s1.domain.otp

import com.example.ch11ex1s1.domain.otp.services.CheckService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/otp")
class OtpController (
  private val checkService: CheckService
) {
  @PostMapping("/check")
  fun check(@RequestBody otp: Otp, response: HttpServletResponse) {
    if (checkService.execute(otp)) {
      response.status = HttpServletResponse.SC_OK
      return
    }
    response.status = HttpServletResponse.SC_FORBIDDEN
  }
}