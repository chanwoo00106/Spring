package io.security.corespringsecurity.service;

import io.security.corespringsecurity.domain.AccountDto;

public interface UserService {
    void createUser(AccountDto account);
}
