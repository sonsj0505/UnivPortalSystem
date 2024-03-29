package sonsj.UnivPortalSystem.admin.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.admin.domain.department;
import sonsj.UnivPortalSystem.admin.model.DepartmentStatus;
import sonsj.UnivPortalSystem.student.domain.student;
import sonsj.UnivPortalSystem.student.dto.studentJoinDto;

@Getter @Setter
@RequiredArgsConstructor
public class departmentInfoDto {

    private int id;
    private String name;
    private DepartmentStatus departmentStatus;

    @Builder
    public departmentInfoDto(int id, String name, DepartmentStatus departmentStatus) {
        this.id = id;
        this.name = name;
        this.departmentStatus = departmentStatus;
    }

    public department toEntity() {
        return department.builder()
                .id(this.id)
                .name(this.name)
                .departmentStatus(this.departmentStatus)
                .build();
    }

    public static departmentInfoDto toDto(department department){
        return departmentInfoDto.builder()
                .id(department.getId())
                .name(department.getName())
                .departmentStatus(department.getDepartmentStatus())
                .build();
    }
}
