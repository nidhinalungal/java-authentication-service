package com.factweavers.authenticationservice.domain.workspace;

public enum ValuationMethodType {
    SALES_COMPARISON_METHOD("Sales comparison method"),
    COST_METHOD("Cost method"),
    DISCOUNTED_CASH_FLOW_METHOD("Discounted cashflow method"),
    DIRECT_METHOD("Direct method"),
    RESIDUAL_METHOD("Residual method");

    private String value;

    public String getValue() {
        return value;
    }

    ValuationMethodType(String value) {
        this.value = value;
    }
}
