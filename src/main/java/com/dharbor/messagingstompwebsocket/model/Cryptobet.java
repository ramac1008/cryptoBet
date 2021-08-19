package com.dharbor.messagingstompwebsocket.model;

import javax.persistence.*;

@Entity
@Table(name = "cryptobet")
public class Cryptobet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bet")
    private String bet;

    @Column(name = "price")
    private String price;

    @Column(name = "stamp")
    private String stamp;

    @Column(name = "cycle")
    private String cycle;

    @Column(name = "win")
    private boolean win;

    @Column(name = "open")
    private boolean open;

    public Cryptobet() { }

    public Cryptobet(String name, String bet, String stamp, String price, String cycle, boolean win, boolean open) {
        this.name  = name;
        this.bet   = bet;
        this.price = price;
        this.stamp = stamp;
        this.cycle = cycle;
        this.win = win;
        this.open = open;
    }

    public long getId() { return id; }

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

    public   void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCycle() {
        return cycle;
    }
    public boolean getWin() {
        return win;
    }

    public   void setWin(boolean win) {
        this.win = win;
    }

    public boolean getOpen() {
        return open;
    }

    public   void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "cryptobet [id=" + id + ", name=" + name + ", bet=" + bet + ", stamp=" + stamp +", price="+ price +", cycle="+ cycle +" win =" + win +" open =" + open +"]";
    }

}

