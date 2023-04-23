package sonsj.UnivPortalSystem.admin.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SubjectType {

    MAJOR_REQUIRED("MAJOR_REQUIRED", "전공필수"),
    MAJOR_OPTION("MAJOR_OPTION", "전공선택"),
    ELECTIVE_REQUIRED("ELECTIVE_REQUIRED", "교양필수"),
    ELECTIVE_OPTION("ELECTIVE_OPTION", "교양선택")
    ;

    private final String key;
    private final String value;
}
