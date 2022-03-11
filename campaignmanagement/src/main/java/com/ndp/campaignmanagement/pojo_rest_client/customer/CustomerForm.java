package com.ndp.campaignmanagement.pojo_rest_client.customer;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerForm {
    private String id;
    private String fullName;
    private String phoneNum;
    private String position;
    private String email;
    private LocalDate dateOfBirth;
}
