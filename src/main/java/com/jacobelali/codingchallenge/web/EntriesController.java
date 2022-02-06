package com.jacobelali.codingchallenge.web;
import com.jacobelali.codingchallenge.business.EntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//this controller returns data to the html templates
@Controller
@RequestMapping("/entries")
public class EntriesController {
    private final EntryService entryService;

    public EntriesController(EntryService entryService) {
        this.entryService = entryService;
    }

    //returns entries to view template
    @RequestMapping(method = RequestMethod.GET)
    public String getEntries(Model model)
    {
        model.addAttribute("entries", this.entryService.getEntries());
        return "entriesview";

    }

}
