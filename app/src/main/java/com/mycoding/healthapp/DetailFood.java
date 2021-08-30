package com.mycoding.healthapp;

public class DetailFood {
    public String title, calorie, right, worst, consume, image;
    public DetailFood (){

    }

    public DetailFood(String title, String calorie, String right, String worst, String consume, String image){
        this.title =title;
        this.calorie = calorie;
        this.right = right;
        this.worst = worst;
        this.consume = consume;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getCalorie() {
        return calorie;
    }

    public String getRight() {
        return right;
    }

    public String getWorst() {
        return worst;
    }

    public String getConsume() {
        return consume;
    }

    public String getImage() {
        return image;
    }
}
