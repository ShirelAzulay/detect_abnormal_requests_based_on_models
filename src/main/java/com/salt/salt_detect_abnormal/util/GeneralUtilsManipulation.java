package com.salt.salt_detect_abnormal.util;

import com.salt.salt_detect_abnormal.model.model_template.Model;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import com.salt.salt_detect_abnormal.repos.StatefulMaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralUtilsManipulation {

    @Autowired
    StatefulMaps statefulMaps;

    public void addModelToMap(ModelTemplateDB modelTemplateDB, String calcKey){
        statefulMaps.statefulMapAsDB().put(calcKey, modelTemplateDB);
    }

    public Model getModelFromMap(String calcKey){
        return (Model) statefulMaps.statefulMapAsDB().get(calcKey);
    }

    public String calcKey(Model modelTemplateDB) {
        return modelTemplateDB.getPath() + "_" + modelTemplateDB.getMethod();
    }
}
