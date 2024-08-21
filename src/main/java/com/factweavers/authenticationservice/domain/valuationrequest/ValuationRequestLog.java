package com.factweavers.authenticationservice.domain.valuationrequest;

import com.factweavers.authenticationservice.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "dv_valuation_request_log")
public class ValuationRequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "valuation_request_request_id")
    private ValuationRequest valuationRequest;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RequestStatus oldStatus;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RequestStatus newStatus;
    @ManyToOne
    @JoinColumn(name = "updated_by_user_id")
    private User updatedBy;
    @CreationTimestamp
    private LocalDateTime updatedAt;
    @NotNull
    private String comments;

    private  String type;
}
