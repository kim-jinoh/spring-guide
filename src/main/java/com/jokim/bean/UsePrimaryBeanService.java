package com.jokim.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsePrimaryBeanService {

    private final QualifierService qualifierService;

    @Autowired
    public UsePrimaryBeanService(QualifierService qualifierService) {
        this.qualifierService = qualifierService;
    }

    public QualifierService getQualifierService() {
        return qualifierService;
    }
}
