

package com.salt.salt_detect_abnormal.controller;

import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDto;
import com.salt.salt_detect_abnormal.service.ModelService;
import com.salt.salt_detect_abnormal.util.*;
import groovy.transform.Internal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/models")
public class ModelsController {

    Logger logger = LoggerFactory.getLogger(ModelsController.class);


    private final ModelService modelService;

    public ModelsController(final ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/addModel")
    public String addModel(final @RequestBody List<ModelTemplateDto> modelTemplateDtos,
                       final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        try{
            String failed = getStatus(bindingResult);
            if (failed != null) return failed;
            modelService.addModel(modelTemplateDtos);
            redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("modelsDB.create.success"));
            logger.info(GeneralMsgUtils.ACTION_WAS_SUCCEEDED);
            return "success";
        }
        catch (Exception e){
            return "failed";
        }
    }

    @PostMapping("/verifyRequest")
    @Internal
    public String getModel(final @RequestBody List<ModelTemplateDto> modelTemplateDtos,
                           final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        try{
            String failed = getStatus(bindingResult);
            if (failed != null) return failed;
            modelService.getModel(modelTemplateDtos);
            redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("modelsDB.create.success"));
            logger.info(GeneralMsgUtils.ACTION_WAS_SUCCEEDED);
            return "success";
        }
        catch (Exception e){
            return "failed";
        }
    }

    private String getStatus(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error(GeneralMsgUtils.SOMETHING_WAS_WRONG, bindingResult.getFieldError().toString());
            return "failed";
        }
        return null;
    }
}

