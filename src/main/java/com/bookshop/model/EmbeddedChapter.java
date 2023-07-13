package com.bookshop.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddedChapter {
    @Getter @Setter private String title;

    @Getter @Setter private String content;
}
