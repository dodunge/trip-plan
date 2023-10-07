package com.app.tripplan.entity.user;

import com.app.tripplan.auditing.Period;
import javax.validation.constraints.NotNull;

import com.app.tripplan.entity.file.File;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_USER")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_USER SET DELETED_DATE = CURRENT_TIMESTAMP, EXPIRARTION_PERIOD = CURRENT_TIMESTAMP + INTERVAL '2 YEAR' WHERE ID = ?")
public class User extends Period implements Serializable {

    /**
     * User PK(고유 번호)
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User Email(사용자 이메일)
     **/
    @NotNull @Column(unique = true)
    private String email;

    /**
     * User Name(사용자 이름)
     **/
    private String name;

    /**
     * User SNS Profile Url(사용자 SNS 프로필 사진 경로)
     **/
    private String sns_profile_url;

    /**
     * File Entity 와 연관 관계 (1 : 1)
     **/
    @OneToOne(fetch = FetchType.LAZY)
    @Setter
    private File file;
}
