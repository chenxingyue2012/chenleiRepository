package com.asisinfo.datasource.demo.mapper;

import com.asisinfo.datasource.demo.domain.RobotInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 在MyBatisConfig配置类里使用了@MapperScan(value = "com.asisinfo.datasource.demo.mapper")
 * 所以将@Mapper给注释掉了
 */
//@Mapper
public interface RobotInfoMapper {

    public RobotInfo queryRobotInfoByRobotCode(String robotCode);

}
