package com.example.joochahyana.orderup;

public class Bills {
    public Integer tNumber;
    public double price;
    private Long id;

    public Bills(Integer tNumber, double price){
        this.tNumber = tNumber;
        this.price = price;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
