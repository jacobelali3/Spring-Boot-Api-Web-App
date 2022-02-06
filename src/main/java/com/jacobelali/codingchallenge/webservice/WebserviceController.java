package com.jacobelali.codingchallenge.webservice;

import com.jacobelali.codingchallenge.business.EntryService;
import com.jacobelali.codingchallenge.data.Entries;
import com.jacobelali.codingchallenge.data.EntriesRepository;
import com.jacobelali.codingchallenge.util.DateUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;



@RestController
@RequestMapping("/api")
public class WebserviceController implements Serializable {
    private final DateUtils dateUtils;
    private final EntryService entryService;
    private final RabbitTemplate rabbitTemplate;
    private final EntriesRepository entriesRepository;
    private java.lang.System System;

    public WebserviceController(DateUtils dateUtils, EntryService entryService, RabbitTemplate rabbitTemplate, EntriesRepository entriesRepository) {
        this.dateUtils = dateUtils;
        this.entryService = entryService;
        this.rabbitTemplate = rabbitTemplate;
        this.entriesRepository = entriesRepository;
    }

    //return list of entries
    @GetMapping( "/entries")
    public List<Entries> getEntries()
    {
        return this.entryService.getEntries();

    }

    //receive entry object and send to AMQP
    @PostMapping("/entries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEntry(@RequestBody Entries entry)
    {
        rabbitTemplate.convertAndSend("entry-exchange", "entryKey", entry);
        System.out.println("Request sent successfully");

    }



}
