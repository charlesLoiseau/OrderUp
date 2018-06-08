package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseItems extends SugarRecord {

    String              name;
    Double              price;
    String              description;
    Integer             stock;

    // Relationship
    DatabaseItemType    itemType;
    DatabaseItemsImage  itemImage;

    public DatabaseItems() {

    }

    public DatabaseItems(DatabaseItemType itemType, String name, Double price, String description, Integer stock,DatabaseItemsImage itemImage) {
        this.itemType = itemType;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.itemImage = itemImage;
    }
}
