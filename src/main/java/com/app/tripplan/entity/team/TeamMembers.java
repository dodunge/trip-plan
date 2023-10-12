package com.app.tripplan.entity.team;

import com.app.tripplan.constants.MemberRole;
import com.app.tripplan.auditing.Period;
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
@Table(name = "TBL_TEAM_MEMBERS")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_TEAM_MEMBERS SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class TeamMembers extends Period {

    /**
     * Team Member PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Team Member Role(팀 구성원 역할)
     **/
    @NotNull
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    /**
     * Team Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
}
