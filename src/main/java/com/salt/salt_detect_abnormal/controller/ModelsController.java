

package com.salt.salt_detect_abnormal.controller;

import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDto;
import com.salt.salt_detect_abnormal.service.ModelService;
import com.salt.salt_detect_abnormal.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/models")
public class ModelsController {

    private final ModelService modelService;

    public ModelsController(final ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/add")
    public String add(final @RequestBody List<ModelTemplateDto> modelTemplateDtos,
                       final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "modelsDB/add";
        }
        modelService.create (modelTemplateDtos);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("modelsDB.create.success"));
        return "redirect:/models";
    }
}

