package sonsj.UnivPortalSystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sonsj.UnivPortalSystem.domain.student;
import sonsj.UnivPortalSystem.repository.studentRepository;

@Service
@RequiredArgsConstructor
public class studentService {
    private final studentRepository studentRepository;

    public void studentJoinComplete(student studentData) {

        // 학번 중복 확인 (?)
        studentRepository.findByStudentNumber(studentData.getStudentNumber()).ifPresent(
                existStudentData -> {
                    throw new RuntimeException("학생 데이터가 이미 존재합니다.");
                });

        // 학생 정보 저장
        studentRepository.save(studentData);

    }
}