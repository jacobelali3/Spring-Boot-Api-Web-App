package com.jacobelali.codingchallenge.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntriesRepository extends ElasticsearchRepository<Entries, String> {

}
