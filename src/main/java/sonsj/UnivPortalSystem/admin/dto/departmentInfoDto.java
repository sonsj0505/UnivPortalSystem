package sonsj.UnivPortalSystem.admin.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.admin.domain.department;

@Getter @Setter
@RequiredArgsConstructor
public class departmentInfoDto {

    private int id;
    private String name;

    @Builder
    public departmentInfoDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public department toEntity() {
        return department.builder()
                .name(this.name)
                .build();
    }
}
