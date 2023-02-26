package com.salt.salt_detect_abnormal.service;


import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDB;
import com.salt.salt_detect_abnormal.model.model_template.ModelTemplateDto;
import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import com.salt.salt_detect_abnormal.repos.StatefulMapConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModelService {


    @Autowired
    StatefulMapConfig statefulMapConfig;

    @Autowired
    private final ModelDBRepository modelDBRepository;


    public ModelService(final ModelDBRepository modelDBRepository) {
        this.modelDBRepository = modelDBRepository;
    }


    public String create(final List<ModelTemplateDto> modelTemplateDtos) {
        modelTemplateDtos.forEach(currentDto-> modelDBRepository.save(statefulMapConfig, mapToEntityDB(currentDto)));
        return "succeeded";
    }





    private ModelTemplateDto mapToDTO(final ModelTemplateDB modelTemplateDB) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(modelTemplateDB, ModelTemplateDto.class);
    }

    private ModelTemplateDB mapToEntityDB(final ModelTemplateDto modelTemplateDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(modelTemplateDto, ModelTemplateDB.class);
    }

}
