package io.security.corespringsecurity.service

import io.security.corespringsecurity.domain.Account
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class AccountContext(account: Account, authorities: Collection<GrantedAuthority>):
  User(account.username, account.password, authorities) {
}