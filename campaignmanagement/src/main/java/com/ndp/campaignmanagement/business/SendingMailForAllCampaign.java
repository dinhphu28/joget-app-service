package com.ndp.campaignmanagement.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import com.ndp.campaignmanagement.pojo_rest_client.list_campaign.Campaign;
import com.ndp.campaignmanagement.pojo_rest_client.list_campaign.CampaignsRaw;
import com.ndp.campaignmanagement.rest_client.CampaignRC;
import com.ndp.campaignmanagement.utils.mail.SendMailUtil;
import com.ndp.campaignmanagement.utils.splittingCID.SplittingCustomerID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendingMailForAllCampaign {
    @Autowired
    private SendMailUtil sendMailUtil;

    @Autowired
    private CustomersOfOneCampaign customersOfOneCampaign;

    @Autowired
    private CampaignRC campaignRC;

    public Boolean sendMails() {
        Boolean kk = false;

        CampaignsRaw campaignsRaw = campaignRC.getAllData();

        List<Campaign> campaigns = campaignsRaw.getData();

        for (Campaign campaign : campaigns) {
            LocalDate today = LocalDate.now();

            if((today.isAfter(campaign.getDateStart()) || today.isEqual(campaign.getDateStart())) && (today.isBefore(campaign.getDateFinish()) || today.isEqual(campaign.getDateFinish()))) {
                
                Boolean activateSendingMail = false;

                if(campaign.getCampaignType().equals("Daily")) {
                    activateSendingMail = true;
                } else if(campaign.getCampaignType().equals("Weekly")) {
                    List<String> daysOfWeek = new ArrayList<String>();

                    daysOfWeek = SplittingCustomerID.splitId(campaign.getDaysOfWeek());
                    // System.out.println(daysOfWeek);

                    for (String weekday : daysOfWeek) {
                        // System.out.println(weekday.toUpperCase());
                        // System.out.println(today.getDayOfWeek().toString().toUpperCase());
                        if(weekday.toUpperCase().equals(today.getDayOfWeek().toString().toUpperCase())) {
                            activateSendingMail = true;
                        }
                    }
                } else if(campaign.getCampaignType().equals("Monthly")) {
                    if(today.getDayOfMonth() == Integer.parseInt(campaign.getDayOfMonth())) {
                        activateSendingMail = true;
                    }
                }

                if(activateSendingMail) {
                    try {
                        sendMailUtil.sendHtmlEmail(campaign.getCampaignContent(), customersOfOneCampaign.getArrEmails(campaign));
        
                        kk = true;
                    } catch (MessagingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

        return kk;
    }
}
