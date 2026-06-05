package com.mangakousei.mangakousei_backend.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PublicationDecisions")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "decisionId")
public class PublicationDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decision_id")
    private Long decisionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_type_id", nullable = false)
    @ToString.Exclude
    private DecisionType decisionType;
    
    @Column(name = "reason",columnDefinition = "TEXT")
    private String reason;
    @Column(name = "decided_at", nullable = false)
    private LocalDateTime decidedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    @JsonBackReference("publicationDecisions")
    @ToString.Exclude
    private Series series;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decided_by")
    private User decider;

    @PrePersist
    protected void decidedOn(){
        this.decidedAt = LocalDateTime.now();
    }
}