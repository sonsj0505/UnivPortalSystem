package sonsj.UnivPortalSystem.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // jpa로 관리되는 entity 객체
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "id")) // db 테이블 정보 구성
@Getter @Setter
@RequiredArgsConstructor // 필수 값만 파라메터로 받는 생성자
public class student {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index
    private Long id;

    @Column(name = "name")
    private String name;
}