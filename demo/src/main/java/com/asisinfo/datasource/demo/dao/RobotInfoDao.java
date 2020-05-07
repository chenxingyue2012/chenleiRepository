package com.asisinfo.datasource.demo.dao;

import com.asisinfo.datasource.demo.domain.RobotInfo;

public interface RobotInfoDao {
    RobotInfo queryRobotInfoByRobotCode(String robotCode);
    int modifyRobotNameByRobotCode(RobotInfo robotInfo);
}
