package a.a.a

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class UserAccessTest (
    @Autowired
    val mockMvc: MockMvc,

    @Autowired
    val mapper: ObjectMapper
) {

    @DisplayName("user로 user page에 접근이 가능하다")
    @Test
    @WithMockUser(username = "1234", roles = ["USER"])
    fun test_() {
        val resp = mockMvc.perform(get("/user"))
            .andExpect(status().isOk())
            .andReturn().response.getContentAsString()

        println()

        val message = mapper.readValue<SecurityMessage>(resp, SecurityMessage::class.java)


        assertEquals("user page", message.message)
    }
}