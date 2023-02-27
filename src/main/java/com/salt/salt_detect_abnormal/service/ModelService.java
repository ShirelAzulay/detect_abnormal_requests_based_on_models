package com.salt.salt_detect_abnormal.service;


import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDto;
import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import com.salt.salt_detect_abnormal.repos.StatefulMaps;
import groovy.transform.Internal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModelService {

    @Autowired
    private final ModelDBRepository modelDBRepository;


    public ModelService(final ModelDBRepository modelDBRepository) {
        this.modelDBRepository = modelDBRepository;
    }


    public String addModel(final List<ModelTemplateDto> modelTemplateDtos) {
        modelTemplateDtos.forEach(currentDto ->
                modelDBRepository.saveModel(convertDtoToEntityDB(currentDto)));
        return "succeeded";
    }

    @Internal
    public String getModel(final List<ModelTemplateDto> modelTemplateDtos) {
        modelTemplateDtos.forEach(currentDto ->
                modelDBRepository.getModel(currentDto));
        return "succeeded";
    }


    private ModelTemplateDB convertDtoToEntityDB(final ModelTemplateDto modelTemplateDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(modelTemplateDto, ModelTemplateDB.class);
    }

    private ModelTemplateDto convertEntityDBToDto(final ModelTemplateDB modelTemplateDB) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(modelTemplateDB, ModelTemplateDto.class);
    }

}
