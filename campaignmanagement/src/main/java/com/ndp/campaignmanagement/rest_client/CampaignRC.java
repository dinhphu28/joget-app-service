package com.ndp.campaignmanagement.rest_client;

import java.util.Arrays;

import com.ndp.campaignmanagement.pojo_rest_client.list_campaign.CampaignsRaw;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CampaignRC {
    static final String URL_CAMPAIGNS = "https://dinhphu28n.cloud.joget.com/jw/api/list/list_campaign";

    public CampaignsRaw getAllData() {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
        headers.set("api_id", "API-9f216eb6-ecfd-42e4-9e8d-96fa15baa446");
        headers.set("api_key", "829cfb0ef44c4102aea3bbcea458793d");

        HttpEntity<CampaignsRaw> entity = new HttpEntity<CampaignsRaw>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CampaignsRaw> response = restTemplate.exchange(URL_CAMPAIGNS, HttpMethod.GET, entity, CampaignsRaw.class);
        
        HttpStatus statusCode = response.getStatusCode();

        CampaignsRaw campaignsRaw = new CampaignsRaw();

        if(statusCode == HttpStatus.OK) {
            campaignsRaw = response.getBody();
        }

        return campaignsRaw;
    }
}
