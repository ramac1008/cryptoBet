package com.dharbor.messagingstompwebsocket.model;

import javax.persistence.*;

@Entity
@Table(name = "Winner")
public class Winner {

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

    @Column(name = "cycle")
    private String cycle;

    @Column(name = "open")
    private boolean open;

    public Winner() { }

    public Winner(String name, String bet, String stamp, String price, String cycle, boolean open ) {
        this.name  = name;
        this.bet   = bet;
        this.stamp = stamp;
        this.price = price;
        this.cycle = cycle;
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

    public   void setCycle(String cyclo) {
        this.cycle= cycle;
    }
    public String getCycle() {
        return cycle;
    }

    public   void setOpen(boolean open) {
        this.open = open;
    }
    public boolean getOpen() {
        return open;
    }

    @Override
    public String toString() {
        return "winner [id=" + id +", name=" + name + ", bet=" + bet + ", stamp=" + stamp +", price="+ price+", cycle="+ cycle+", open="+ open +"]";
    }

}

