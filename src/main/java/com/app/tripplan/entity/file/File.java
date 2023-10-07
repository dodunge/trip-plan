package com.app.tripplan.entity.file;

import com.app.tripplan.auditing.Period;
import com.app.tripplan.entity.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "TBL_FILE")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_FILE SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class File extends Period implements Serializable {

    /**
     * File PK(고유 번호)
     * */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * FileName(파일 이름)
     * */
    @NotNull
    private String fileName;

    /**
     * FilePath(파일 경로)
     * */
    @NotNull
    private String filePath;

    /**
     * FileSize(파일 사이즈)
     * */
    @NotNull
    private Long fileSize;

    /**
     * User Entity 와 연관 관계 (1 : 1)
     **/
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "file")
    private User user;

}
