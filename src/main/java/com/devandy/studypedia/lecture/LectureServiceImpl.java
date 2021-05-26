package com.devandy.studypedia.lecture;

import com.devandy.studypedia.user.Role;
import com.devandy.studypedia.user.User;
import com.devandy.studypedia.user.UserRepository;
import com.devandy.studypedia.web.dto.lecture.RequestSaveLectureDto;
import com.devandy.studypedia.web.dto.lecture.RequestUpdateLectureDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addLecture(RequestSaveLectureDto requestSaveLectureDto, Long authorId) {
        requestSaveLectureDto.setAuthorId(authorId);
        requestSaveLectureDto.setViews(0L);
        requestSaveLectureDto.setAuthorName(getAuthorName(authorId));
        lectureRepository.save(requestSaveLectureDto.toEntity());
    }

    @Override
    public Lecture getLecture(Long id) {
        if(lectureRepository.findById(id).isPresent()) {
            return lectureRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void updateLecture(Long id, RequestUpdateLectureDto requestUpdateLectureDto) {
        Lecture targetLecture = lectureRepository.findById(id).get();
        targetLecture.setTitle(requestUpdateLectureDto.getTitle());
        targetLecture.setCreator(requestUpdateLectureDto.getCreator());
        targetLecture.setDescription(requestUpdateLectureDto.getDescription());
        targetLecture.setLectureUrl(requestUpdateLectureDto.getLectureUrl());
        targetLecture.setAuthorName(requestUpdateLectureDto.getAuthorName());
        lectureRepository.save(targetLecture);
    }

    @Override
    public void deleteLecture(Long id) {
        Lecture targetLecture = lectureRepository.findById(id).get();
        lectureRepository.delete(targetLecture);
    }

    @Override
    public boolean hasAuthority(Long lectureId, Long currentUserId) {
        Lecture targetLecture = lectureRepository.findById(lectureId).get();
        User currentUser = userRepository.findById(currentUserId).get();
        return currentUserId.equals(targetLecture.getAuthorId()) || currentUser.getRole().equals(Role.ADMIN);
    }

    @Override
    public List<Lecture> getLatestAddedLecture(int count) {
        List<Lecture> lectureList = lectureRepository.findAll();
        List<Lecture> getLectures = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            getLectures.add(lectureList.get(lectureList.size()-i));
        }
        return getLectures;
    }

    @Override
    public void increaseViewCount(Long id) {
        Lecture targetLecture = getLecture(id);
        targetLecture.setViews(targetLecture.getViews()+1);
        lectureRepository.save(targetLecture);
    }

    @Override
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    private String getAuthorName(Long id) {
        return userRepository.getOne(id).getUserName();
    }

    @Override
    public void updateAuthorName(Long authorId) {
        String authorName = userRepository.findById(authorId).get().getUserName();
        List<Lecture> lectures = lectureRepository.findByAuthorId(authorId);
        for (Lecture lecture : lectures) {
            lecture.setAuthorName(authorName);
            lectureRepository.save(lecture);
        }
    }

    @Override
    public List<Lecture> getLecturesMostView(int count) {
        String query = "SELECT lecture FROM Lecture lecture ORDER BY lecture.views DESC";
        TypedQuery typedQuery = entityManager.createQuery(query, Lecture.class);
        typedQuery.setMaxResults(count);
        return typedQuery.getResultList();
    }
}
