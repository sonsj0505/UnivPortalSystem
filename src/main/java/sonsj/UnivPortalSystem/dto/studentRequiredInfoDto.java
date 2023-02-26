package sonsj.UnivPortalSystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.domain.student;

@Getter @Setter
@RequiredArgsConstructor
public class studentRequiredInfoDto {

    private Long id;
    private Long studentNumber;
    private String name;
    private String email;

    @Builder
    public studentRequiredInfoDto(Long id, Long studentNumber, String name, String email) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
    }

    public student toEntity(){
        return student.studentJoinBuilder()
                .studentNumber(this.studentNumber)
                .name(this.name)
                .email(this.email)
                .build();
    }
}