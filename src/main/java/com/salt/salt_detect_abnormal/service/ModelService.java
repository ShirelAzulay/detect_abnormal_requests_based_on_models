package com.salt.salt_detect_abnormal.service;


import com.salt.salt_detect_abnormal.domain.MyModelDB;
import com.salt.salt_detect_abnormal.model.*;
import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import com.salt.salt_detect_abnormal.repos.StatefulMapConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModelService {

    private final ModelDBRepository modelDBRepository;
    @Autowired
    StatefulMapConfig statefulMapConfig;

    public ModelService(final ModelDBRepository modelDBRepository) {
        this.modelDBRepository = modelDBRepository;
    }


    public String create(final List<RequestConfigDto> requestConfigDtos) {

        /////
//        need to delete shirel:

        statefulMapConfig.myStatefulMap().put("key1", requestConfigDtos.get(0).getPath());
        System.out.println("after change = " + statefulMapConfig.myStatefulMap().get("key1"));
        /////


        final MyModelDB myModelDB = new MyModelDB();

        requestConfigDtos.forEach(current->
            {mapToEntity(current, myModelDB);
             ModelDBRepository.save(myModelDB);
            });
        return "succeeded";
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
