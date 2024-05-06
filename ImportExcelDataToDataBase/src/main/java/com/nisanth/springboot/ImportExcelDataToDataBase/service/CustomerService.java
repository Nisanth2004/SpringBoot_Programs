package com.nisanth.springboot.ImportExcelDataToDataBase.service;

import com.nisanth.springboot.ImportExcelDataToDataBase.domain.Customer;
import com.nisanth.springboot.ImportExcelDataToDataBase.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@AllArgsConstructor
@Service
public class CustomerService
{
    private CustomerRepository customerRepository;
    public void saveCustomersToDatabase(MultipartFile file)
    {
        // check it is valid excel file
        if(ExcelUploadService.isValidExcelFile(file))
        {
            try {
                List<Customer> customers=ExcelUploadService.getCustomerDataFromExcel(file.getInputStream());
                this.customerRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not valid");
            }

        }
    }
    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();

    }
}
