package com.Laptop.laptop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop_table")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptop_id")
    private int id;

    @Column(name = "laptop_brand")
    private String brand;

    @Column(name = "laptop_model")
    private String model;

    @Column(name = "imei_no", unique = true)
    private long imeiNo;

    @Column(name = "laptop_processor")
    private String processor;

    @Column(name = "laptop_price")
    private double price;

    public Laptop() {}

    public Laptop(String brand, String model, long imeiNo, String processor, double price) {
        this.brand = brand;
        this.model = model;
        this.imeiNo = imeiNo;
        this.processor = processor;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getImeiNo() {
        return imeiNo;
    }

    public void setImeiNo(long imeiNo) {
        this.imeiNo = imeiNo;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", imeiNo=" + imeiNo +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                '}';
    }
}
