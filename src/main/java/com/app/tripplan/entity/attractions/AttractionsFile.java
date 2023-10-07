package com.app.tripplan.entity.attractions;

import com.app.tripplan.entity.file.File;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ATTRACTIONS_FILE")
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE TBL_ATTRACTIONS_FILE SET DELETED_DATE = CURRENT_TIMESTAMP WHERE ID = ?")
public class AttractionsFile extends File {

    /**
     * Attractions (관광과 연관 관계) (N : 1)
     * */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Attractions attractions;

}
