package com.lxisoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Problem implements Serializable{


    private static final long serialVersionUID = 875002956757661492L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String question;

    @Column
    private String option1;

    @Column
    private String option2;

    @Column
    private String option3;

    @Column
    private String option4;

    @Column
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getoption1() {
        return option1;
    }

    public void setoption1(String option1) {
        this.option1 = option1;
    }

    public String getoption2() {
        return option2;
    }

    public void setoption2(String option2) {
        this.option2 = option2;
    }

    public String getoption3() {
        return option3;
    }

    public void setoption3(String option3) {
        this.option3 = option3;
    }

    public String getoption4() {
        return option4;
    }

    public void setoption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
