package com.app.tripplan.entity.community;

import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.user.User;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_COMMUNITY_REPLY")
@Getter
@ToString
@SQLDelete(sql = "UPDATE TBL_COMMUNITY_REPLY SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class CommunityReply extends Period {

    /**
     * Community Reply PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Community Reply Parent ID(부모 커뮤니티 댓글 번호)
     **/
    private Long parentId;

    /**
     * Community Reply Content(커뮤니티 댓글 내용)
     **/
    @NotNull
    private String replyContent;

    /**
     * Community Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Community community;

    /**
     * User Entity 와 연관 관계 (N : 1)
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
