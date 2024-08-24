package com.example.appwithspinner;

public class productFactory {
    public static String[] getProduct(int categoryPosition){
        if(categoryPosition==1){
            return new String[]{"Light","Lamp","Laptop","Charger"};
        }
        else if(categoryPosition==2){
            return new String[]{"Pizza","Sandwitch","Burger","Cold Coffee"};
        }
        else if(categoryPosition==3){
            return new String[]{"Teddy","Flower","Guiter"};
    }
        else if(categoryPosition==4){
            return new String[]{"Shirt","Pant","TShirt","Jeans","Formal"};
        }
        else{
            return new String[]{};
        }

    }
}