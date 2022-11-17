package com.example.evatigre.controller

import com.example.evatigre.model.Invoice
import com.example.evatigre.service.InvoiceService
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
@RequestMapping("/invoice")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list():List<Invoice>{
        return invoiceService.list()
    }

    @PostMapping
    fun save(@RequestBody attendee: Invoice):Invoice? {
        return invoiceService.save(attendee)
    }

    @PutMapping
    fun update (@RequestBody invoice: Invoice): ResponseEntity<Invoice>{
        return  ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody invoice: Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.updateName(invoice), HttpStatus.OK)
    }

}





