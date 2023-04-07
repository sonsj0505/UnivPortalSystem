package sonsj.UnivPortalSystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.domain.student;
import sonsj.UnivPortalSystem.model.StudentStatus;

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
