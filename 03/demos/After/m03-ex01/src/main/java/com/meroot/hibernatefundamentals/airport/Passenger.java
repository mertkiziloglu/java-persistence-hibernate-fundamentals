package com.meroot.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable(name = "ADDRESSES",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
public class Passenger {
    // tablolar farkli olsa bile ayni entity class'inda tutulabilir
    @Id
    @Column(name = "PASSENGER_ID")
    private int id;

    @Column(name = "PASSENGER_NAME", table = "PASSENGERS")
    private String name;

    @Column(name = "PASSENGER_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(25) not null")  //very important
    private String address;

    public Passenger(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Passenger() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
