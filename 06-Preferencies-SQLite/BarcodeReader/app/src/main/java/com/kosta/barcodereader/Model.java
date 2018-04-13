package com.kosta.barcodereader;

public class Model {
    Product product;

    public Model(){}

    public Model(Product product){
        this.product = product;
    }

    public Product getProduct(){
        return this.product;
    }
}
