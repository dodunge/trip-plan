package com.app.tripplan.entity.attractions;

import com.app.tripplan.embeddable.Address;
import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.trip.Trip;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_ATTRACTIONS")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_ATTRACTIONS SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class Attractions extends Period {

    /**
     * Attractions PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Attractions Title(관광 제목)
     **/
    @NotNull
    private String attractionsTitle;

    /**
     * Attractions Content(간단 관광 설명)
     **/
    private String attractionsContent;

    /**
     * Attractions Address(관광 주소)
     **/
    @Embedded
    private Address address;

    /**
     * Attractions Visit Date(관광 예약 날짜)
     **/
    private LocalDateTime visitDate;

    /**
     * Attractions Ticket Needed(관광 티켓 필요 유무)
     **/
    @ColumnDefault("false")
    @NotNull
    private boolean ticketNeeded;

    /**
     * Attractions Has Ticket(관광 티켓 보유 현황)
     **/
    @ColumnDefault("false")
    @NotNull
    private boolean hasTicket;

    /**
     * Attractions Ticket Price(관광 티켓 가격)
     **/
    private Integer ticketPrice;

    /**
     * Trip Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

}
