package com.devandy.studypedia.web.dto.lecture;

import com.devandy.studypedia.lecture.Lecture;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RequestSaveLectureDto {
    private String title;
    private String creator;
    private String description;
    private Long authorId;
    private String authorName;
    private String lectureUrl;
    private Long views;

    @Builder
    public RequestSaveLectureDto(String title, String creator, String description,
                                 Long authorId, String authorName, String lectureUrl, Long views) {
        this.title = title;
        this.creator = creator;
        this.description = description;
        this.authorId = authorId;
        this.authorName = authorName;
        this.lectureUrl = lectureUrl;
        this.views = views;
    }

    public Lecture toEntity() {
        return Lecture.builder()
                .title(title)
                .creator(creator)
                .description(description)
                .authorId(authorId)
                .authorName(authorName)
                .lectureUrl(lectureUrl)
                .views(views)
                .build();
    }
}
