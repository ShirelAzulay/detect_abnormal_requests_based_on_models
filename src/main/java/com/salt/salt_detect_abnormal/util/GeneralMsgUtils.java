package com.salt.salt_detect_abnormal.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;


@Component
public class GeneralMsgUtils {
    public static final String SKIP_THE_CURRENT_VALUE = "Can't save this key : {} \n The system will continue to process the next input";
    public static final String VALUE_WAS_NOT_FOUND = "Value was not found for the current input: {}";
    public static final String SOMETHING_WAS_WRONG = "Something was wrong, please see below \n: {} " ;
    public static final String ACTION_WAS_SUCCEEDED = "The action was succeeded" ;

}
