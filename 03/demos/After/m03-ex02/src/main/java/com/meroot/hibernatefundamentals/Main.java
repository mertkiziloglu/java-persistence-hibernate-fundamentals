package com.meroot.hibernatefundamentals;

import com.meroot.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.PasswordAuthentication;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex02");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger john = new Passenger(1, "John Smith");
        john.setCity("Boston");
        john.setStreet("Flowers Street");
        john.setNumber("3");
        john.setZipCode("012345");
        em.persist(john);

        Passenger mert = new Passenger(2, "Mert Kiziloglu");
        mert.setCity("Istanbul");
        mert.setStreet("1881 Ataturk");
        mert.setNumber("1881");
        mert.setZipCode("123456");
        em.persist(mert);

        em.getTransaction().commit();
        emf.close();
    }
}
