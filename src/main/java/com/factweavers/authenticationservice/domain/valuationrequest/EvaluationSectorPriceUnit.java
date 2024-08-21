package com.factweavers.authenticationservice.domain.valuationrequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "dpm_eval_sector_price_det_unit")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvaluationSectorPriceUnit {
    @JsonProperty("YEAR")
    private String year;

    @JsonProperty("QUARTER")
    private String quarter;

    @JsonProperty("PROPERTY_TYPE")
    private String propertyType;

    @JsonProperty("CREATEDATE")
    private LocalDateTime createDate;

    @JsonProperty("APPLICATIONTYPE_E")
    private String applicationType;

    @JsonProperty("SELL_PRICE")
    private Double sellPrice;

    @JsonProperty("EVALUATION_AMOUNT")
    private Double evaluationAmount;

    @JsonProperty("PLOTID")
    private Double plotId;

    @JsonProperty("PLOTNUMBER")
    private String plotNumber;

    @JsonProperty("COUNTNUMBEROFSELL")
    private String countNumberOfSell;

    @JsonProperty("DEVELOPER_NAME")
    private String developerName;

    @JsonProperty("MUNICIPALITYNAME_A")
    private String municipalityNameArabic;

    @JsonProperty("PARENT_LANDUSENAME_A")
    private String parentLandUseName;

    @JsonProperty("LANDUSENAME_A")
    private String landUseName;

    @JsonProperty("BUILDING_ID")
    private Double buildingId;

    @JsonProperty("BUILDING_NUMBER")
    private String buildingNumber;

    @JsonProperty("BUILDING_NAME_A")
    private String buildingNameA;

    @JsonProperty("BUILDING_NAME_E")
    private String buildingNameE;

    @JsonProperty("BUILDING_GIS_ID")
    private Double buildingGisId;

    @JsonProperty("BUILDING_FLOORS_COUNT")
    private Double buildingFloorsCount;

    @JsonProperty("BUILDING_UNITS_COUNT")
    private Double buildingUnitsCount;

    @JsonProperty("IS_BUILDING_COMPLETE")
    private Double isBuildingComplete;

    @JsonProperty("UNIT_ID")
    private Double unitId;

    @JsonProperty("UNIT_NUMBER")
    private String unitNumber;

    @JsonProperty("FLOOR_NUMBER")
    private String floorNumber;

    @JsonProperty("UNIT_GIS_ID")
    private Double unitGisId;

    @JsonProperty("UNIT_CLASSIFICATION_NAME_A")
    private String unitClassificationNameA;

    @JsonProperty("UNIT_CLASSIFICATION_NAME_E")
    private String unitClassificationNameE;

    @JsonProperty("PARENT_UNIT_USAGE_TYPE_A")
    private String parentUnitUsageTypeA;

    @JsonProperty("PARENT_UNIT_USAGE_TYPE_E")
    private String parentUnitUsageTypeE;

    @JsonProperty("UNIT_USAGE_TYPE_A")
    private String unitUsageTypeA;

    @JsonProperty("UNIT_USAGE_TYPE_E")
    private String unitUsageTypeE;

    @JsonProperty("UNIT_BEDROOM_COUNT")
    private Double unitBedroomCount;

    @JsonProperty("UNIT_BATHROOM_COUNT")
    private Double unitBathroomCount;

    @JsonProperty("UNIT_AREA")
    private Double unitArea;

    @JsonProperty("UNIT_BALCONY_COUNT")
    private Double unitBalconyCount;

    @JsonProperty("UNIT_BALCONY_AREA")
    private Double unitBalconyArea;

    @JsonProperty("UNIT_PUBLIC_AND_SERVICE_AREA")
    private Double unitPublicAndServiceArea;

    @JsonProperty("UNIT_PARKING_COUNT")
    private Double unitParkingCount;

    @JsonProperty("CONSTRUCTIONAGE")
    private String constructionAge;

    @JsonProperty("SELLAGE")
    private String sellAge;

    @JsonProperty("COMMUNITYNAME_A")
    private String communityNameA;

    @JsonProperty("COMMUNITYNAME_E")
    private String communityNameE;

    @JsonProperty("DISTRICTNAME_A")
    private String districtNameA;

    @JsonProperty("DISTRICTNAME_E")
    private String districtNameE;

    @JsonProperty("DISTRICTNAMEENG")
    private String districtNameEng;

    @JsonProperty("DISTRICTNAMEARABIC")
    private String districtNameArabic;

    @JsonProperty("GISID")
    private String gisId;

    @JsonProperty("MUNICIPALITYENG")
    private String municipalityEng;

    @JsonProperty("MUNICIPALITYNAME")
    private String municipalityName;

    @JsonProperty("SECTORNUMBER_PLOTID")
    private String sectorNumberPlotId;

    @JsonProperty("UNITPRICEPERMS")
    private String unitPricePerMs;

    @JsonProperty("LASTUPDATEDATE")
    private LocalDateTime lastUpdateDate;
}
