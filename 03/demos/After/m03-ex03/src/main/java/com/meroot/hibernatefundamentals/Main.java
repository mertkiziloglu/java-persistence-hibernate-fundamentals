package com.meroot.hibernatefundamentals;

import com.meroot.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.PasswordAuthentication;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex03");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger mert = new Passenger(1, "Mert Kiziloglu");
        mert.setCity("Istanbul");
        mert.setStreet("1881 Ataturk");
        mert.setNumber("1881");
        mert.setZipCode("123456");
        mert.setAreaCode("302");
        mert.setPrefix("231");
        mert.setLineNumber("951235");
        em.persist(mert);


        em.getTransaction().commit();
        emf.close();
    }
}
