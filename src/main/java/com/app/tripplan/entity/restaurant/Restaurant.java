package com.app.tripplan.entity.restaurant;

import com.app.tripplan.embeddable.Address;
import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.trip.Trip;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "TBL_RESTAURANT")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@TypeDef(name = "json", typeClass = JsonType.class)
@SQLDelete(sql = "UPDATE TBL_RESTAURANT SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class Restaurant extends Period {

    /**
     * Restaurant PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Restaurant Title(식당 제목)
     **/
    @NotNull
    private String restaurantTitle;

    /**
     * Restaurant Content(간단 식당 설명)
     **/
    private String restaurantContent;

    /**
     * Restaurant Address(식당 주소)
     **/
    @Embedded
    private Address address;

    /**
     * Restaurant Visit Date(식당 예약 날짜)
     **/
    private LocalDateTime visitDate;

    /**
     * Restaurant Business Time(기타 식당 운영 시간(open, close, break time))
     **/
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<Map<String, LocalDateTime>> businessTime;

    /**
     * Trip Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

}
