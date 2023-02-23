package com.salt.salt_detect_abnormal.service;


import com.salt.salt_detect_abnormal.domain.MyModelDB;
import com.salt.salt_detect_abnormal.model.*;
import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import org.springframework.stereotype.Service;


@Service
public class ModelService {

    private final ModelDBRepository modelDBRepository;

    public ModelService(final ModelDBRepository modelDBRepository) {
        this.modelDBRepository = modelDBRepository;
    }


    public Long create(final MyModelDBDTO myModelDBDTO) {
        final MyModelDB myModelDB = new MyModelDB();
        mapToEntity(myModelDBDTO, myModelDB);
        return ModelDBRepository.save(myModelDB).getId();
    }


    private MyModelDBDTO mapToDTO(final MyModelDB myModelDB, final MyModelDBDTO myModelDBDTO) {
        myModelDBDTO.setId(myModelDB.getId());
        myModelDBDTO.setName(myModelDB.getName());
        myModelDBDTO.setComments(myModelDB.getComments());
        return myModelDBDTO;
    }

    private MyModelDB mapToEntity(final MyModelDBDTO myModelDBDTO, final MyModelDB myModelDB) {
        myModelDB.setName(myModelDBDTO.getName());
        myModelDB.setComments(myModelDBDTO.getComments());
        return myModelDB;
    }

}
