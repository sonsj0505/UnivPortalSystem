package sonsj.UnivPortalSystem.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StudentStatus {

    FRESHMAN("FRESHMAN", "신입생"),
    UNDERGRADUATE("UNDERGRADUATE", "재학생"),
    LEAVEOFABSENCE("LEAVEOFABSENCE", "휴학생"),
    GRADUATE("GRADUATE", "졸업생"),
    ;

    private final String key;
    private final String value;
}