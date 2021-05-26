package com.devandy.studypedia.lecture;

import com.devandy.studypedia.utils.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class Lecture extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String creator;

    @Column(nullable = false)
    private String description;

    @Column
    private Long authorId;

    @Column
    private String authorName;

    @Column(nullable = false)
    private String lectureUrl;

    @Column
    private Long views;

    @Builder
    public Lecture(String title, String creator, String description, Long authorId, String authorName,
                   String lectureUrl, Long views) {
        this.title = title;
        this.creator = creator;
        this.description = description;
        this.authorId = authorId;
        this.authorName = authorName;
        this.lectureUrl = lectureUrl;
        this.views = views;
    }
}
