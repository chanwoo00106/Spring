package com.example.srud.service

import com.example.srud.repository.Srud
import com.example.srud.repository.SrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SrudService(
    private val srudRepository: SrudRepository
) {
    fun getAll() = srudRepository.findAll()

    fun addContent(title: String, content: String): Srud = srudRepository.save(Srud(content = content, title = title))

    fun update(id: Long, title: String, content: String): Srud {
        val result = srudRepository.findByIdOrNull(id) ?: throw Exception()

        result.content = content
        result.title = title

        return srudRepository.save(result)
    }

    fun delete(id: Long) = srudRepository.deleteById(id)
}