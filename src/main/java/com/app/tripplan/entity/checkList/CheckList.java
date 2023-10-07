package com.app.tripplan.entity.checkList;

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

@Entity
@Table(name = "TBL_CHECK_LIST")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_CHECK_LIST SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class CheckList extends Period {

    /**
     * Check List PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Check List Content(체크 리스트 내용)
     **/
    @NotNull
    private String checkListContent;

    /**
     * Check List Is Checked(체크 리스트 체크 상황)
     **/
    @NotNull
    @ColumnDefault("false")
    private boolean isChecked;

    /**
     * Trip Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

}
