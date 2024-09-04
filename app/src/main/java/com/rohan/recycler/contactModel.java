package com.rohan.recycler;

import android.widget.ImageView;

public class contactModel {
    int img;
    String name,number;
    public  contactModel(int img,String name,String number){
        this.img=img;
        this.name= name;
        this.number = number;

    }

    public contactModel(String name,String number){
        this.name = name;
        this.number=number;
    }
}
