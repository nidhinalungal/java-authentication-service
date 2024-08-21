package com.factweavers.authenticationservice.domain.property;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dpm_eval_sector_price_unit")
@Getter
@Setter
public class Unit {
    @Id
    @Column(name = "UNIT_ID", nullable = false)
    private Long id;

    @Column(name = "MUNICIPALITYID")
    private Long municipalityId;

    @Column(name = "MUNICIPALITYNAME_A")
    private String municipalityNameAra;

    @Column(name = "MUNICIPALITYNAME")
    private String municipalityNameEng;

    @Column(name = "DISTRICTID")
    private Long districtId;

    @Column(name = "DISTRICTNAME_A")
    private String districtNameAra;

    @Column(name = "DISTRICTNAMEENG")
    private String districtNameEng;

    @Column(name = "COMMUNITYID")
    private Long communityId;

    @Column(name = "COMMUNITYNAME_A")
    private String communityNameAra;

    @Column(name = "COMMUNITYNAME_E")
    private String communityNameEng;

    @Column(name = "ROADID")
    private Long roadId;

    @Column(name = "ROADNUMBER")
    private String roadNumber;

    @Column(name = "PARENT_LANDUSENAME_A")
    private String landUse;

    @Column(name = "LANDUSENAME_A")
    private String subLandUse;

    // Todo; Need to map landArea
    @Column(name = "UNIT_AREA")
    private Double unitArea;

    @Column(name = "PLOTID")
    private Long plotId;

    @Column(name = "PLOTNUMBER")
    private String plotNumber;


    @Column(name = "PLOTADDRESS")
    private String plotAddress;

    @Transient
    // Todo; Need to map serviceStatus
    // @Column(name = "SERVICE_STATUS")
    private String serviceStatus = "-----";

    @Transient
    // Todo; Need to map constructionStatus
    // @Column(name = "CONSTRUCTION_STATUS")
    private String constructionStatus = "-----";

    @Transient
    // Todo; Need to map imageUrl
    // @Column(name = "IMAGEURL")
    private String imageUrl = "-----";

    @Column(name = "BUILDING_NUMBER")
    private String buildingNumber;

    @Column(name = "FLOOR_NUMBER")
    private String floorNumber;

    @Column(name = "UNIT_NUMBER")
    private String unitNumber;

    @Column(name="UNIT_BEDROOM_COUNT")
    private Double bedroomCount;

    @Column(name = "UNIT_USAGE_TYPE_E")
    private String unitUse;

    @Column(name = "PROJECT_NAME_A")
    private String projectName;

    @Column(name= "UNITPRICEPERMS")
    private String pricePerSqm;

    @Column(name = "SELL_PRICE")
    private Double sellPrice;

    @Column(name = "COUNTNUMBEROFSELL")
    private String numberOfSales;
}
