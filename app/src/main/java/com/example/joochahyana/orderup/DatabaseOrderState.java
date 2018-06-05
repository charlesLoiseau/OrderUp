package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseOrderState extends SugarRecord {
    String  name;

    public DatabaseOrderState() {

    }

    public DatabaseOrderState(String name) {
        this.name = name;
    }
}
