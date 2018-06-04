package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseItems extends SugarRecord<DatabaseItems> {
    String              name;
    Double              price;
    String              description;
    Integer             stock;

    // Relationship
    DatabaseItemType    itemType;

    public DatabaseItems() {

    }

    public DatabaseItems(DatabaseItemType itemType, String name, Double price, String description, Integer stock) {
        this.itemType = itemType;

        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
}
