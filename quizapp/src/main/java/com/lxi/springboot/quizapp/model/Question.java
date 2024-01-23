package com.lxi.springboot.quizapp.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question")
public class Question{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "Question")
    private String question;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "options_id")
    private Option option;
    
    //should only relate with foreign key
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ans_id", referencedColumnName = "answer_id")
    private Answer answer;
    
}
