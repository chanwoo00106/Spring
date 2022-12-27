package com.example.ch3ex2.repository

import com.example.ch3ex2.domain.Authorities
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthoritiesRepository: JpaRepository<Authorities, Long> {
}