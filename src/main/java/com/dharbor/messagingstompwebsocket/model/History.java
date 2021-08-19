package com.dharbor.messagingstompwebsocket.model;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bet")
    private String bet;

    @Column(name = "stamp")
    private String stamp;

    @Column(name = "cycle")
    private String cycle;

    public History() { }

    public History(String name, String bet, String stamp, String cycle) {
        this.name  = name;
        this.bet   = bet;
        this.stamp = stamp;
        this.cycle = cycle;

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

    public   void setCycle(String cycle) {
        this.cycle = cycle;
    }
    public String getCycle() {
        return cycle;
    }

    @Override
    public String toString() {
        return "history [id=" + id + ", name=" + name + ", bet=" + bet + ", stamp=" + stamp +", cycle="+ cycle +"]";
    }

}

