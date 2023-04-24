package sonsj.UnivPortalSystem.admin.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.admin.model.SubjectStatus;
import sonsj.UnivPortalSystem.admin.model.SubjectType;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "subjectName", nullable = false)
    private String subjectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "subjectType", nullable = false)
    private SubjectType subjectType;

    @Column(name = "courseCredit", nullable = false)
    private String courseCredit;

    @Enumerated(EnumType.STRING)
    @Column(name = "subjectStatus", nullable = false)
    private SubjectStatus subjectStatus;

    //교수

    @ManyToOne
    @JoinColumn(name = "department")
    private department department;

    @Builder
    public subject(Integer id, String subjectName, SubjectType subjectType, String courseCredit, SubjectStatus subjectStatus, department department) {
        this.id = id;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
        this.courseCredit = courseCredit;
        this.subjectStatus = subjectStatus;
        this.department = department;
    }
}
