package com.jaden.app.validator;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by tangjiejin on 2018/12/26
 */
public class ValidationResult {

    Boolean hasError = false;

    Map<String,String> errorMap = new HashMap();

    public Boolean isHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public Map getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map errorMap) {
        this.errorMap = errorMap;
    }

    public String getErrorMsg(){

        return StringUtils.join(this.errorMap.values().toArray(),",");
    }
}
