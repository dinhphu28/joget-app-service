package com.ndp.campaignmanagement.pojo_rest_client.list_customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String address;
    private String gender;
    private String fullName;
    private String phoneNum;
    private String dateOfBirth;
    private String position;
    private String email;
    private String religion;
}
