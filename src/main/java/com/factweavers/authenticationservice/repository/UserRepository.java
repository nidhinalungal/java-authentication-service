package com.factweavers.authenticationservice.repository;


import com.factweavers.authenticationservice.domain.Company;
import com.factweavers.authenticationservice.domain.Municipalities;
import com.factweavers.authenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Repository
@Named
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String username);

    Optional<User> findByNationalNumberAndIsEidExpiredFalse(String valuerEId);

    Optional<User> findByUserId(UUID userId);

    Optional<User> findByMobile(String mobile);

    Optional<User> findById(UUID userId);

    List<User> findByMuncipality(Municipalities muncipality);

    @Query("from User u " +
            "JOIN u.userRoles r " +
            "where ( u.ownerName like %:searchKey% or " +
            "u.ownerNameAr like %:searchKey% or " +
            "u.contactEmail like %:searchKey% or " +
            "u.muncipality.name like %:searchKey% or " +
            "r.roleName LIKE %:searchKey% or " +
            "u.email like %:searchKey% ) and " +
//            "u.muncipality is not null and " +
            "u.muncipality = :muncipality")
    List<User> findByMuncipality(@Param("muncipality") Municipalities muncipality, @Param("searchKey") String searchKey);

    List<User> findAllByMuncipalityIsNotNull();

    @Query("from User u " +
            "JOIN u.userRoles r " +
            "where ( u.ownerName like %:searchKey% or " +
            "u.ownerNameAr like %:searchKey% or " +
            "u.contactEmail like %:searchKey% or " +
            "u.muncipality.name like %:searchKey% or " +
            "r.roleName LIKE %:searchKey% or " +
            "u.email like %:searchKey% ) and " +
            "u.muncipality is not null")
    List<User> findAllByMuncipalityIsNotNull(@Param("searchKey") String searchKey);

    List<User> findByCompany(Company company);

    @Query("from User u " +
            "JOIN u.userRoles r " +
            "where ( u.ownerName like %:searchKey% or " +
            "u.ownerNameAr like %:searchKey% or " +
            "u.contactEmail like %:searchKey% or " +
            "u.nationalNumber like %:searchKey% or " +
            "u.licenseNumber like %:searchKey% or " +
            "u.mobile like %:searchKey% or " +
            "r.roleName LIKE %:searchKey% or " +
            "u.email like %:searchKey% ) and " +
            "u.company = :company")
    List<User> findByCompany(@Param("company") Company company, @Param("searchKey") String searchKey);
}
