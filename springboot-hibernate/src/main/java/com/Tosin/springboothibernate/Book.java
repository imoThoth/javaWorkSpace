package com.Tosin.springboothibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //what does @entiity do
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    public Book(Long id, String name){
//        this.id = id;
//        this.name = name;
//    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
