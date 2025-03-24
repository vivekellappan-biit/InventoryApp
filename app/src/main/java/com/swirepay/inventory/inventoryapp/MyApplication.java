package com.swirepay.inventory.inventoryapp;

import com.swirepay.inventory.inventoryapp.model.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class MyApplication {

    public static MyApplication single_instance = null;
    public String s;

    public List<ProductItem> mPoductItemList = new ArrayList<>();

    private MyApplication()
    {
        s = "Hello I am a string part of Singleton class";
    }

    public static synchronized MyApplication getInstance()
    {
        if (single_instance == null)
            single_instance = new MyApplication();

        return single_instance;
    }

}
