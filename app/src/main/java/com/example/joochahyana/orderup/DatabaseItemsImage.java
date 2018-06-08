package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseItemsImage  extends SugarRecord {

    byte[] imageStream;


    public DatabaseItemsImage() {
    }

    public DatabaseItemsImage(byte[] imageStream) {
        this.imageStream = imageStream;
    }
}
