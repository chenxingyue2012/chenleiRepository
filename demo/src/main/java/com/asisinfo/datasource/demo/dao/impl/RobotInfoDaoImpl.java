package com.asisinfo.datasource.demo.dao.impl;

import com.asisinfo.datasource.demo.dao.RobotInfoDao;
import com.asisinfo.datasource.demo.dao.base.impl.BaseDaoImpl;
import com.asisinfo.datasource.demo.domain.RobotInfo;
import org.springframework.stereotype.Repository;

@Repository("robotInfoDao")
public class RobotInfoDaoImpl extends BaseDaoImpl implements RobotInfoDao {

    public RobotInfoDaoImpl() {
        setNs("com.asisinfo.datasource.demo.mapper.RobotInfoMapper");
    }

    @Override
    public RobotInfo queryRobotInfoByRobotCode(String robotCode) {
        return getSqlSession().selectOne(getNs() + ".queryRobotInfoByRobotCode", robotCode);
    }

    @Override
    public int modifyRobotNameByRobotCode(RobotInfo robotInfo) {
        return getSqlSession().update(getNs() + ".updateRobotNameByRobotCode", robotInfo);
    }


}
