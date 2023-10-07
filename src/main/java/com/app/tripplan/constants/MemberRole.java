package com.app.tripplan.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MemberRole {

    /**
     * OWNER : OWNER(소유자)
     * MEMBER : MEMBER(구성원)
     **/
    OWNER("OWNER", "소유자"),
    MEMBER("MEMBER", "구성원");

    private final String code;
    private final String name;

    private static final String ROLE_PREFIX = "ROLE_";

    public String getSecurityRole(){
        return ROLE_PREFIX + name();
    }

}
