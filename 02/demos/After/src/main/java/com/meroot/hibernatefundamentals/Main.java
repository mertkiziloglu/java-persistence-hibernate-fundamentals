package com.meroot.hibernatefundamentals;

import com.meroot.hibernatefundamentals.airport.Airport;
import com.meroot.hibernatefundamentals.airport.Passenger;
import com.meroot.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();  //begin transaction
        Airport airport = new Airport(1, "Henri Coanda");
        Airport airport2 = new Airport(2, "Ataturk Havalimanı");
        Passenger mertKiziloglu = new Passenger(3, "Mert Kiziloglu");

        Passenger john = new Passenger(1, "John Smith");
        john.setAirport(airport);
        Passenger mike = new Passenger(2, "Michael Johnson");
        mike.setAirport(airport);
        mertKiziloglu.setAirport(airport2);
        airport.addPassenger(john);
        airport.addPassenger(mike);
        airport2.addPassenger(mertKiziloglu);

        Ticket ticket1 = new Ticket(1, "AA1234");
        ticket1.setPassenger(john);

        Ticket ticket2 = new Ticket(2, "BB5678");
        ticket2.setPassenger(john);


        john.addTicket(ticket1);
        john.addTicket(ticket2);

        Ticket ticket3 = new Ticket(3, "CC0987");
        ticket3.setPassenger(mike);
        mike.addTicket(ticket3);

        Ticket ticket = new Ticket(4, "CC9012");
        mertKiziloglu.addTicket(ticket);
        ticket.setPassenger(mertKiziloglu);


        em.persist(airport);//future updates to the entity will be tracked by the entity manager
        em.persist(airport2);
        em.persist(john);
        em.persist(mike);
        em.persist(mertKiziloglu);
        em.persist(ticket);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();//commit transaction
        emf.close();

    }
}
