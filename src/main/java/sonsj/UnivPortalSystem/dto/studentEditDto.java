package sonsj.UnivPortalSystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.domain.student;

@Getter @Setter
@RequiredArgsConstructor
public class studentEditDto {
    String name;
    String email;

    @Builder
    public studentEditDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public student toEntity() {
        return student.studentEditBuilder()
                .name(this.name)
                .email(this.email)
                .build();
    }
}
