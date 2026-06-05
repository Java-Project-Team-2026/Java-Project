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
@Table(name = "IssueCode")
@Getter @Setter @NoArgsConstructor
public class IssueCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_code_id")
    private Long issueCodeId;
    
    @Column(name = "issue_code_name", nullable = false, unique = true)
    private String issueCodeName;
}
