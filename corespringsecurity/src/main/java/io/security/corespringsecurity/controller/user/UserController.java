package io.security.corespringsecurity.controller.user;


import io.security.corespringsecurity.domain.AccountDto;
import io.security.corespringsecurity.repository.UserRepository;
import io.security.corespringsecurity.service.UserService;
import io.security.corespringsecurity.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class UserController {
	final private UserService userService;

	@GetMapping(value="/mypage")
	public String myPage() throws Exception {
		return "user/mypage";
	}

	@GetMapping("/users")
	public String createUser() {
		return "user/login/register";
	}

	@PostMapping("/users")
	public String register(@RequestBody AccountDto account) {
		System.out.println("hello");
		log.info("hello");
		userService.createUser(account);
		return "redirect:/";
	}
}
