package com.example.entity;

import lombok.Data;

@Data
public class Condition {
    private String relation;

    private String operation;

    private String tagName;

    private String tagValue;
}
