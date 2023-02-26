package sonsj.UnivPortalSystem.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private Long studentNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Builder(builderMethodName = "studentJoinBuilder")
    public student(Long studentNumber, String name, String email) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
    }
}