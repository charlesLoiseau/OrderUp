package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

import java.util.Date;

public class DatabaseOrders extends SugarRecord {
    Date                time;
    Integer             table;
    Boolean             done;

    // Relationship
    DatabaseOrderState  state;
    DatabaseItems       item;

    public DatabaseOrders() {

    }

    public DatabaseOrders(Date time, Integer table, Boolean done, DatabaseOrderState state, DatabaseItems item) {
        this.time = time;
        this.table = table;
        this.done = done;
        this.state = state;
        this.item = item;
    }

}
