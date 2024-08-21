package com.factweavers.authenticationservice.config.security;

import com.factweavers.authenticationservice.domain.Constants;
import com.factweavers.authenticationservice.domain.CustomRuntimeException;
import com.factweavers.authenticationservice.domain.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.json.JSONException;
import org.json.JSONObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String message = Constants.SUCCESS_MESSAGE;
    private boolean status = true;
    private T data;
    private String errorCode;

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        String jsonString = "";
        try {
            jsonObject.put("message", this.message);
            jsonObject.put("status", this.status);
            if(this.errorCode!=null){
                jsonObject.put("errorCode", this.errorCode);
            }
            if (this.data != null) {
                jsonObject.put("data", this.data);
            }
            jsonString = jsonObject.toString();
        } catch (JSONException e) {
            throw new CustomRuntimeException(e.getMessage(), ErrorCode.INTERNAL_SERVER_ERROR.getCode());
        }
        return jsonString;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ApiResponse(String message, Boolean status, String errorCode) {
        this.status=status;
        this.message = message;
        this.errorCode = errorCode;
    }
}
