package com.example.evatigre.service
import com.example.evatigre.model.Invoice
import com.example.evatigre.repository.AttendeeRepository
import com.example.evatigre.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @Autowired
    lateinit var attendeeRepository: AttendeeRepository

    fun save (invoice: Invoice):Invoice{
        try {
            attendeeRepository.findById(invoice.attendeeId)
                ?:throw Exception("Asistente no existe")
            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun list ():List<Invoice>{
        return invoiceRepository.findAll()
    }



   fun update(invoice: Invoice):Invoice{
       try {
           invoiceRepository.findById(invoice.id)
               ?: throw Exception("Id no existe")
           return invoiceRepository.save(invoice)
       }
       catch(ex:Exception){
           throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
       }
   }
    fun updateName(invoice: Invoice): Invoice {
        try{
            val response = invoiceRepository.findById(invoice.id)
                ?: throw Exception("ID no existe")
            response.apply {
                total=invoice.total
            }
            return invoiceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }



}








