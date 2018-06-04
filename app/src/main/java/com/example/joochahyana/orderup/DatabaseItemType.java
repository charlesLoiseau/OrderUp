package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseItemType extends SugarRecord<DatabaseItemType> {
    String  name;

    public DatabaseItemType() {

    }

    public DatabaseItemType(String name) {
        this.name = name;
    }
}
