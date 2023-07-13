package com.bookshop.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Errata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submittedDate;

    @Column(nullable = false)
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Errata errata = (Errata) o;
        return id != null && Objects.equals(id, errata.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
