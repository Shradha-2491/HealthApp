package com.mycoding.healthapp;

public class DetailRecipe {
    public String title, time, ingredient, method, image;
    public DetailRecipe (){

    }

    public DetailRecipe(String title, String time, String ingredient, String method, String image){
        this.title =title;
        this.time = time;
        this.ingredient = ingredient;
        this.method = method;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getMethod() {
        return method;
    }

    public String getImage() {
        return image;
    }
}
