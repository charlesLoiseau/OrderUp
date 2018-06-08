package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

import java.util.Date;

public class DatabaseReceipt extends SugarRecord {
    Date    time;
    Integer table;
    Double  price;
    Boolean paid;

    public DatabaseReceipt() {

    }

    public DatabaseReceipt(Date time, Integer table, Double price, Boolean paid) {
        this.time = time;
        this.table = table;
        this.price = price;
        this.paid = paid;
    }
}
