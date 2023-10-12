package com.app.tripplan.json;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BusinessTime {
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalTime breakStartTime;
    private LocalTime breakEndTime;
}
