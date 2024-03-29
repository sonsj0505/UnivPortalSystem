package sonsj.UnivPortalSystem.student.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.student.domain.student;
import sonsj.UnivPortalSystem.student.model.StudentStatus;

@Getter @Setter
@RequiredArgsConstructor
public class studentEditDto {
    Long studentNumber;
    String name;
    String email;
    StudentStatus studentStatus;

    @Builder
    public studentEditDto(Long studentNumber, String name, String email, StudentStatus studentStatus) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
        this.studentStatus = studentStatus;
    }

    public student toEntity() {
        return student.studentEditBuilder()
                .studentNumber(this.studentNumber)
                .name(this.name)
                .email(this.email)
                .studentStatus(this.studentStatus)
                .build();
    }

    public static studentEditDto toDto(student student){
        return studentEditDto.builder()
                //value
                .studentNumber(student.getStudentNumber())
                .name(student.getName())
                .email(student.getEmail())
                .studentStatus(student.getStudentStatus())
                .build();
    }
}
