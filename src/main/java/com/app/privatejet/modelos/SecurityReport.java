package com.app.privatejet.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name="SecurityReport")
public class SecurityReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "fligth_id", nullable = false)
    private Fligth fligth;

    @Column(nullable = false)
    private String reported_by;

    @Column(nullable = false)
    private String description;

    @Column()
    private Boolean is_resolved = false;

}
