package com.factweavers.authenticationservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "dv_company")
@Data
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID companyId;

    @Column(name = "trade_license_number", unique = true)
    private String tradeLicenseNumber;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "phone_mobile")
    private String phoneMobile;

    @Column(name = "profession_class_ar")
    private String professionClassAr;

    @Column(name = "profession_class_en")
    private String professionClassEn;

    @Column(name = "profession_license_id")
    private String professionLicenseId;

    @Column(name = "profession_type_ar")
    private String professionTypeAr;

    @Column(name = "profession_type_en")
    private String professionTypeEn;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "license_date")
    private String licenseDate;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "migrated_license_number")
    private String migratedLicenseNumber;

    @Column(name = "owner_name_ar")
    private String ownerNameAr;

    @Column(name = "referenceId")
    private Long referenceId;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "creation_timestamp")
    private String creationTimestamp;

    @Column(name = "delete_date")
    private String deleteDate;

    @Column(name = "delete_user")
    private String deleteUser;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "migrated_id")
    private String migratedId;

    @Column(name = "migrated_update_date")
    private String migratedUpdateDate;

    @Column(name = "update_timestamp")
    private String updateTimestamp;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "land_line")
    private String landLine;

    @Column(name = "phone_work")
    private String phoneWork;


    @Column(name = "is_trade_license_expired")
    private Boolean isTradeLicenseExpired;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", tradeLicenseNumber='" + tradeLicenseNumber + '\'' + ", licenseNumber='" + licenseNumber + '\'' + ", ownerName='" + ownerName + '\'' + '}';
    }
}
