package com.example.evatigre.service
import com.example.evatigre.model.Attendee
import com.example.evatigre.repository.AttendeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AttendeeService {
    @Autowired
    lateinit var attendeeRepository: AttendeeRepository

    fun list ():List<Attendee>{
        return attendeeRepository.findAll()
    }

    fun save (attendee: Attendee):Attendee{
        return attendeeRepository.save(attendee)
        attendeeRepository.findById(attendee.id)?: throw Exception("10 no existe")
    }

   fun update(attendee: Attendee):Attendee{
       try {
           attendeeRepository.findById(attendee.id)
               ?: throw Exception("Id no existe")
           return attendeeRepository.save(attendee)
       }
       catch(ex:Exception){
           throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
       }
   }
    fun updateName(attendee: Attendee): Attendee {
        try{
            val response = attendeeRepository.findById(attendee.id)
                ?: throw Exception("ID no existe")
            response.apply {
                name=attendee.name
            }
            return attendeeRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}








