package com.devandy.studypedia.web.dto.lecture;

import com.devandy.studypedia.lecture.Lecture;
import com.devandy.studypedia.utils.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter @Setter
@NoArgsConstructor
public class RequestSaveLectureDto {
    private String title;
    private String creator;
    private String description;
    private Long author;
    private String lectureUrl;

    @Builder
    public RequestSaveLectureDto(String title, String creator, String description, Long author, String lectureUrl) {
        this.title = title;
        this.creator = creator;
        this.description = description;
        this.author = author;
        this.lectureUrl = lectureUrl;
    }

    public Lecture toEntity() {
        return Lecture.builder()
                .title(title)
                .creator(creator)
                .description(description)
                .author(author)
                .lectureUrl(lectureUrl)
                .build();
    }
}
