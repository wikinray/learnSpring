package com.github.winkiray.design.pattern.factory.chouxiang;

public class ProductTest {

    public static void main(String[] args){
        IProductFactory productFactory=new ProductFactory();
        IProduct product=productFactory.createProduct("TWO");
        product.color();
    }
}
