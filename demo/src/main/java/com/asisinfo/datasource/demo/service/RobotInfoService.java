package com.asisinfo.datasource.demo.service;

import com.asisinfo.datasource.demo.dao.RobotInfoDao;
import com.asisinfo.datasource.demo.domain.RobotInfo;
import com.asisinfo.datasource.demo.mapper.RobotInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RobotInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RobotInfoMapper robotInfoMapper;

    @Autowired
    private RobotInfoDao robotInfoDao;

    @Cacheable(value = "tmp", key="#robotCode")
    public RobotInfo getRobotInfo(String robotCode) {
        String sql = "select robot_code, robot_name, robot_age, create_date, status, remark from robot_info where robot_code = ?";
        RowMapper<RobotInfo> rowMapper = (rs, rowNum) ->
            new RobotInfo(rs.getString("robot_code"),
                    rs.getString("robot_name"),
                    rs.getInt("robot_age"),
                    rs.getDate("create_date"),
                    rs.getString("status"),
                    rs.getString("remark"));
        RobotInfo robotInfo = jdbcTemplate.queryForObject(sql, rowMapper, robotCode);
        return  robotInfo;
    }

    public RobotInfo getRobotInfoEx(String robotCode) {
        return robotInfoMapper.queryRobotInfoByRobotCode(robotCode);
    }

    public RobotInfo getRobotInfoExx(String robotCode) {
        return robotInfoDao.queryRobotInfoByRobotCode(robotCode);
    }

    @Transactional(rollbackFor = Exception.class)
    public int modifyRobotName(String robotCode, String robotName) {
        RobotInfo robotInfo = new RobotInfo();
        robotInfo.setRobotCode(robotCode);
        robotInfo.setRobotName(robotName);
        robotInfoDao.modifyRobotNameByRobotCode(robotInfo);
        int i = 10/0;
        return i;
    }

    @CachePut(value = "tmp", key = "#robotCode")
    public RobotInfo modifyRobotNameEx(String robotCode, String robotName) {
        RobotInfo robotInfo = new RobotInfo();
        robotInfo.setRobotCode(robotCode);
        robotInfo.setRobotName(robotName);
        robotInfoDao.modifyRobotNameByRobotCode(robotInfo);
        return robotInfo;
    }

}
