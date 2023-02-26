package com.salt.salt_detect_abnormal.repos;


import com.salt.salt_detect_abnormal.model.model_template.Model;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public interface ModelDBRepository {

    Logger logger = LoggerFactory.getLogger(ModelDBRepository.class);


     default String save(StatefulMapConfig statefulMapConfig, ModelTemplateDB modelTemplateDB) {
         String calcKey = null;
         try {
                calcKey = calcKey(modelTemplateDB);
                addToMap(statefulMapConfig.myStatefulMap(), modelTemplateDB, calcKey);
                return calcKey;
            }catch (Exception e){
                logger.error("Can't insert this key : {} \n We will continue to the next input ", calcKey );
                return null;
         }

    }




    private void addToMap(ConcurrentHashMap<String, Model> map, ModelTemplateDB modelTemplateDB, String calcKey){
        map.put(calcKey, modelTemplateDB);
    }

    private String calcKey(ModelTemplateDB modelTemplateDB) {
        return modelTemplateDB.getPath() + "_" + modelTemplateDB.getMethod();
    }

}
