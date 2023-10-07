package com.app.tripplan.entity.accommodation;

import com.app.tripplan.embeddable.Address;
import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.trip.Trip;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_ACCOMMODATION")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_ACCOMMODATION SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class Accommodation extends Period {

    /**
     * Accommodation PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Accommodation Title(숙소 제목)
     **/
    @NotNull
    private String transportationTitle;

    /**
     * Accommodation Content(간단 숙소 설명)
     **/
    private String transportationContent;

    /**
     * Accommodation Address(숙소 주소)
     **/
    @Embedded
    private Address address;

    /**
     * Accommodation Reservation Check In Date(숙소 예약 체크인 날짜)
     **/
    @NotNull
    private LocalDateTime reservationCheckInDate;

    /**
     * Accommodation Reservation Check Out Date(숙소 예약 체크아웃 날짜)
     **/
    @NotNull
    private LocalDateTime reservationCheckOutDate;

    /**
     * Trip Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

}
