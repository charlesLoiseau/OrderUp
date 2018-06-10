package com.example.joochahyana.orderup;

import java.util.Date;

public class Orders {

    Date    time;
    Integer tnumber;
    Boolean done;
    Foods foodInfo;
    Integer fnumber;// number of ordered food
    Long id;


    public Orders(Date time, Integer tnumber, Boolean done,Foods foodInfo,Integer num,Long id){
        this.time = time;
        this.tnumber = tnumber;
        this.done = done;
        this.foodInfo = foodInfo;
        this.fnumber = num;
        this.id = id;
    }


}
