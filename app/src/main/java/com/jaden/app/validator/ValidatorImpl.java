package com.jaden.app.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


/**
 * Created by tangjiejin on 2018/12/26
 */
@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 初始化Validator
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public ValidationResult validate(Object bean){
        Set<ConstraintViolation<Object>> validateSet = this.validator.validate(bean);
        ValidationResult result = new ValidationResult();
        if (validateSet.size() > 0){
            // 校验有不合规的参数
            result.setHasError(true);
            validateSet.forEach(validate -> {
                String message = validate.getMessage();
                String property = validate.getPropertyPath().toString();
                result.getErrorMap().put(property,message);
            });
        }
        return result;
    }
}






















