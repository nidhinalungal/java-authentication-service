package com.factweavers.authenticationservice.domain;

import com.factweavers.authenticationservice.domain.valuationrequest.ValuationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dv_valuation_documents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;

    private String documentType;
    private String documentLink;
    private String documentName;
    private Boolean isWorkspaceSupportingDocument = false;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private ValuationRequest valuationRequest;

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", documentType='" + documentType + '\'' +
                ", documentLink='" + documentLink + '\'' +
                ", documentName='" + documentName + '\'' +
                '}';
    }
}