package com.factweavers.authenticationservice.domain.valuationrequest;


import com.factweavers.authenticationservice.domain.Document;
import com.factweavers.authenticationservice.domain.User;
import com.factweavers.authenticationservice.domain.property.PropertyType;
import com.factweavers.authenticationservice.domain.workspace.ValuationMethod;
import com.factweavers.authenticationservice.domain.workspace.ValuationState;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "dv_valuation_requests")
@Getter
@Setter
public class ValuationRequest {
    // Todo; rename requestId to id. corresponding changes in Dto is also required.
    @Id
    private String requestId;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
    @CreationTimestamp
    private LocalDateTime initiatedOn;
    @Enumerated(EnumType.STRING)
    private RequestSource source;
    private String initiator;
    @Enumerated(EnumType.STRING)
    private RequestorType requestorType;
    private String requestor;
    private String requestorId;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
    private String assignedBy;
    private String unAssignedBy;
    private LocalDateTime assignedDateTime;
    private LocalDateTime unAssignedDateTime;
    private Long plotId;
    private Long unitId;
    private String remarks;
    @Enumerated(EnumType.STRING)
    private ValuationPurpose valuationPurpose;
    private String sellingPrice;
    private Float maintenanceCost;
    private String applicationSource;
    private String assignedMunicipalityId;
    private String assignedCompanyId;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private String valuationPurposeOther;
    private String address;
    private String type;
    private String comments;
    private String valuerEstimation;
    private String valuationJustification;
    private String additionalComments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "valuer_id")
    private User valuer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auditor_id")
    private User auditor;

    @OneToMany(mappedBy = "valuationRequest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Document> documents;

    @OneToMany(mappedBy = "valuationRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ValuationRequestLog> valuationRequestLogs;

    @OneToMany(mappedBy = "valuationRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ValuationMethod> valuationMethods;

    private String propertyComparable;

    public List<Long> getPropertyComparable() {
        if (Objects.isNull(propertyComparable))
            return null;
        String propertyComparableAsCSVString = propertyComparable.substring(1, propertyComparable.length() - 1);
        return Arrays.stream(propertyComparableAsCSVString.split(", "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public void setPropertyComparable(List<Long> propertyComparable) {
        if (Objects.nonNull(propertyComparable) && propertyComparable.size() > 0)
            this.propertyComparable = propertyComparable.toString();
        else
            this.propertyComparable = null;
    }

    private String valuationState = null;

    public void setValuationState(ValuationState valuationState) {
        if (Objects.nonNull(valuationState))
            this.valuationState = valuationState.toString();
        else
            this.valuationState = null;
    }
}
