package com.Laptop.laptop.Dao.daoimpl;

import com.Laptop.laptop.Dao.LaptopDAO;
import com.Laptop.laptop.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LaptopDAOImpl implements LaptopDAO {

    private final EntityManager theManager;

    @Autowired
    public LaptopDAOImpl(EntityManager theManager) {
        this.theManager = theManager;
    }

    @Override
    @Transactional
    public void save(Laptop theLaptop) {
        theManager.persist(theLaptop);
    }

    @Override
    public Laptop findById(int theId) {
        return theManager.find(Laptop.class, theId);
    }

    @Override
    public Laptop findByImei(long imeiNo) {
        try {
            Query q = theManager.createQuery("SELECT l FROM Laptop l WHERE l.imeiNo = :imeiNo");
            q.setParameter("imeiNo", imeiNo);
            return (Laptop) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Laptop> fetchAll() {
        Query query = theManager.createQuery("SELECT l FROM Laptop l");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void updatePrice(int theId, double newPrice) {
        Laptop foundLaptop = theManager.find(Laptop.class, theId);
        if (foundLaptop == null) {
            System.out.println(" No laptop found with ID " + theId);
        } else {
            foundLaptop.setPrice(newPrice);
            System.out.println("Price updated for Laptop ID " + theId);
        }
    }
}
