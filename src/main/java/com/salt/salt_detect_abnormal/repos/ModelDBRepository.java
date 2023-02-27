package com.salt.salt_detect_abnormal.repos;


import com.salt.salt_detect_abnormal.model.model_template.Model;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public interface ModelDBRepository {

    Logger logger = LoggerFactory.getLogger(ModelDBRepository.class);



    public String saveModel(ModelTemplateDB modelTemplateDB);

    Model getModel(Model modelTemplateDto);


}
