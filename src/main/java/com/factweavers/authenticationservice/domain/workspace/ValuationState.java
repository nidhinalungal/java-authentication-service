package com.factweavers.authenticationservice.domain.workspace;

import lombok.Data;

@Data
public class ValuationState {
    private ValuationStateType state1;
    private ValuationStateType state2;
    private ValuationStateType state3;
    private ValuationStateType state4;

    @Override
    public String toString() {
        return "{" +
                "\"state1\": \"" + state1 + "\"," +
                "\"state2\": \"" + state2 + "\"," +
                "\"state3\": \"" + state3 + "\"," +
                "\"state4\": \"" + state4 + "\"" +
                '}';
    }

}
