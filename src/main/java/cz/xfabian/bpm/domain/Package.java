package cz.xfabian.bpm.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Norbert Fábián on 6/3/2017.
 */
@Entity
@Table
public class Package {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Customer sender;
    @ManyToOne
    private Customer receiver;
    @Column
    private String code;
    @Column
    private String state;
    @Column
    private String location;
    @Column
    private boolean changeable;
    @OneToMany(mappedBy = "pack")
    private List<Log> logs;

    @OneToOne
    private Rma rma;

    @OneToOne
    private Insurance insurance;

    public Package() {
        this.logs = new ArrayList<>();
    }

    public Package(Customer sender, Customer receiver, String code, String state, String location, boolean changeable) {
        this.sender = sender;
        this.receiver = receiver;
        this.code = code;
        this.state = state;
        this.location = location;
        this.changeable = changeable;
        this.logs = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rma getRma() {
        return rma;
    }

    public void setRma(Rma rma) {
        this.rma = rma;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isChangeable() {
        return changeable;
    }

    public void setChangeable(boolean changeable) {
        this.changeable = changeable;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
