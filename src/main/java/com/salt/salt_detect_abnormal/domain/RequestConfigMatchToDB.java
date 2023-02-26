package com.salt.salt_detect_abnormal.domain;

import com.salt.salt_detect_abnormal.model.RequestConfigDto;

import java.util.concurrent.ConcurrentHashMap;

public class RequestConfigMatchToDB {
    //ConcurrentHashMap <String, RequestConfigDto> map = new ConcurrentHashMap();
    public void addToMap(ConcurrentHashMap map, RequestConfigDto requestConfigDto){
    map.put(calcKey(requestConfigDto), requestConfigDto);
    }

    private String calcKey(RequestConfigDto requestConfigDto) {
        return requestConfigDto.getPath() + requestConfigDto.getMethod();
    }



}
