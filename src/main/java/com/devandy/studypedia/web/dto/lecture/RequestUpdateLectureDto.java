package com.devandy.studypedia.web.dto.lecture;

import com.devandy.studypedia.lecture.Lecture;
import com.devandy.studypedia.utils.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RequestUpdateLectureDto extends BaseTimeEntity {
    private String title;
    private String creator;
    private String description;
    private String lectureUrl;

    @Builder
    public RequestUpdateLectureDto(String title, String creator, String description, String lectureUrl) {
        this.title = title;
        this.creator = creator;
        this.description = description;
        this.lectureUrl = lectureUrl;
    }

    public Lecture toEntity() {
        return Lecture.builder()
                .title(title)
                .creator(creator)
                .description(description)
                .lectureUrl(lectureUrl)
                .build();
    }
}
