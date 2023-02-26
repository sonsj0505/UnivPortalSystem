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

        // 학생 정보 저장
        //studentRepository.save(studentData);

    }
}