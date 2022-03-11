package com.ndp.campaignmanagement.pojo_rest_client.list_customer;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomersRaw {
    private Integer total;
    private Integer size;
    private List<Customer> data;
}
