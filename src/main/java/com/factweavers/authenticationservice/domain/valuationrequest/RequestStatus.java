package com.factweavers.authenticationservice.domain.valuationrequest;

public enum RequestStatus {
    // Todo; Need to replace statusAr with arabic values
    NEW("#169BFB", "New", "جديد"),
    // Todo; color code not decided yet. Currently using color code of status: under valuation
    PENDING_VALUATION("#45D7F6", "Pending Valuation", "التقييم المعلق"),
    UNDER_VALUATION("#45D7F6", "Under Valuation", "تحت التقييم"),
    PENDING_REVIEW("#F0A81C", "Pending Review", "في انتظار المراجعة"),
    UNDER_REVIEW("#7033FF", "Under Review", "قيد المراجعة"),
    COMPLETED("#71ECA2", "Completed", "مكتمل"),
    // Todo; color code not decided yet. Currently using colour code of status: returned.
    VALUER_RETURNED("#FE8878", "Valuer Returned", "عاد المثمن"),
    REJECTED("#E54353", "Rejected", "مرفوض"),
    // Todo; color code not decided yet. Currently using colour code of status: returned.
    AUDITOR_RETURNED("#FE8878", "Auditor Returned", "عاد المدقق"),
    CANCELED("#D97706", "Cancelled", "ألغيت");

    private String colourCode;
    private String statusEn;
    private String statusAr;

    public String getColourCode() {
        return colourCode;
    }
    public String getStatusEn() {
        return statusEn;
    }

    public String getStatusAr() {
        return statusAr;
    }

    RequestStatus(String colourCode, String statusEn, String statusAr) {
        this.colourCode = colourCode;
        this.statusEn = statusEn;
        this.statusAr = statusAr;
    }
}
