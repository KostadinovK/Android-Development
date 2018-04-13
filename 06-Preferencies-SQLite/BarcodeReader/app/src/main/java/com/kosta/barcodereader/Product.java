package com.kosta.barcodereader;

public class Product {
    String code;
    String product_name;
    String ingredients_text;

    public Product(){}

    public Product(String code, String product_name, String ingredients_text) {
        this.code = code;
        this.product_name = product_name;
        this.ingredients_text = ingredients_text;
    }

    public String getCode() {
        return code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getIngredients_text() {
        return ingredients_text;
    }

    @Override
    public String toString() {
        return "Code: " + this.code + " Name: " + this.product_name + "Ingredients: " + this.ingredients_text;
    }
}
