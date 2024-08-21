package com.factweavers.authenticationservice.domain.workspace;

public enum SortType {
   SELL_PRICE("sellPrice"),
   UNIT_AREA("unitArea"),
    LAND_AREA("landArea");

    private String sortField;

    public String getSortField() {
        return sortField;
    }

    SortType(String sortField) {
        this.sortField = sortField;
    }
}
