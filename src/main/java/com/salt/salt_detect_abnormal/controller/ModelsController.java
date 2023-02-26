

package com.salt.salt_detect_abnormal.controller;

import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDto;
import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import com.salt.salt_detect_abnormal.service.ModelService;
import com.salt.salt_detect_abnormal.util.*;
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

    @PostMapping("/add")
    public String add(final @RequestBody List<ModelTemplateDto> modelTemplateDtos,
                       final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "failed";
        }
        modelService.create (modelTemplateDtos);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("modelsDB.create.success"));
        logger.warn("succeeded");
        return "success";
    }
}

