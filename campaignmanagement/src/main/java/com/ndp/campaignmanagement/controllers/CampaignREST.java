package com.ndp.campaignmanagement.controllers;

import com.ndp.campaignmanagement.pojo_rest_client.list_campaign.CampaignsRaw;
import com.ndp.campaignmanagement.rest_client.CampaignRC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/campaigns")
public class CampaignREST {
    @Autowired
    private CampaignRC campaignRC;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> retrieveCampaigns() {
        ResponseEntity<Object> entity;

        CampaignsRaw campaignsRaw = campaignRC.getAllData();

        entity = new ResponseEntity<>(campaignsRaw, HttpStatus.OK);

        return entity;
    }
}
