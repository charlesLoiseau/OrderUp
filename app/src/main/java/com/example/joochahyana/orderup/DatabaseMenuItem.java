package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseMenuItem extends SugarRecord {
    // Relationship
    DatabaseItems   item;
    DatabaseMenu    menu;

    public DatabaseMenuItem() {

    }

    public DatabaseMenuItem(DatabaseItems item, DatabaseMenu menu) {
        this.item = item;
        this.menu = menu;
    }
}
