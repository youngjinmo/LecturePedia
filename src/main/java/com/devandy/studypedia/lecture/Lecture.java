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

    @Column
    private Long publisher;

    @Column(nullable = false)
    private String lectureUrl;

    @Builder
    public Lecture(String title, String creator, Long publisher, String lectureUrl) {
        this.title = title;
        this.creator = creator;
        this.publisher = publisher;
        this.lectureUrl = lectureUrl;
    }
}
