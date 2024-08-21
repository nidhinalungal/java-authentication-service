package com.factweavers.authenticationservice.domain.workspace;

import com.factweavers.authenticationservice.domain.valuationrequest.ValuationRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "dv_valuation_method")
public class ValuationMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ValuationMethodType valuationMethod;
    private Double basePrice;
    private Double noi;
    private Double posNegAppreciation;
    private Double constructionCostPerSqm;
    private Double constructionAge;
    private Double marketDiscountedRate;
    private Double calculatedPrice;
    private Double grossDevelopmentCost;
    private Double grossDevelopmentRevenue;
    private Boolean isSelectedValuationMethod;

    @ManyToOne
    @JoinColumn(name = "valuation_request_id")
    private ValuationRequest valuationRequest;
}
