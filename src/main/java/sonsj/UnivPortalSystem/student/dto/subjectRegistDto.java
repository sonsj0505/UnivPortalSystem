package sonsj.UnivPortalSystem.student.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.admin.dto.subjectInfoDto;
import sonsj.UnivPortalSystem.student.domain.subjectRegistration;


@Getter @Setter
@RequiredArgsConstructor
public class subjectRegistDto {

    private Long id;
    private studentJoinDto studentId;  //동작 확인을 위한 임시 dto
    private subjectInfoDto subjectId;  //동작 확인을 위한 임시 dto

    @Builder
    public subjectRegistDto (Long id, studentJoinDto studentId, subjectInfoDto subjectId) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public subjectRegistration toEntity(){
        return subjectRegistration.builder()
                .id(this.id)
                .studentId(this.studentId == null ? null : this.studentId.toEntity())
                .subjectId(this.subjectId == null ? null : this.subjectId.toEntity())
                .build();
    }
}