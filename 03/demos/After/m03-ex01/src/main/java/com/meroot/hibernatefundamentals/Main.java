package com.meroot.hibernatefundamentals;

import com.meroot.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger john = new Passenger(1, "John Smith", "3 Flowers Street, Boston");
        Passenger mert = new Passenger(2, "Mert Kiziloglu", "1881 Ataturk, Istanbul");
        em.persist(john);
        em.persist(mert);

        em.getTransaction().commit();
        emf.close();
    }
}
