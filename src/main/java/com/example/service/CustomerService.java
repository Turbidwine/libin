package com.example.service;

import com.example.model.CustomerCampaignTag;

import java.util.List;

public interface CustomerService {
    List<CustomerCampaignTag> saveAll (List<CustomerCampaignTag> campaignTagList);
}
