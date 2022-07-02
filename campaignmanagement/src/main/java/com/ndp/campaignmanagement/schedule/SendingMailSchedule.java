package com.ndp.campaignmanagement.schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ndp.campaignmanagement.business.SendingMailForAllCampaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendingMailSchedule {
    @Autowired
    private SendingMailForAllCampaign sendingMailForAllCampaign;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
    
    // @Scheduled(initialDelay = 60 * 1000, fixedDelay = 90 * 1000)
    // @Scheduled(cron = "0 20 1 * * *")
    // public void writeCurrentTime() {
        
    //     Date now = new Date();
        
    //     String nowString = df.format(now);
        
    //     System.out.println("Now is: "+ nowString);
        
    // }

    // @Scheduled(initialDelay = 60 * 1000, fixedDelay = 90 * 1000)
    @Scheduled(cron = "0 43 12 * * *")
    public void sendMails() {
        sendingMailForAllCampaign.sendMails();
    }
}
