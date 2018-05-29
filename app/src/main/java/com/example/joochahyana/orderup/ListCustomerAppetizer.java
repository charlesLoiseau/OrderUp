package com.example.joochahyana.orderup;

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class ListCustomerAppetizer {
    public String name;
    public String description;
    public String price;
    public Integer photo;

    public ListCustomerAppetizer(String name, String description, String price, Integer photo){
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }
}
