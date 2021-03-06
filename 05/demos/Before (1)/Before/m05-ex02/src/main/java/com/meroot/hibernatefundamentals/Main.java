package com.meroot.hibernatefundamentals;

import com.meroot.hibernatefundamentals.airport.OneWayTicket;
import com.meroot.hibernatefundamentals.airport.Passenger;
import com.meroot.hibernatefundamentals.airport.ReturnTicket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m05.ex02");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger john = new Passenger("John Smith");

        OneWayTicket oneWayTicket = new OneWayTicket();
        oneWayTicket.setNumber("AA1234");
        oneWayTicket.setLatestDepartureDate(LocalDate.of(2021, 3, 20));
        oneWayTicket.setPassenger(john);

        ReturnTicket returnTicket = new ReturnTicket();
        returnTicket.setNumber("BB5678");
        returnTicket.setLatestReturnDate(LocalDate.of(2022, 1, 31));
        returnTicket.setPassenger(john);

        em.getTransaction().commit();
        emf.close();
    }
}
