package sonsj.UnivPortalSystem.student.domain;

import lombok.*;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.domain.subject;
import sonsj.UnivPortalSystem.student.model.StudentStatus;

import javax.persistence.*;
import java.util.List;

@Entity // jpa로 관리되는 entity 객체
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "studentNumber")) // db 테이블 정보 구성
@Getter @Setter
@RequiredArgsConstructor // 필수 값만 파라메터로 받는 생성자
public class student {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index
    @Column(name = "id")
    private Long id;

    @Column(name = "studentNumber", nullable = false)
    private Long studentNumber; //학번

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "studentStatus", nullable = false)
    private StudentStatus studentStatus;

    @ManyToOne
    @JoinColumn(name = "department")
    private department department;

    @OneToMany(mappedBy = "studentId")
    private List<subjectRegistration> subjectRegistration;



    @Builder
    public student(Long id, Long studentNumber, String password, String name, String email,
                   StudentStatus studentStatus,
                   department department, List<subjectRegistration> subjectRegistration) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.studentStatus = studentStatus;
        this.department = department;
        this.subjectRegistration = subjectRegistration;
    }

    // 학생 로그인 builder
    @Builder(builderMethodName = "studentLoginBuilder")
    public student(Long studentNumber, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
    }

    // 학생 회원가입 builder
    @Builder(builderMethodName = "studentJoinBuilder")
    public student(Long studentNumber, String password, String name, String email, StudentStatus studentStatus, department department) {
        this.studentNumber = studentNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.studentStatus = studentStatus;
        this.department = department;
    }

    // 학생 정보 수정 builder
    @Builder(builderMethodName = "studentEditBuilder")
    public student(Long studentNumber, String name, String email, StudentStatus studentStatus) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
        this.studentStatus = studentStatus;
    }

    public void updateStudent(student updateData) {
        this.name = updateData.getName();
        this.email = updateData.getEmail();
        this.studentStatus = updateData.getStudentStatus();
    }
}