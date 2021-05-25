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
    private Long author;

    @Column(nullable = false)
    private String lectureUrl;

    @Column
    private Long views;

    @Builder
    public Lecture(String title, String creator, String description, Long author, String lectureUrl, Long views) {
        this.title = title;
        this.creator = creator;
        this.description = description;
        this.author = author;
        this.lectureUrl = lectureUrl;
        this.views = views;
    }
}
