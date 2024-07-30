package com.example.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class RestResult {
    /** Return code */
    private int result;

    /** Error map
     * key: field name
     * value: error message
     */
    private Map<String, String> errors;

}
