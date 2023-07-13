package com.bookshop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Data;

@Entity
@Data
@DynamicInsert
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Id
    // ISBN ID;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "publisher_book")
    private Publisher publisher;

    private Date publisheDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Set<Chapter> chapters = new HashSet<>();

    @ElementCollection
    private Set<EmbeddedChapter> embeddedChapters = new HashSet<>();

//    @ElementCollection
//    @OrderColumn(columnDefinition = "int", name = "order_column")
//    @Column(name = "review")
//    private List<String> reviews = new ArrayList<>();

    @ElementCollection
    List<String> reviewList = new ArrayList<>();

    @ElementCollection
    @Column(name = "reference")
    @MapKeyColumn(name = "topic")
    Map<String, String> topicMap = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderBy("review")
    @Column(name = "review")
    Set<String> reviewsList = new TreeSet<>();
}
