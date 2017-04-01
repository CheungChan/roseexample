package com.chen.dao;

import com.chen.bean.KylinUser;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface KylinUserDAO {
    @SQL("select id,account_name,phone,pwd,reg_time,update_time from kylin_user where id=1")
    public KylinUser getUser();
}
