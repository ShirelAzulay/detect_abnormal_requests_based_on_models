package com.salt.salt_detect_abnormal.repos;

import org.springframework.stereotype.Service;

@Service("ModelDBRepository")
public class ModelRepoImpl implements ModelDBRepository{

    public ModelRepoImpl() {
        System.out.println("Do nothing");
    }

}
