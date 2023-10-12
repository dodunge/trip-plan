package com.app.tripplan.entity.trip;

import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.team.Team;
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
@Table(name = "TBL_TRIP")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_TRIP SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class Trip extends Period {
    /**
     * Trip PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Trip Title(여행 제목)
     **/
    @NotNull
    private String tripTitle;

    /**
     * Trip Content(간단 여행 설명)
     **/
    private String tripContent;

    /**
     * Trip Start Date(여행 시작 날짜)
     **/
    @NotNull
    private LocalDateTime tripStartDateTime;

    /**
     * Trip End Date(여행 종료 날짜)
     **/
    @NotNull
    private LocalDateTime tripEndDateTime;

    /**
     * Trip Public Options(여행 공개 여부)
     **/
    @NotNull
    private boolean isPublic;

    /**
     * User Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * Team Entity 와 연관 관계 (1 : 1)
     **/
    @OneToOne(fetch = FetchType.LAZY)
    private Team team;

}
