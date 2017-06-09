package cz.xfabian.bpm.domain;

import javax.persistence.*;

/**
 * Created by Norbert Fábián on 6/6/2017.
 */
@Entity
@Table
public class Insurance {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "rma")
    @Transient
    private Package pack;

    @Column
    private int highestCoverage;

    @Column
    private String insuranceType;

    public Insurance() {
    }

    public Insurance(Package pack, int highestCoverage, String insuranceType) {
        this.pack = pack;
        this.highestCoverage = highestCoverage;
        this.insuranceType = insuranceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public int getHighestCoverage() {
        return highestCoverage;
    }

    public void setHighestCoverage(int highestCoverage) {
        this.highestCoverage = highestCoverage;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}
