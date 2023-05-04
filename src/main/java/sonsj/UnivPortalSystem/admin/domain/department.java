package sonsj.UnivPortalSystem.admin.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sonsj.UnivPortalSystem.admin.model.DepartmentStatus;
import sonsj.UnivPortalSystem.student.domain.student;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "department")
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "departmentStatus", nullable = false)
    private DepartmentStatus departmentStatus;

    @OneToMany(mappedBy = "department")
    private List<subject> subject;

    @OneToMany(mappedBy = "department")
    private List<student> student;

    @Builder
    public department(int id, String name, DepartmentStatus departmentStatus) {
        this.id = id;
        this.name = name;
        this.departmentStatus = departmentStatus;
    }

}