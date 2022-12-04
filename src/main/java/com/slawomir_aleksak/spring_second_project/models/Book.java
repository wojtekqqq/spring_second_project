package com.slawomir_aleksak.spring_second_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
   public String toString() {
       return "Book [id=" + id + ", title=" + title + "]";
   }

    }
//    <li class="list-group-item">${book} <span class="badge">12</span></li>
// }
