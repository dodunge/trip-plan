package com.app.tripplan.entity.transportation;

import com.app.tripplan.constants.AccessType;
import com.app.tripplan.embeddable.Address;
import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.trip.Trip;
import com.app.tripplan.entity.user.User;
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
@Table(name = "TBL_TRANSPORTATION")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_TRANSPORTATION SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class Transportation extends Period {

    /**
     * Transportation PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Transportation Title(교통 제목)
     **/
    @NotNull
    private String transportationTitle;

    /**
     * Transportation Content(간단 교통 설명)
     **/
    private String transportationContent;

    /**
     * Transportation Address(교통 주소)
     **/
    @Embedded
    private Address address;

    /**
     * Transportation Access Type(교통 접근 타입)
     **/
    @NotNull
    private AccessType accessType;

    /**
     * Transportation Reservation Date(교통편 예약 날짜)
     **/
    @NotNull
    private LocalDateTime reservationDate;

    /**
     * User Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * Trip Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

}
