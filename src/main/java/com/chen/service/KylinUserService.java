package com.chen.service;

import com.chen.bean.KylinUser;
import com.chen.dao.KylinUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KylinUserService {

    @Autowired
    private KylinUserDAO kylinUserDAO;

    public KylinUser getUser(){
        return kylinUserDAO.getUser();
    }
}
