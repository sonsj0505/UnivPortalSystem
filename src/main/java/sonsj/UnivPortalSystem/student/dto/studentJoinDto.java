package sonsj.UnivPortalSystem.student.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.student.domain.student;
import sonsj.UnivPortalSystem.student.model.StudentStatus;

@Getter @Setter
@RequiredArgsConstructor
public class studentJoinDto {

    private Long id;
    private Long studentNumber;
    private String password;
    private String name;
    private String email;
    private StudentStatus studentStatus;

    @Builder
    public studentJoinDto(Long id, Long studentNumber, String password, String name, String email, StudentStatus studentStatus) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.studentStatus = studentStatus;
    }

    public student toEntity(){
        return student.studentJoinBuilder()
                .studentNumber(this.studentNumber)
                .password(this.password)
                .name(this.name)
                .email(this.email)
                .studentStatus(this.studentStatus)
                .build();
    }

    public static studentJoinDto toDto(student student){
        return studentJoinDto.builder()
                //value
                .studentNumber(student.getStudentNumber())
                .password(student.getPassword())
                .name(student.getName())
                .email(student.getEmail())
                .studentStatus(student.getStudentStatus())
                .build();
    }
}