package sonsj.UnivPortalSystem.admin.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.domain.subject;
import sonsj.UnivPortalSystem.admin.model.SubjectStatus;
import sonsj.UnivPortalSystem.admin.model.SubjectType;

@Getter @Setter
@RequiredArgsConstructor
public class subjectInfoDto {

    private Integer id;
    private String subjectName;
    private SubjectType subjectType;
    private String courseCredit;
    private SubjectStatus subjectStatus;
    private department departmentId;

    @Builder
    public subjectInfoDto(Integer id, String subjectName, SubjectType subjectType, String courseCredit, SubjectStatus subjectStatus, department departmentId) {
        this.id = id;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
        this.courseCredit = courseCredit;
        this.subjectStatus = subjectStatus;
        this.departmentId = departmentId;
    }

    public subject toEntity() {
        return subject.builder()
                .id(this.id)
                .subjectName(this.subjectName)
                .subjectType(this.subjectType)
                .courseCredit(this.courseCredit)
                .subjectStatus(this.subjectStatus)
                .departmentId(this.departmentId)
                .build();
    }
}
