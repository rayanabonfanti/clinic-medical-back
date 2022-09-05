package com.clinical.medical.crud.service;

import com.clinical.medical.crud.model.Log;
import com.clinical.medical.crud.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("LogService")
public class LogService {
        @Autowired
        private LogRepository logRepository;

        public void saveLog(Log log)
        {
            //UserPrincipalDetailsService user = (UserPrincipalDetailsService) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //log.setUserInfo(user.getUsername());

            log.setCreationTime(new Date());
            logRepository.save(log);
        }
}
