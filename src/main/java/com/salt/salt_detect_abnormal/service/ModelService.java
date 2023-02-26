package com.salt.salt_detect_abnormal.service;


import com.salt.salt_detect_abnormal.domain.MyModelDB;
import com.salt.salt_detect_abnormal.model.*;
import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import com.salt.salt_detect_abnormal.repos.StatefulMapConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModelService {

    private final ModelDBRepository modelDBRepository;
    @Autowired
    StatefulMapConfig statefulMapConfig;

    public ModelService(final ModelDBRepository modelDBRepository) {
        this.modelDBRepository = modelDBRepository;
    }


    public String create(final RequestConfigDto requestConfigDto) {
        final MyModelDB myModelDB = new MyModelDB();
        mapToEntity(requestConfigDto, myModelDB);
        return ModelDBRepository.save(myModelDB);
    }


    private RequestConfigDto mapToDTO(final MyModelDB myModelDB, final RequestConfigDto requestConfigDto) {
     /*   myModelDBDTO.setId(myModelDB.getId());
        myModelDBDTO.setName(myModelDB.getName());
        myModelDBDTO.setComments(myModelDB.getComments());*/
        return requestConfigDto;
    }

    private MyModelDB mapToEntity(final RequestConfigDto requestConfigDto , final MyModelDB myModelDB) {
       /* myModelDB.setName(myModelDBDTO.getName());
        myModelDB.setComments(myModelDBDTO.getComments());*/
        return myModelDB;
    }

}
