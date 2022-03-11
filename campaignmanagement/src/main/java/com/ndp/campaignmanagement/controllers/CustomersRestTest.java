package com.ndp.campaignmanagement.controllers;

import com.ndp.campaignmanagement.business.SendingMailForAllCampaign;
import com.ndp.campaignmanagement.pojo_rest_client.customer.CustomerForm;
import com.ndp.campaignmanagement.pojo_rest_client.list_customer.CustomersRaw;
import com.ndp.campaignmanagement.rest_client.CustomerRC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/customers")
public class CustomersRestTest {
    @Autowired
    private CustomerRC customerRC;

    @Autowired
    private SendingMailForAllCampaign sendingMailForAllCampaign;

    @GetMapping (
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> retrieveCustomers() {
        ResponseEntity<Object> entity;

        CustomersRaw customersRaw = customerRC.getAllData();

        entity = new ResponseEntity<>(customersRaw, HttpStatus.OK);

        return entity;
    }

    @GetMapping(
        value = "/{recordId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> retrieveCustomerById(@PathVariable("recordId") String recordId) {
        ResponseEntity<Object> entity;

        CustomerForm customerForm = customerRC.getCustomerById(recordId);

        entity = new ResponseEntity<>(customerForm, HttpStatus.OK);

        return entity;
    }

    @GetMapping(
        value = "/meow",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> sendingMails() {
        ResponseEntity<Object> entity;

        Boolean kk = sendingMailForAllCampaign.sendMails();

        entity = new ResponseEntity<>(kk, HttpStatus.OK);

        return entity;
    }
}
