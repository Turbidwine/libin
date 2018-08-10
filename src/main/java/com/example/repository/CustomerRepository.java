package com.example.repository;

import com.example.model.CustomerCampaignTag;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<CustomerCampaignTag,String> {
}
