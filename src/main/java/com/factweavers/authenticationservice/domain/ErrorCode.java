package com.factweavers.authenticationservice.domain;

public enum ErrorCode {

    BAD_REQUEST("DV400BRQ", "Bad request"),
    UNAUTHORISED("DV401AUT", "Unauthorised"),
    EXPIRED_TOKEN("DV401TKE", "The token is expired and not valid anymore"),
    MALFORMED_TOKEN("DV401TKM", "The token is invalid"),
    REFRESH_TOKEN_INVALID("DV401RTK","Refresh Token not in the database"),
    REFRESH_TOKEN_EXPIRED("DV401RTE","Refresh token was expired. Please make a new signin request"),
    FEIGN_ERROR("DV400FGN","Data insufficient or Provider error"),
    INACTIVE_USER("DV401IUS","Your account is in-active, Please contact your administrator"),
    INVALID_CREDENTIALS("DV401USR","Invalid credentials"),
    INVALID_USER("DV404USR","User not found"),
    INVALID_ROLE("DV404RLE","Role not found"),
    INVALID_PIN("DV404PIN","Invalid pinId"),
    INVALID_REQUEST("DV404REQ","Invalid  request"),
    INVALID_DOC("DV404DOC","Document not found"),
    PLOT_NOT_FOUND("DV404PLT","Plot not found"),
    UNIT_NOT_FOUND("DV404UNT","Unit not found"),

    INVALID_MUNICIPALITY("DV404MUN","Municipality not registered in the system"),
    INVALID_COMPANY("DV404CMP","Company not registered in the system"),
    INVALID_PROPERTY("DV404PRP","Property details not found"),
    INVALID_PROPERTY_REQUEST("DV404PLS","You can search a plot either by plot address or by municipality Id,district Id, community Id, road Id and plot Number"),
    PROPERTY_EXCEPTION("DV409PRP","Error while fetching property details"),
    INVALID_MOBILE("DV404MOB","Sorry we could not found any mobile number registered"),
   INVALID_OTP("DV404OTP","This otp is invalid"),
    INVALID_EID("DV404EID","EID not recognized. Only licensed valuers are allowed to login"),
    ALG_ERROR("DV500ALG","Couldn't validate the user. Please try Re-login"),
    EMAIL_ERROR("DV500EML","Couldn't sent Email"),
    UPDATE_USER_ERROR("DV500USU","Unable to update user"),
    FETCH_DETAILS_ERROR("DV500INF","Unable to fetch details"),
    DELETE_USER_ERROR("DV500DUS","Unable to delete user"),
    MUNICIPALITY_NOT_ASSIGNED("DV500MUS","User has no municipality assigned, Unable to fetch users"),
    COMPANY_NOT_ASSIGNED("DV500CUS","User has no company assigned, Unable to fetch users"),
    INVALID_FILE_FORMAT("DV500FLE","The file is not supported in the system. Please use the allowed file formats(pdf,doc,img etc"),
   FILE_UPLOAD_ERROR("DV500FLU","File upload failed"),
    FILE_DOWNLOAD_ERROR("DV500FLU","File download failed"),
    CREATE_USER_ERROR("DV500FLU","Couldn't create user"),
    USER_EMAIL_EXISTING_ERROR("DV409USE","User with the provided email already present"),
    USER_COMPANY_MISMATCH_ERROR("DV403MUS","User not under your company"),
    USER_MUNICIPLAITY_MISMATCH_ERROR("DV403MUS","User not under your municipality"),
    INTERNAL_SERVER_ERROR("DV500SER","Internal server error"),
    REQUEST_FETCHING_ERROR("DV500RQD","Failed fetching request details, please retry"),
    INITIATE_VAL_REQUEST_ERROR("DV500REQ","Exception occurred while initiating the valuation request"),
    EXCEL_REPORT_GENERATE_ERROR("DV500EXL","Exception occurred while generating excel"),
    UAEPASS_AUTH_INITIATE_ERROR("DV500UAP","Exception occurred while initiating authentication using uae pass"),
    UAEPASS_AUTH_ERROR("DV500UAP","Exception occurred while authenticating using uae pass"),
    UAEPASS_VALIDATION_USER_NOT_FOUND_ERROR("DV404UAU","User details not found, validation with UaePass user info failed"),
    UAEPASS_VALIDATION_ERROR("DV500UAU","validation with UaePass user info failed"),
    HTML_ERROR("DV500HTM","HTML error"),
    ASSIGN_REQUEST_USER_ERROR("DV500RUS","Exception occurred while assigning requests"),
    PRE_REQUIREMENT_FAILED_USER("DV500PRU","Pre-requirement failed"),
    UNDER_VALUATION_REJECT_ERROR("DV403URJ","User cannot reject the request when status is"),
    UNDER_VALUATION_RETURN_ERROR("DV403URT","User cannot return the request when status is"),
    UNDER_REVIEW_RETURN_ERROR("DV403URR","User cannot return the request when status is"),
    UNDER_REVIEW_CANCEL_ERROR("DV403URC","User cannot cancel a request when status is"),
    // Todo; Add error code
    INVALID_STATUS_UPDATE_ERROR("","Invalid status update request"),
    INVALID_PLOT_SEARCH("DV404PLT","Plot is found, but this plot is not under your muncipality"),
    COMPARABLES_NOT_AVAILABLE("DV404CMB","Comparables not availble for this property"),
    PLOT_UNDER_VALUATION_NOT_FOUND("DV404PLV","Plot corresponds to valuation not found"),
    UNIT_UNDER_VALUATION_NOT_FOUND("DV404UNV","Unit corresponds to valuation not found");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }


    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
