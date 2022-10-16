package a.a.a.controller

import a.a.a.domain.Role
import a.a.a.domain.User
import a.a.a.dto.RoleToUserDto
import a.a.a.service.UserServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (
    private val userService: UserServiceImpl
) {

    @GetMapping("/users")
    fun getUsers(): List<User> {
        return userService.findAll();
    }

    @PostMapping("/user/save")
    fun saveUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }

    @PostMapping("role/save")
    fun saveRole(@RequestBody role: Role): Role {
        return userService.saveRole(role)
    }

    @PostMapping("role/addtouser")
    fun addToUser(@RequestBody roleToUser: RoleToUserDto) {
        userService.addRoleToUser(roleToUser)
    }
}