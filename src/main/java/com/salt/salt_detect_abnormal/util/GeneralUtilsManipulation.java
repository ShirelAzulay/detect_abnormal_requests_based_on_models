package com.salt.salt_detect_abnormal.util;

import com.salt.salt_detect_abnormal.model.model_template.Model;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import com.salt.salt_detect_abnormal.repos.StatefulMaps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GeneralUtilsManipulation {

    Logger logger = LoggerFactory.getLogger(GeneralUtilsManipulation.class);

    @Autowired
    StatefulMaps statefulMaps;

    public void addModelToMap(ModelTemplateDB modelTemplateDB, String calcKey) {
        try {

            statefulMaps.statefulMapAsDB().put(calcKey, modelTemplateDB);
            handleAndUpdateQueryParams(modelTemplateDB, calcKey);
            handleAndUpdateHeaders(modelTemplateDB, calcKey);
            handleAndUpdateBody(modelTemplateDB, calcKey);
        } catch (Exception e) {
            logger.error(GeneralMsgUtils.SOMETHING_WAS_WRONG, e.getCause());
            revertAllImmidetly(modelTemplateDB);
        }

    }

    private void revertAllImmidetly(ModelTemplateDB modelTemplateDB) {
        //TBD
    }

    /* ConcurrentHashMap<String, Model.QueryParam> internalMapQueryParam = (ConcurrentHashMap<String, Model.QueryParam>) modelTemplateDB.getQueryParams().stream()
             .collect(Collectors.toMap(Model.QueryParam::getName, p -> p));*/
    private void handleAndUpdateQueryParams(ModelTemplateDB modelTemplateDB, String calcKey) {
        ConcurrentHashMap<String, Model.QueryParam> internalMapQueryParam = new ConcurrentHashMap<>();

        List<Model.QueryParam> queryParams = modelTemplateDB.getQueryParams();
        for (int i = 0; i < queryParams.size(); i++) {
            internalMapQueryParam.put(queryParams.get(i).getName(), queryParams.get(i));
        }

        statefulMaps.statefulMapQueryParams().put(calcKey, internalMapQueryParam);
    }


    private void handleAndUpdateHeaders(ModelTemplateDB modelTemplateDB, String calcKey) {
        ConcurrentHashMap<String, Model.Header> internalMapHeaders = new ConcurrentHashMap<>();
        List<Model.Header> headers = modelTemplateDB.getHeaders();
        for (int i = 0; i < headers.size(); i++) {
            internalMapHeaders.put(headers.get(i).getName(), headers.get(i));
        }

        statefulMaps.statefulMapQueryParams().put(calcKey, internalMapHeaders);
    }

    private void handleAndUpdateBody(ModelTemplateDB modelTemplateDB, String calcKey) {
        ConcurrentHashMap<String, Model.Body> internalMapBody = new ConcurrentHashMap<>();
        List<Model.Body> bodys = modelTemplateDB.getBody();
        for (int i = 0; i < bodys.size(); i++) {
            internalMapBody.put(bodys.get(i).getName(), bodys.get(i));
        }

        statefulMaps.statefulMapQueryParams().put(calcKey, internalMapBody);
    }


    public Model getModelFromMap(String calcKey) {
        return (Model) statefulMaps.statefulMapAsDB().get(calcKey);
    }

    public String calcKeyGlobalMapDB(Model modelTemplateDB) {
        return modelTemplateDB.getPath() + "_" + modelTemplateDB.getMethod();
    }
}
