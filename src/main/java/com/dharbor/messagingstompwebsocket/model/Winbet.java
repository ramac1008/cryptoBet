package com.dharbor.messagingstompwebsocket.model;

import javax.persistence.*;

@Entity
@Table(name = "Winbet")
public class Winbet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bet")
    private String bet;

    @Column(name = "stamp")
    private String stamp;

    @Column(name = "price")
    private String price;

    @Column(name = "open")
    private boolean open;

    public Winbet() { }

    public Winbet(String name, String bet, String stamp, String price, boolean open ) {

        this.name  = name;
        this.bet   = bet;
        this.stamp = stamp;
        this.price = price;
        this.open = open;
    }

    public long getID() {
        return id;
    }

    public   void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public   void setBet(String bet) {
        this.bet = bet;
    }
    public String getBet() {
        return bet;
    }

    public   void setStamp(String stamp) {
        this.stamp = stamp;
    }
    public String getStamp() {
        return stamp;
    }

    public   void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    public   void setOpen(boolean open) {
        this.open = open;
    }
    public boolean getOpen() {
        return open;
    }

    @Override
    public String toString() {
        return "winbet [id=" + id +", name=" + name + ", bet=" + bet + ", stamp=" + stamp +", price="+ price+", open="+ open +"]";
    }

}

