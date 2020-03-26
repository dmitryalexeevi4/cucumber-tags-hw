package com.github.dmitryalexeevi4.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommonData {
    private static CommonData INSTANCE;

    private final Map<String, Object> pageData;

    public static CommonData instance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new CommonData();
        }
        return INSTANCE;
    }

    private CommonData() {
        pageData = new HashMap<>();
    }

    public void saveData(String key, Object data) {
        pageData.put(key, data);
    }

    public void getData(String key) {
        pageData.get(key);
    }
}
