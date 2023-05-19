package sonsj.UnivPortalSystem.student.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.admin.domain.subject;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class subjectRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private student studentId;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private subject subjectId;

    @Builder
    public subjectRegistration(Long id, student studentId, subject subjectId) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }
}