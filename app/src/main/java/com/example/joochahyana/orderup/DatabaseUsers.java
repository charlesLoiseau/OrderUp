package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseUsers extends SugarRecord<DatabaseUsers> {
    String              name;

    // Relationship
    DatabaseUserType    type;

    public DatabaseUsers() {

    }

    public DatabaseUsers(String name, DatabaseUserType type) {
        this.name = name;
        this.type = type;
    }
}
