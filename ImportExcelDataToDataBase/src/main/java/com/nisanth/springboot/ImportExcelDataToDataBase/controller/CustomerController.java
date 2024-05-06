package com.nisanth.springboot.ImportExcelDataToDataBase.controller;

import com.nisanth.springboot.ImportExcelDataToDataBase.domain.Customer;
import com.nisanth.springboot.ImportExcelDataToDataBase.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController
{
   private CustomerService customerService;
   @PostMapping("/upload-customer-data")
   public ResponseEntity<?> uploadCustomersData(@RequestParam("file")MultipartFile file)
   {
       this.customerService.saveCustomersToDatabase(file);
       return ResponseEntity.ok(Map.of("Message","Customers Data uploaded and saved to database successfully "));

   }
   @GetMapping
   public ResponseEntity<List<Customer>> getCustomers()
   {
       return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.FOUND);
   }
}
