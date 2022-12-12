package io.security.corespringsecurity.service.impl;

import io.security.corespringsecurity.domain.Account;
import io.security.corespringsecurity.domain.AccountDto;
import io.security.corespringsecurity.repository.UserRepository;
import io.security.corespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(AccountDto account) {
        Account newUser = new Account();
        newUser.setUsername(account.getUsername());
        newUser.setRole(account.getRole());
        newUser.setAge(account.getAge());
        newUser.setEmail(account.getEmail());
        newUser.setPassword(passwordEncoder.encode(account.getPassword()));
        userRepository.save(newUser);
    }
}
