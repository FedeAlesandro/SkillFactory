package com.example.usersAPI.models;

import com.example.usersAPI.utils.Constants;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogService {

    public LogService() {
        log.info(Constants.USER_SERVICE_LOG);
    }
}
