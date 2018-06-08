package com.example.joochahyana.orderup;

import java.util.Date;

public class Orders {

    Date    time;
    Integer table;
    Boolean done;
    Foods foodInfo;



    public Orders(Date time, Integer table, Boolean done,Foods foodInfo){
        this.time = time;
        this.table = table;
        this.done = done;
        this.foodInfo = foodInfo;
    }


}
