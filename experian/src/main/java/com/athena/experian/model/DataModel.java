package com.athena.experian.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class DataModel {

    @Id
    @SequenceGenerator(
            name = "dataModel_sequence",
            sequenceName  = "dataModel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dataModel_sequence"
    )
    private Integer msg_id;

    private String company_name;
    private LocalDateTime registrationDate;
    private Integer score;
    private Integer directors_count;
    private LocalDateTime lastUpdated;

    public DataModel(Integer msg_id,
                     String company_name,
                     LocalDateTime registrationDate,
                     LocalDateTime lastUpdated,
                     Integer directors_count
                     ) {
        this.msg_id = msg_id;
        this.company_name = company_name;
        this.registrationDate = registrationDate;
        this.score = 0;
        this.directors_count = directors_count;
        this.lastUpdated = lastUpdated;
    }

    public DataModel(String company_name,
                     LocalDateTime registrationDate,
                     Integer directors_count,
                     LocalDateTime lastUpdated) {
        this.company_name = company_name;
        this.registrationDate = registrationDate;
        this.score = 0;
        this.directors_count = directors_count;
        this.lastUpdated = lastUpdated;
    }

    public DataModel(){ }

    public Integer getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Integer msg_id) {
        this.msg_id = msg_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDirectors_count() {
        return directors_count;
    }

    public void setDirectors_count(Integer directors_count) {
        this.directors_count = directors_count;
    }

    public LocalDateTime getLastUpdated() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "msg_id=" + msg_id +
                ", company_name='" + company_name + '\'' +
                ", registrationDate=" + registrationDate +
                ", score=" + score +
                ", directors_count=" + directors_count +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
