package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseUserType extends SugarRecord {
    String  name;

    public DatabaseUserType() {

    }

    public DatabaseUserType(String name) {
        this.name = name;
    }
}
