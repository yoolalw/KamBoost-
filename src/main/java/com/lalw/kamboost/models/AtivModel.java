package com.lalw.kamboost.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="atividades")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AtivModel {
    @GeneratedValue
    @Id
    private Integer idAtiv;

    private String nomeAtiv;
    private String status;


}
