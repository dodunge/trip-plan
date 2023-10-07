package com.app.tripplan.entity.budget;

import com.app.tripplan.auditing.Period;
import com.app.tripplan.constants.AccessType;
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

@Entity
@Table(name = "TBL_BUDGET")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_BUDGET SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class Budget extends Period {

    /**
     * Budget PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Initial Budget(초기 자본)
     **/
    @NotNull
    private String initialBudget;

    /**
     * Current Budget(현재 자본)
     **/
    @NotNull
    private String currentBudget;

    /**
     * Budget Access Type(교통 접근 타입)
     **/
    @NotNull
    private AccessType accessType;

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
