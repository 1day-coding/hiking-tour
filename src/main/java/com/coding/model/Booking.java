package com.coding.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="trail_id")
    private Trail trail;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "booking")
    private List<Hiker> hikers = new ArrayList<>();

    @Column(name = "date_when")
    private LocalDate dateWhen;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;


    public void setHikers(final List<Hiker> hikers) {
        this.hikers = hikers;
        this.hikers.stream().forEach(x -> x.setBooking(this));
    }

    public Booking(final Trail trail, final List<Hiker> hikers, final LocalDate dateWhen) {
        this.trail = trail;
        this.dateWhen = dateWhen;
        setHikers(hikers);
    }
}
