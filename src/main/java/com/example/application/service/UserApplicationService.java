package com.example.application.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserApplicationService {

    /** Generate a gender Map */
    public Map<String, Integer> getGenderMap() {
        Map<String, Integer> genderMap = new LinkedHashMap<>();
        genderMap.put("male", 1);
        genderMap.put("female", 2);
        return genderMap;
    }
}
