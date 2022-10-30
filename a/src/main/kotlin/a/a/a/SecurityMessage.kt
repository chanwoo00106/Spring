package a.a.a

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.security.core.Authentication

class SecurityMessage @JsonCreator constructor (
    @JsonProperty("message")
    var message: String,

    @JsonIgnore
    var authentication: Authentication?
)
