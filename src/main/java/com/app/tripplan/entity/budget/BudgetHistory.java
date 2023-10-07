package com.app.tripplan.entity.budget;

import com.app.tripplan.entity.user.User;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_BUDGET_HISTORY")
@Getter
@ToString
@SQLDelete(sql = "UPDATE TBL_BUDGET_HISTORY SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class BudgetHistory {

    /**
     * Budget History PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Transaction Date(거래 날짜)
     **/
    @NotNull
    private LocalDateTime transactionDate;

    /**
     * Budget Transaction Description(예산 거래 설명)
     **/
    @NotNull
    private String description;

    /**
     * Transaction amount(거래 금액)
     **/
    @NotNull
    private Long amount;

    /**
     * Budget balance(거래 후 잔액)
     **/
    @NotNull
    private Long balance;

    /**
     * Budget Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Budget budget;

    /**
     * User Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
