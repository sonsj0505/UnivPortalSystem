package sonsj.UnivPortalSystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.domain.student;

@Getter @Setter
@RequiredArgsConstructor
public class studentJoinDto {

    private Long id;
    private Long studentNumber;
    private String password;
    private String name;
    private String email;

    @Builder
    public studentJoinDto(Long id, Long studentNumber, String password, String name, String email) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public student toEntity(){
        return student.studentJoinBuilder()
                .studentNumber(this.studentNumber)
                .password(this.password)
                .name(this.name)
                .email(this.email)
                .build();
    }

    public static studentJoinDto toDto(student student){
        return studentJoinDto.builder()
                //value
                .studentNumber(student.getStudentNumber())
                .password(student.getPassword())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }
}