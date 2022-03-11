package com.ndp.campaignmanagement.business;

import java.util.ArrayList;
import java.util.List;

import com.ndp.campaignmanagement.pojo_rest_client.customer.CustomerForm;
import com.ndp.campaignmanagement.pojo_rest_client.list_campaign.Campaign;
import com.ndp.campaignmanagement.rest_client.CustomerRC;
import com.ndp.campaignmanagement.utils.splittingCID.SplittingCustomerID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomersOfOneCampaign {
    @Autowired
    private CustomerRC customerRC;

    public List<String> getListEmails(Campaign campaign) {
        List<String> emails = new ArrayList<String>();

        List<String> cIds = new ArrayList<String>();

        cIds = SplittingCustomerID.splitId(campaign.getCustomersList());

        for (String cId : cIds) {
            CustomerForm customerForm = customerRC.getCustomerById(cId);

            String email = customerForm.getEmail();

            emails.add(email);
        }

        return emails;
    }

    public String[] getArrEmails(Campaign campaign) {
        List<String> emails = new ArrayList<String>();

        List<String> cIds = new ArrayList<String>();

        cIds = SplittingCustomerID.splitId(campaign.getCustomersList());

        for (String cId : cIds) {
            CustomerForm customerForm = customerRC.getCustomerById(cId);

            String email = customerForm.getEmail();

            emails.add(email);
        }

        String[] arrEmails = emails.toArray(new String[0]);

        return arrEmails;
    }
}
