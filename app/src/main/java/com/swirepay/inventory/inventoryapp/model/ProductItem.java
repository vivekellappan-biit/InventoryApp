package com.swirepay.inventory.inventoryapp.model;

public class ProductItem {
    private String id;
    private String name;
    private String qty;


    public ProductItem() {

    }


    public ProductItem(String id, String name, String qty, String price, String total) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public String getTotal() {
        return total;
    }

    private String price;
    private String total;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
