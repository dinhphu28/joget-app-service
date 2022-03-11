package com.ndp.campaignmanagement.pojo_rest_client.list_campaign;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignsRaw {
    private Integer total;
    private Integer size;
    private List<Campaign> data;
}
