package com.pwllc.rest;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by carl_downs on 10/7/14.
 */
public class CassResult {
    @JsonProperty
    private String id;

    @JsonProperty
    private String doc;

    @JsonProperty
    private Map<String,String> properties = new HashMap<>();

    public CassResult() {
        // Jackson deserialization
    }

    public CassResult(String id, String doc) {
        this.id = id;
        this.doc = doc;
    }

    public void setProperty (String key, String value) {
        final String displaced = properties.put(key, value);
    }

    public String getProperty (String key) {
        return properties.get(key);
    }
}
