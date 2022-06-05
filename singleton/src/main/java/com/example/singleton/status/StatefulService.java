package com.example.singleton.status;

public class StatefulService {

    public int order(String name, int price) {
        return price;         // 문제 지점
    }

    private int price;

//    public void order(String name, int price) {
//        this.price = price;         // 문제 지점
//    }

    public int getPrice() {
        return price;
    }
}
