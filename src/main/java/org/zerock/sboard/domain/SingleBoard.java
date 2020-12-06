package org.zerock.sboard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SingleBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String title;

    private String content;

    private String writer;

    public void changeTitle(String title){
        this.title = title;
    }
    

}