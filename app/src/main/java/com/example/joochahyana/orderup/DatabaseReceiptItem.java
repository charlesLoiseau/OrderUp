package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseReceiptItem extends SugarRecord {
    // Relationship
    DatabaseReceipt receipt;
    DatabaseMenu    menu;
    DatabaseItems   item;

    public DatabaseReceiptItem() {

    }

    public DatabaseReceiptItem(DatabaseReceipt receipt, DatabaseMenu menu, DatabaseItems item) {
        this.receipt = receipt;
        this.menu = menu;
        this.item = item;
    }


}
