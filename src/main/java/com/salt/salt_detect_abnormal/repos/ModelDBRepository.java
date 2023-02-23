package com.salt.salt_detect_abnormal.repos;


import com.salt.salt_detect_abnormal.domain.MyModelDB;
import com.salt.salt_detect_abnormal.model.MyModelDBDTO;
import org.springframework.stereotype.Component;

@Component
public interface ModelDBRepository {


    static MyModelDBDTO save(MyModelDB myModelDB) {
        return null;
    }
}
