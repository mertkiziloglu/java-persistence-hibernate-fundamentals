package com.meroot.hibernatefundamentals;

import com.meroot.hibernatefundamentals.airport.Passenger;
import com.meroot.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex06");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Passenger john = new Passenger("John Smith");

        Ticket ticket1 = new Ticket("AA1234");
        Ticket ticket2 = new Ticket("BB5678");

        john.addTicket(ticket1);
        john.addTicket(ticket2);

        em.persist(john);

        em.getTransaction().commit();
        emf.close();
    }
}
