

package com.salt.salt_detect_abnormal.controller;

import com.salt.salt_detect_abnormal.model.RequestConfigDto;
import com.salt.salt_detect_abnormal.service.ModelService;
import com.salt.salt_detect_abnormal.util.*;
import jakarta.validation.Valid;
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
    public String add(final @RequestBody List<RequestConfigDto> requestConfigDtos,
                       final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "modelsDB/add";
        }
        modelService.create (requestConfigDtos);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("modelsDB.create.success"));
        return "redirect:/models";
    }
}

