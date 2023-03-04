package com.javarush.context.lesson7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NamedQuery(name = "Country.findById", query = "select c from Country c where id = :id")
@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    private Long id;

    @Column(name = "NAME_RU")
    private String nameRu;

    @Column(name = "NAME_EN")
    private String nameEn;

    @Column(name = "NAME_ES")
    private String nameEs;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", nameRu='" + nameRu + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", nameEs='" + nameEs + '\'' +
                '}';
    }
}
