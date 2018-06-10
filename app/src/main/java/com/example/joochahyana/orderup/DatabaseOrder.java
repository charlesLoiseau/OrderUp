package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

import java.util.Date;

public class DatabaseOrder extends SugarRecord {
    Date                time;
    Integer             tnumber;
    Integer             fnumber;
    Boolean             done;

    // Relationship
    DatabaseOrderState  state;
    DatabaseItems       item;

    public DatabaseOrder() {

    }

    public DatabaseOrder(Integer tnumber,Integer fnumber, DatabaseItems item, DatabaseOrderState state, Boolean done, Date time){
        this.tnumber = tnumber;
        this.fnumber = fnumber;
        this.done = done;
        this.state = state;
        this.item = item;
        this.time = time;
    }


}
