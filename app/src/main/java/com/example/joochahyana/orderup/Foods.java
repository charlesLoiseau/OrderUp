package com.example.joochahyana.orderup;



public class Foods {


    public String name;
    public String description;
    public Double price;
    public Long id;
    public byte[] photo;
    public Integer stock;

    // 0 : Appetizer, 1 : Beverage, 2 : Dessert, 3 : Dish

    public Foods(String name, Long id, String description, Double price, byte[] photo,Integer stock){

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.stock = stock;

    }

}
