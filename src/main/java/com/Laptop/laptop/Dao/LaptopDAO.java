package com.Laptop.laptop.Dao;

import com.Laptop.laptop.entity.Laptop;

import java.util.List;

public interface LaptopDAO {
    void save(Laptop theLaptop);

    Laptop findById(int theId);

    Laptop findByImei(long imeiNo);

    List<Laptop> fetchAll();

    void updatePrice(int theId, double newPrice);
}
