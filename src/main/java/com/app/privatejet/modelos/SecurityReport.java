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
    private boolean is_resolved = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Fligth getFligth() {
        return fligth;
    }

    public void setFligth(Fligth fligth) {
        this.fligth = fligth;
    }

    public String getReported_by() {
        return reported_by;
    }

    public void setReported_by(String reported_by) {
        this.reported_by = reported_by;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean is_resolved() {
        return is_resolved;
    }

    public void setIs_resolved(boolean is_resolved) {
        this.is_resolved = is_resolved;
    }
}
