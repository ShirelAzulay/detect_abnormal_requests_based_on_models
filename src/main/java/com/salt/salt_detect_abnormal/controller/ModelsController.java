

package com.salt.salt_detect_abnormal.controller;

import com.salt.salt_detect_abnormal.model.RequestConfigDto;
import com.salt.salt_detect_abnormal.service.ModelService;
import com.salt.salt_detect_abnormal.util.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/models")
public class ModelsController {

    private final ModelService modelService;

    public ModelsController(final ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("models") @Valid final RequestConfigDto requestConfigDto,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "modelsDB/add";
        }
        modelService.create (requestConfigDto);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("modelsDB.create.success"));
        return "redirect:/models";
    }


    @PostMapping("/add222")
    public String add222(@ModelAttribute("models") @Valid final RequestConfigDto requestConfigDto,
                      final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "modelsDB/add";
        }
        modelService.create (requestConfigDto);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("modelsDB.create.success"));
        return "redirect:/models";
    }
}

