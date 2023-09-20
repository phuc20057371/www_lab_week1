package com.example.lab_week2.services;

import com.example.lab_week2.repositoty.LogRepository;

public class LogService {
    private LogRepository logRepository;
    public LogService() {
        logRepository = new LogRepository();
    }
    public void insert(com.example.lab_week2.entity.Log log){
        logRepository.insert(log);
    }
}
