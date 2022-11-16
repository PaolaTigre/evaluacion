package com.example.evatigre.controller

import com.example.evatigre.model.Attendee
import com.example.evatigre.service.AttendeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation. PatchMapping
@RestController
@RequestMapping("/attendee")
class AttendeeController {
    @Autowired
    lateinit var attendeeService: AttendeeService

    @GetMapping
    fun list():List<Attendee>{
        return attendeeService.list()
    }

    @PostMapping
    fun save(@RequestBody attendee: Attendee):Attendee? {
        return attendeeService.save(attendee)
    }

    @PutMapping
    fun update (@RequestBody attendee:Attendee): ResponseEntity<Attendee>{
        return  ResponseEntity(attendeeService.update(attendee), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody attendee: Attendee):ResponseEntity<Attendee>{
        return ResponseEntity(attendeeService.updateName(attendee), HttpStatus.OK)
    }

}





