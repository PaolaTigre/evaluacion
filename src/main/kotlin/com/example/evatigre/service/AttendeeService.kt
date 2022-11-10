package com.example.evatigre.service
import com.example.evatigre.model.Attendee
import com.example.evatigre.repository.AttendeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AttendeeService {
    @Autowired
    lateinit var attendeeRepository: AttendeeRepository

    fun list ():List<Attendee>{
        return attendeeRepository.findAll()
    }

    fun save (attendee: Attendee):Attendee{
        return attendeeRepository.save(attendee)
    }
}






