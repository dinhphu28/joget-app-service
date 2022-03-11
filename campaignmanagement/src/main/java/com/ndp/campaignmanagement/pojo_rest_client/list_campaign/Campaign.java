package com.ndp.campaignmanagement.pojo_rest_client.list_campaign;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    private String customersList;
    private String processed;
    private LocalDate dateStart;
    private String dayOfMonth;
    private LocalDate dateFinish;
    private String daysOfWeek;
    private String campaignName;
    private String personInCharge;
    private String campaignCode;
    private String campaignContent;
    private String campaignType;
}
