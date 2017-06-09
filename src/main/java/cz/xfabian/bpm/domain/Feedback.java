package cz.xfabian.bpm.domain;

import javax.persistence.*;

/**
 * Created by Norbert Fábián on 6/9/2017.
 */
@Entity
@Table
public class Feedback {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String code;

    @Column
    private String text;

    public Feedback() {
    }

    public Feedback(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
