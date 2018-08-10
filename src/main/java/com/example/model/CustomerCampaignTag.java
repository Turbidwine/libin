package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "customer", type = "customerInfo")
public class CustomerCampaignTag {
    @Id
    private String customerId;

    private String cardNum;

    private String memberLevel;

    private String name;

    private String gender;

    private String age;

    private Date birthday;

    private Date registerTime;

    private String registerBrand;

    private String registerStore;
}
