package com.hcm.sale_laptop.data.model.other;

import java.util.List;

public class SearchHistoryModel {
    private List<String> stringList;

    public SearchHistoryModel(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
