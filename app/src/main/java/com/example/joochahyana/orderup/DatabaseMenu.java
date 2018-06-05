package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseMenu extends SugarRecord {
    String  name;
    Double  price;

    public DatabaseMenu() {

    }

    public DatabaseMenu(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
