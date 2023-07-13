package com.bookshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@ToString(exclude = "book")
@EqualsAndHashCode(exclude = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @ManyToOne(optional = false)
    private Book book;
}
