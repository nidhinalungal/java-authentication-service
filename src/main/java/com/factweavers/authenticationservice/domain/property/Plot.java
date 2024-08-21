package com.factweavers.authenticationservice.domain.property;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dpm_eval_sector_price")
@Getter
@Setter
public class Plot {
    @Id
    @Column(name = "PLOTID", nullable = false)
    private Long id;

    @Column(name = "MUNICIPALITYID")
    private Long municipalityId;

    @Column(name = "MUNICIPALITYARA")
    private String municipalityNameAra;

    @Column(name = "MUNICIPALITYNAME")
    private String municipalityNameEng;

    @Column(name = "DISTRICTID")
    private Long districtId;

    @Column(name = "DISTRICTNAME_A")
    private String districtNameAra;

    @Column(name = "DISTRICTNAME_E")
    private String districtNameEng;

    @Column(name = "COMMUNITYID")
    private Long communityId;

    @Column(name = "COMMUNITYNAME_A")
    private String communityNameAra;

    @Column(name = "COMMUNITYNAME_E")
    private String communityNameEng;

    @Column(name = "ROADID")
    private String roadId;

    @Transient
    // Todo; Need to map roadNumber
    // @Column(name = "ROADID")
    private String roadNumber;

    @Column(name = "ELMS_PARENTLANDUSE_E")
    private String landUse;

    @Column(name = "ELMS_LANDUSENAME_E")
    private String subLandUse;

    // Todo; Need to map landArea
    @Column(name = "PLOTAREA")
    private String landArea;

    @Column(name = "PLOTADDRESS")
    private String plotAddress;

    @Column(name = "PLOTNUMBER")
    private String plotNumber;

    @Transient
    // Todo; Need to map serviceStatus
    // @Column(name = "SERVICE_STATUS")
    private String serviceStatus = "-----";

    @Column(name = "CONSTRUCTION_STATUS")
    private String constructionStatus;

     @Column(name = "DEVCODE_FAR")
    private String far;

     @Column(name = "DEVCODE_MAXGFA")
    private String maxGfa;

    @Column(name = "GFA")
    private String gfa;

    @Column(name = "SELL_PRICE")
    private String sellPrice;

    @Column(name = "COUNTNUMBEROFSELL")
    private Double numberOfSales;

    @Column(name = "MUNICIPALITY_PRICEPERMS")
    private String municipalityPricePerSqm;

    @Column(name = "LANDPRICEPERMS")
    private String pricePerSqm;
    @Transient
    // Todo; Need to map imageUrl
    // @Column(name = "IMAGEURL")
    private String imageUrl = "-----";

    @Transient
    @Column(name = "PROJECT_NAME_E")
    private String projectName = "-----";

    // roadNumber is same as roadId
    public String getRoadNumber() {
        return this.roadId;
    }
}
