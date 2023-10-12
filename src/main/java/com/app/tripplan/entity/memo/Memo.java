package com.app.tripplan.entity.memo;

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
@Table(name = "TBL_MEMO")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_MEMO SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class Memo extends Period {

    /**
     * Memo PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Memo Content(메모 내용)
     **/
    @NotNull
    private String memoContent;

    /**
     * Memo Access Type(메모 접근 타입)
     **/
    @NotNull
    @Enumerated(EnumType.STRING)
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
