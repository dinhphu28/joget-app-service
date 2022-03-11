package com.ndp.campaignmanagement.rest_client;

import java.util.Arrays;

import com.ndp.campaignmanagement.pojo_rest_client.customer.CustomerForm;
import com.ndp.campaignmanagement.pojo_rest_client.list_customer.CustomersRaw;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerRC {
    static final String URL_CUSTOMERS = "https://dinhphu28n.cloud.joget.com/jw/api/list/list_customer";
    static final String URL_CUSTOMER_BY_ID = "https://dinhphu28n.cloud.joget.com/jw/api/form/customer/";

    public CustomersRaw getAllData() {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
        headers.set("api_id", "API-9f216eb6-ecfd-42e4-9e8d-96fa15baa446");
        headers.set("api_key", "829cfb0ef44c4102aea3bbcea458793d");

        HttpEntity<CustomersRaw> entity = new HttpEntity<CustomersRaw>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CustomersRaw> response = restTemplate.exchange(URL_CUSTOMERS, HttpMethod.GET, entity, CustomersRaw.class);

        HttpStatus statusCode = response.getStatusCode();

        CustomersRaw customersRaw = new CustomersRaw();

        if(statusCode == HttpStatus.OK) {
            customersRaw = response.getBody();
        }

        return customersRaw;
    }

    public CustomerForm getCustomerById(String recordId) {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
        headers.set("api_id", "API-9f216eb6-ecfd-42e4-9e8d-96fa15baa446");
        headers.set("api_key", "829cfb0ef44c4102aea3bbcea458793d");

        HttpEntity<CustomerForm> entity = new HttpEntity<CustomerForm>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CustomerForm> response = restTemplate.exchange(URL_CUSTOMER_BY_ID + recordId, HttpMethod.GET, entity, CustomerForm.class);

        HttpStatus statusCode = response.getStatusCode();

        CustomerForm customerForm = new CustomerForm();

        if(statusCode == HttpStatus.OK) {
            customerForm = response.getBody();
        }

        return customerForm;
    }
}
