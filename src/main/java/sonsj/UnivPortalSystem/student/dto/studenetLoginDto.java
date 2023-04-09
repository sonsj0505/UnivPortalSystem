package sonsj.UnivPortalSystem.student.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.student.domain.student;

@Getter @Setter
@RequiredArgsConstructor
public class studenetLoginDto {
    Long studentNumber;
    String password;

    @Builder
    public studenetLoginDto(Long studentNumber, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
    }

    public student toEntity() {
        return student.studentLoginBuilder()
                .studentNumber(this.studentNumber)
                .password(this.password)
                .build();
    }
}