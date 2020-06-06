package com.lxisoft.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "EXM_TBL")
public class Exam implements Serializable 
{
	private static final long serialVersionUID = -3465813074586302847L;
	 
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
    
    @Transient
    private String option;
 
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
 
    public String getOption1() {
        return option1;
    }
 
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    
    public String getOption2() {
        return option2;
    }
 
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    
    public String getOption3() {
        return option3;
    }
 
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    
    public String getOption4() {
        return option4;
    }
 
    public void setOption4(String option4) {
        this.option4 = option4;
    }
 
    public String getAnswer() {
        return answer;
    }
 
    public void setAnswer(String answer) {
        this.answer = answer;
    }
 
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
}
