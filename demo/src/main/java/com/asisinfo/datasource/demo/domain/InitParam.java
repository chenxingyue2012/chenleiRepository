package com.asisinfo.datasource.demo.domain;

import java.util.HashMap;
import java.util.Map;


public class InitParam {

    private Map<String, Object> params = new HashMap<>();

    public Object getValue(String name) {
        return params.get(name);
    }

    public void setValue(String key, Object value) {
        params.put(key, value);
    }
}
