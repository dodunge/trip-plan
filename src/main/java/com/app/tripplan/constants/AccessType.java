package com.app.tripplan.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccessType {

    /**
     * REVIEW : 일반 후기
     * IMPROVEMENT : 개선 요청
     **/
    REVIEW("REVIEW", "일반 후기"),
    IMPROVEMENT("IMPROVEMENT", "개선 요청");

    private final String code;
    private final String name;

}
