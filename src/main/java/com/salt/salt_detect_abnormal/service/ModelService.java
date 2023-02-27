package com.salt.salt_detect_abnormal.service;


import com.salt.salt_detect_abnormal.model.model_template.Model;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDto;
import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import com.salt.salt_detect_abnormal.repos.StatefulMaps;
import com.salt.salt_detect_abnormal.util.GeneralUtilsManipulation;
import groovy.transform.Internal;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;


@Service
public class ModelService {


    @Autowired
    private final ModelDBRepository modelDBRepository;
    @Autowired
    GeneralUtilsManipulation generalUtilsManipulation;
    @Autowired
    StatefulMaps statefulMaps;

    final StringBuffer summary = new StringBuffer("Summary:\n");

    Logger logger = LoggerFactory.getLogger(ModelService.class);


    public ModelService(final ModelDBRepository modelDBRepository) {
        this.modelDBRepository = modelDBRepository;
    }


    public String addModel(final List<ModelTemplateDto> modelTemplateDtos) {
        modelTemplateDtos.forEach(currentDto ->
                modelDBRepository.saveModel(convertDtoToEntityDB(currentDto)));
        return "succeeded";
    }

    @Internal
    public String getModel(final List<ModelTemplateDto> modelTemplateDtos) {
        modelTemplateDtos.forEach(currentDto ->
                modelDBRepository.getModel(currentDto));
        return "succeeded";
    }

    public String verifyModel(final ModelTemplateDto modelTemplateDto) {
        String calcKeyGlobalMapDB = generalUtilsManipulation.calcKeyGlobalMapDB(modelTemplateDto);

        final StringBuffer summary = new StringBuffer("Summary:\n");
        if ((verifyQueryParam(calcKeyGlobalMapDB)) && verifyHeader(calcKeyGlobalMapDB) && verifyBody(calcKeyGlobalMapDB))
        {
            logger.info("The Request is Valid");
            summary.append("The Request is Valid");
        }else {
            logger.info("### The Request is not Valid ###");
            summary.append("### The Request is not Valid ###");
        }
        return summary.toString();

    }


    private boolean verifyQueryParam(String calcKeyGlobalMapDB) {
        Model.QueryParam relevantQueryParam = (Model.QueryParam) statefulMaps.statefulMapQueryParams().get(calcKeyGlobalMapDB);
        boolean isValid = true; //change one time
        if (isQueryParamNull(relevantQueryParam)) {
            isValid = false;
        }
        if (!hasField(relevantQueryParam, "name")) {
            isValid = false;
            summary.append("QueryParam doesn't contain 'name' field");
        }
        if (!hasField(relevantQueryParam, "types")) {
            isValid = false;
            summary.append("QueryParam doesn't contain 'types' field");
        }

        if (isValid == false) {
            summary.append("** QueryParam Is Not Valid **");
            return false;
        } else {
            summary.append("** QueryParam Is Valid **");
            return true;
        }


    }

    private boolean verifyHeader(String calcKeyGlobalMapDB) {
        Model.Header relevantHeader = (Model.Header) statefulMaps.statefulMapHeaders().get(calcKeyGlobalMapDB);
        boolean isValid = true; //change one time
        if (isHeaderNull(relevantHeader)) {
            isValid = false;
        }
        if (!hasField(relevantHeader, "name")) {
            isValid = false;
            summary.append("Header doesn't contain 'name' field");

        }
        if (!hasField(relevantHeader, "types")) {
            isValid = false;
            summary.append("Header doesn't contain 'types' field");
        }

        if (isValid == false) {
            summary.append("** Header Is Not Valid **");
            return false;
        } else {
            summary.append("** Header Is Valid **");
            return true;
        }

    }

    private boolean verifyBody(String calcKeyGlobalMapDB) {
        Model.Body relevantBody = (Model.Body) statefulMaps.statefulMapBody().get(calcKeyGlobalMapDB);
        boolean isValid = true; //change one time
        if (isBodyNull(relevantBody)) {
            isValid = false;
        }
        if (!hasField(relevantBody, "name")) {
            isValid = false;
            summary.append("Header doesn't contain 'name' field");

        }
        if (!hasField(relevantBody, "types")) {
            isValid = false;
            summary.append("Header doesn't contain 'types' field");
        }

        if (isValid == false) {
            summary.append("** Body Is Not Valid **");
            return false;
        } else {
            summary.append("** Body Is Valid **");
            return true;
        }

    }

    private boolean isQueryParamNull(Model.QueryParam relevantQueryParam) {

        if (relevantQueryParam == null) {

            summary.append("QueryParam").append(" is null\n");
            return true;
        }
        return false;
    }

    private boolean isHeaderNull(Model.Header relevantHeader) {

        if (relevantHeader == null) {

            summary.append("Header").append(" is null\n");
            return true;
        }
        return false;
    }

    private boolean isBodyNull(Model.Body relevantBody) {

        if (relevantBody == null) {

            summary.append("Body").append(" is null\n");
            return true;
        }
        return false;
    }

    public boolean hasField(Model current, String fieldName) {
        try {
            Field field = current.getClass().getDeclaredField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    private ModelTemplateDB convertDtoToEntityDB(final ModelTemplateDto modelTemplateDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(modelTemplateDto, ModelTemplateDB.class);
    }

    private ModelTemplateDto convertEntityDBToDto(final ModelTemplateDB modelTemplateDB) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(modelTemplateDB, ModelTemplateDto.class);
    }

}
