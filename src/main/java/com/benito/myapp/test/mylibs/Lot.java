/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.benito.myapp.test.mylibs;

/**
 *
 * @author keane
 */
public class Lot {
    
    private int block;
    private int lotNumber;
    private double size;
    private double price;
    private String status;

    public Lot(int block, int lotNumber, double size, double price, String status) {
        this.block = block;
        this.lotNumber = lotNumber;
        this.size = size;
        this.price = price;
        this.status = "available";
    }

    Lot(int block, int lotNumber, int i, int i0) {
        
    }

    public int getBlock() {
        return block;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String toString() {
        return "Block: " + block + ", Lot: " + lotNumber + ", Size: " + size + " sq.m, Price: $" + price + ", Status: " + status;
    }
    
    
    
    
}
