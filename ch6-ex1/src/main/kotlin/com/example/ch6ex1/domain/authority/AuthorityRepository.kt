package com.example.ch6ex1.domain.authority

import org.springframework.data.jpa.repository.JpaRepository

interface AuthorityRepository: JpaRepository<Authority, Long> {
}