package sonsj.UnivPortalSystem.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sonsj.UnivPortalSystem.admin.domain.subject;
import sonsj.UnivPortalSystem.student.domain.student;
import sonsj.UnivPortalSystem.student.repository.studentRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class studentService {
    private final sonsj.UnivPortalSystem.student.repository.studentRepository studentRepository;

    public void studentLogin(student loginData) {

        // 입력 데이터와 로그인 db 정보 일치 확인
        studentRepository.findByStudentNumber(loginData.getStudentNumber())
                .orElseThrow(() -> new IllegalArgumentException("입력 값을 다시 확인해 주세요."));

    }

    public void studentJoinComplete(student joinData) {

        // 학번 중복 확인 (?)
        studentRepository.findByStudentNumber(joinData.getStudentNumber()).ifPresent(
                existStudentData -> {
                    throw new IllegalArgumentException("학생 데이터가 이미 존재합니다.");
                });

        // 학생 정보 저장
        studentRepository.save(joinData);
    }

    public student studentInfo(Long studentNumber) {

        studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생 데이터입니다."));

        student studentData = studentRepository.findByStudentNumber(studentNumber).get();

        return studentData;
    }

    public void studentEdit(Long studentNumber, student editStudentData) {

        studentRepository.findByStudentNumber(studentNumber).ifPresentOrElse(
                updateData -> {
                    //입력한 정보를 디비에 바꾸고,
                    updateData.updateStudent(editStudentData);
                    //넣은 정보로 저장(update)
                    studentRepository.save(updateData);
                },
                () -> new NoSuchElementException()
        );
    }

    public List<student> studentListAllRead(Integer id) {

        //학과별 학생 전체 조회
        List<student> allStudentData = studentRepository.findByDepartmentId(id);

        return allStudentData;
    }
}