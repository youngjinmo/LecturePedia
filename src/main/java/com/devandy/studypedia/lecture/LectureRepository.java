package com.devandy.studypedia.lecture;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {;
    List<Lecture> findLecturesByAuthorId(Long authorId);
    List<Lecture> findTop4ByOrderByViewsDesc();
    Page<Lecture> findAllByOrderByFirstCreatedDateDesc(Pageable pageable);
}
