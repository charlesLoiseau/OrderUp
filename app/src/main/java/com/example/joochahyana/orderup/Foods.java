package com.example.joochahyana.orderup;



public class Foods {

    public static final int Appetizer = 0;
    public static final int Beverage = 1;
    public static final int Dessert = 2;
    public static final int Dish = 3;

    public String name;
    public String description;
    public String price;
    public Integer photo;
    public Integer type;
    // 0 : Appetizer, 1 : Beverage, 2 : Dessert, 3 : Dish

    public Foods(String name, String description, String price, Integer photo,Integer type){

        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.type = type;
    }

}
