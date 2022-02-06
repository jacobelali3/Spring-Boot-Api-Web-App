package com.jacobelali.codingchallenge.util;

import java.util.Date;

import com.jacobelali.codingchallenge.business.EntryService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private  final EntryService entryService;
    private final DateUtils dateUtils;

    public AppStartupEvent(EntryService entryService, DateUtils dateUtils) {
        this.entryService = entryService;
        this.dateUtils = dateUtils;
    }

    //if I want to run anything on startup
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
       //Date date = this.dateUtils.createDateFromDateString("2022-01-01");


    }
}
