package com.meroot.hibernatefundamentals;

import com.meroot.hibernatefundamentals.airport.Payment;
import com.meroot.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex04");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Ticket ticket = new Ticket();
        ticket.setNumber("AA1234");
        ticket.setOrigin("London");
        ticket.setDestination("Bucharest");

        Payment payment = new Payment();
        payment.setTicket(ticket);
        payment.setAmount(200);

        em.getTransaction().commit();
        emf.close();
    }
}
