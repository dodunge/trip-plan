package com.app.tripplan.embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import org.locationtech.jts.geom.*;

@Embeddable
@Getter
@Setter
@ToString
public class Address {
    /**
     * address (주소)
     **/
    @NotNull private String address;

    /**
     * addressDetail (상세 주소)
     **/
    @NotNull private String addressDetail;

    /**
     * postcode (우편 번호)
     **/
    @NotNull private String postcode;

    /**
     * coordinates (지도에서 지점)
     **/
    @NotNull private Point coordinates;

}
