package a.a.a

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.test.context.support.WithAnonymousUser
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class UserAccessTest (
    @Autowired
    val mockMvc: MockMvc,

    @Autowired
    val mapper: ObjectMapper,
) {

    fun mockUser(): UserDetails {
        return User.builder()
            .username("1234")
            .password("1234")
            .roles("USER")
            .build()
    }
    fun mockAdmin(): UserDetails {
        return User.builder()
            .username("admin")
            .password("1234")
            .roles("ADMIN")
            .build()
    }

    @DisplayName("user로 user page에 접근이 가능하다")
    @Test
//    @WithMockUser(username = "1234", roles = ["USER"])
    fun test_user_access_userpage() {
        println("hello world")
        val resp = mockMvc.perform(get("/user").with(user(mockUser())))
            .andExpect(status().isOk())
            .andReturn().response.getContentAsString()

        println()

        val message = mapper.readValue<SecurityMessage>(resp, SecurityMessage::class.java)

        assertEquals("user page", message.message)
    }

    @DisplayName("user로 admin page에 접근이 불가능하다")
    @Test
//    @WithMockUser(username = "1234", roles = ["USER"])
    fun test_user_not_access_admin_page() {
        mockMvc.perform(get("/admin").with(user(mockUser())))
            .andExpect(status().is4xxClientError())
    }

    @DisplayName("admin으로 admin, user page에 접근이 가능하다")
    @Test
//    @WithMockUser(username = "admin", roles = ["ADMIN"])
    fun test_admin_access_user_and_admin_page() {
        var resp = mockMvc.perform(get("/user").with(user(mockAdmin())))
            .andExpect(status().isOk())
            .andReturn().response.getContentAsString()

        var message = mapper.readValue<SecurityMessage>(resp, SecurityMessage::class.java)

        assertEquals("user page", message.message)

        resp = mockMvc.perform(get("/admin").with(user(mockAdmin())))
            .andExpect(status().isOk())
            .andReturn().response.getContentAsString()

        message = mapper.readValue<SecurityMessage>(resp, SecurityMessage::class.java)
    }

    @DisplayName("login 페이지는 아무나 접근 가능")
    @Test
    @WithAnonymousUser
    fun test_login_page() {
        mockMvc.perform(get("/login"))
            .andExpect(status().isOk());
    }

    @DisplayName("홈페이지는 로그인 하지 않은 사람은 접근 불가능")
    @Test
    fun test_home_page() {
        mockMvc.perform(get("/"))
            .andExpect(status().is4xxClientError());
    }
}