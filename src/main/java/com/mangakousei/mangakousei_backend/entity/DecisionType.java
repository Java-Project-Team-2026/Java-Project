package com.mangakousei.mangakousei_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DecisionType")
@Getter
@Setter
@NoArgsConstructor
public class DecisionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decision_type_id")
    private Long deicisionTypeId;

    @Column(name = "decision_type_name", nullable = false, length = 255, unique = true)
    private String decisionTypeName;
}
