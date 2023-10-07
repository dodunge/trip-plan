package com.app.tripplan.entity.community;

import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.trip.Trip;
import com.app.tripplan.entity.user.User;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
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
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "TBL_COMMUNITY")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_COMMUNITY SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
@TypeDef(name = "json", typeClass = JsonBinaryType.class)
public class Community extends Period {

    /**
     * Community PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Community Content(커뮤니티 내용)
     **/
    @NotNull
    private String communityContent;

    /**
     * Community Tag(커뮤니티 태그)
     **/
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String, List<String>> communityTag;

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
