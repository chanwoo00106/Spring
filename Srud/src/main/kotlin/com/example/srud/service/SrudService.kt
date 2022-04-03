package com.example.srud.service

import com.example.srud.repository.Srud
import com.example.srud.repository.SrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SrudService(
    private val srudRepository: SrudRepository
) {
    fun getAll(): MutableIterable<Srud>? {
        println("시작")
        try {
            val a = srudRepository.findAll()
            println("끝")
            return a;
        } catch (e: Exception) {
            println(e)
            return null
        }
    }

    fun addContent(title: String, content: String): Srud {
        println("${title}, ${content}")
        val a = Srud(title = title, content = content)
        println(a)
        return srudRepository.save(a)
    }

    fun update(id: Long, title: String, content: String): Srud {
        val result = srudRepository.findByIdOrNull(id) ?: throw Exception()

        result.content = content
        result.title = title

        return srudRepository.save(result)
    }

    fun delete(id: Long) = srudRepository.deleteById(id)
}