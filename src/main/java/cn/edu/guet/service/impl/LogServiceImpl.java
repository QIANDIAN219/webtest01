package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Log;
import cn.edu.guet.dao.ILogDao;
import cn.edu.guet.dao.impl.LogDaoImpl;
import cn.edu.guet.service.ILogService;

public class LogServiceImpl implements ILogService {
    @Override
    public void insertLog(Log log) {
        ILogDao logDao = new LogDaoImpl();
        logDao.insertLog(log);
    }
}
