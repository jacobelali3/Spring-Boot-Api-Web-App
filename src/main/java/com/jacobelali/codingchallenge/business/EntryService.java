package com.jacobelali.codingchallenge.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.jacobelali.codingchallenge.data.Entries;
import com.jacobelali.codingchallenge.data.EntriesRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryService {


    private final EntriesRepository entriesRepository;


    public EntryService(EntriesRepository entriesRepository) {
        this.entriesRepository = entriesRepository;
    }

    //get all entries and sort by EntryId
    public List<Entries> getEntries() {
        Iterable<Entries> entries = this.entriesRepository.findAll();
        List<Entries> entriesList = new ArrayList<>();
        entries.forEach(entry -> {entriesList.add(entry);});
        entriesList.sort(new Comparator<Entries>() {
            @Override
            public int compare(Entries o1, Entries o2) {
                if(o1.getEntryId().equals(o2.getEntryId())){
                    return o1.getEntryId().compareTo(o2.getEntryId());
                }
                return o1.getEntryId().compareTo(o2.getEntryId());
            }

        });


        return entriesList;
    }

    //If Entry is not null, save it to entry repository
    public void saveEntry(Entries entry)throws Exception
    {
        if (entry == null)
        {
            throw new RuntimeException("Entry cannot be null");
        }
        this.entriesRepository.save(entry);



    }


}

