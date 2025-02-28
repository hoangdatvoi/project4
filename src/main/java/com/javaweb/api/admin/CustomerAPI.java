package com.javaweb.api.admin;

import com.javaweb.model.dto.*;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.CustomerService;
import com.javaweb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customer")
@RestController
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{ids}/staffsOfCustomer")
    public ResponseDTO loadStaffs(@PathVariable Long ids) {

        return customerService.listStaffs(ids);
    }

    @PostMapping("/assignmentOfCustomer")
    public void updateAssignmentCustomer(@RequestBody AssignmentCustomerDTO assignmentCustomerDTO) {

        customerService.updateAssignmentCustomer(assignmentCustomerDTO);
    }


    @DeleteMapping("/{ids}")
    public void deleteCustomer(@PathVariable List<Long> ids) {

        customerService.deleteCustomer(ids);
        System.out.println("Sss");

    }

    @PostMapping
    public void addOrUpdateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addOrUpdateCustomer(customerDTO);
    }

    @PostMapping("/transaction")
    public void updateOrAddTransaction(@RequestBody TransactionDTO transactionDTO) {

        transactionService.updateOrAddTransaction(transactionDTO);
    }


}
