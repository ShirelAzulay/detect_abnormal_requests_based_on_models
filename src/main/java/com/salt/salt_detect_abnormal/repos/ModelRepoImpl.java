package com.salt.salt_detect_abnormal.repos;

import com.salt.salt_detect_abnormal.model.model_template.Model;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import com.salt.salt_detect_abnormal.util.GeneralMsgUtils;
import com.salt.salt_detect_abnormal.util.GeneralUtilsManipulation;
import org.springframework.stereotype.Service;

@Service("ModelDBRepository")
public class ModelRepoImpl implements ModelDBRepository{
    final GeneralUtilsManipulation generalUtilsManipulation;


     public String saveModel(ModelTemplateDB modelTemplateDB) {
        String calcKey = null;
        try {
            calcKey = generalUtilsManipulation.calcKeyGlobalMapDB(modelTemplateDB);
            generalUtilsManipulation.addModelToMap(modelTemplateDB, calcKey);
            return calcKey;
        } catch (Exception e) {
            logger.error(GeneralMsgUtils.SKIP_THE_CURRENT_VALUE, calcKey);
            return null;
        }

    }

    public Model getModel(Model modelTemplateDto) {
        String calcKey;
        try {
            calcKey = generalUtilsManipulation.calcKeyGlobalMapDB(modelTemplateDto);
            return generalUtilsManipulation.getModelFromMap(calcKey);
        } catch (Exception e) {
            logger.error(GeneralMsgUtils.SOMETHING_WAS_WRONG, e.getCause());
            return null;
        }

    }

    public ModelRepoImpl(GeneralUtilsManipulation generalUtilsManipulation) {
        this.generalUtilsManipulation = generalUtilsManipulation;
    }

}
