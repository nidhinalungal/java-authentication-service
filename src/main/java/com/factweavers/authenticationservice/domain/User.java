package com.factweavers.authenticationservice.domain;

import com.factweavers.authenticationservice.domain.valuationrequest.ValuationRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "dv_users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID userId;
    private String password;
    private String address;
    private String companyTradeLicenseNumber;
    private String nationalNumber;
    private String companyName;
    private String nationalityName;
    private String companyNameAr;
    private String contactEmail;
    private String email;

    private LocalDateTime endDate;
    private String licenseNumber;
    private String mobile;
    private String phoneMobile;
    private String professionClassAr;
    private String professionClassEn;
    private Long professionLicenseId;
    private String professionTypeAr;
    private String professionTypeEn;
    private LocalDateTime startDate;
    private LocalDateTime licenseDate;
    private String ownerName;
    private String migratedLicenseNumber;
    private String ownerNameAr;
    private Long referenceId;
    private String createUser;
    private String creationTimestamp;
    private LocalDateTime deleteDate;
    private String deleteUser;
    private Boolean isDeleted;
    private Long migratedId;
    private LocalDateTime migratedUpdateDate;
    private LocalDateTime updateTimestamp;
    private String updateUser;
    private String imageUrl;
    private String landLine;
    private String phoneWork;
    private Boolean isEidExpired;
    private Boolean isLicenseExpired;
    private String pinId;
    private String status;
    private int otpCount = 0;
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RefreshToken> refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dv_user_role_map", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id")

    )
    private Set<Role> userRoles;

    @JsonProperty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipality_id")
    private Municipalities muncipality;




//    @OneToMany(mappedBy = "valuer", fetch = FetchType.EAGER)
//    private List<ValuationRequest> valuerRequests;
//
//    @OneToMany(mappedBy = "auditor", fetch = FetchType.EAGER)
//    private List<ValuationRequest> auditorRequests;

}