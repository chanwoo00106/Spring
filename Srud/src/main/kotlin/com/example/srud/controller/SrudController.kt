package com.example.srud.controller

import com.example.srud.service.SrudService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class SrudController(
    private final val srudService: SrudService
) {
    @GetMapping("/")
    fun getAll() = srudService.getAll()

    @PostMapping("/")
    fun addConten(@RequestBody data: SrudRequest) = srudService.addContent(title = data.title, content = data.content)

    @PutMapping(path = ["/{id}"])
    fun update(@PathVariable("id") id: Long, @RequestBody data: SrudRequest) = srudService.update(id, data.title, data.content)

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable("id") id: Long) = srudService.delete(id)
}
