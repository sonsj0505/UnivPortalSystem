package sonsj.UnivPortalSystem.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StudentStatus {

    FRESHMAN("신입생", "FRESHMAN"),
    UNDERGRADUATE("재학생", "UNDERGRADUATE"),
    LEAVEOFABSENCE("휴학생", "LEAVEOFABSENCE"),
    GRADUATE("졸업생", "GRADUATE"),
    ;

    private final String desc;
    private final String value;
}