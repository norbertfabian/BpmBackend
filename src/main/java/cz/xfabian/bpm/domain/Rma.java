package cz.xfabian.bpm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Norbert Fábián on 6/6/2017.
 */
@Entity
@Table
public class Rma {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String email;

    @Column
    private String statement;

    @Column
    private boolean approved;

    @Column
    private String note;

    @Column
    private String description;

    @Column
    private int harm;

    @Column
    private int moneyToRefund;

    @OneToOne(mappedBy = "rma")
    @Transient
    @JsonIgnore
    private Package pack;

    public Rma() {
    }

    public Rma(String email, String statement, boolean approved, String note, String description, int harm, Package pack) {
        this.email = email;
        this.statement = statement;
        this.approved = approved;
        this.note = note;
        this.description = description;
        this.harm = harm;
        this.pack = pack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHarm() {
        return harm;
    }

    public void setHarm(int harm) {
        this.harm = harm;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public int getMoneyToRefund() {
        return moneyToRefund;
    }

    public void setMoneyToRefund(int moneyToRefund) {
        this.moneyToRefund = moneyToRefund;
    }
}
