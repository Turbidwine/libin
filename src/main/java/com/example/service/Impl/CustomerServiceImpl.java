package com.example.service.Impl;

import com.example.model.CustomerCampaignTag;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setBookRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<CustomerCampaignTag> saveAll(List<CustomerCampaignTag> campaignTagList) {
        return (List<CustomerCampaignTag>)customerRepository.saveAll(campaignTagList);
    }
}
