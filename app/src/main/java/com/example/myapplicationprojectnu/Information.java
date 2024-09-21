package com.example.myapplicationprojectnu;

public class Information {
    private int id;
    private String ProductName;
    private double ProductPrice;
    private double QuantityAvailable;

    public static final String TABLE_NAME = "MYDB";
    public static final String COL_ID = "ProductId";
    public static final String COL_NAME = "ProductName";
    public static final String COL_PRICE = "ProductPrice";
    public static final String COL_AVAILABLE = "QuantityAvailable";
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + COL_ID +
            " integer primary key autoincrement," + COL_NAME +
            " text," + COL_PRICE + " text," + COL_AVAILABLE + " real)";

    public Information(int id, String ProductName, double ProductPrice, double QuantityAvailable) {
        this.id = id;
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.QuantityAvailable = QuantityAvailable;

    }
    public Information( String ProductName, double ProductPrice, double QuantityAvailable) {
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.QuantityAvailable = QuantityAvailable;

    }

    public Information() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public double getQuantityAvailable() {
        return QuantityAvailable;
    }

    public void setQuantityAvailable(double quantityAvailable) {
        QuantityAvailable = quantityAvailable;
    }
}



