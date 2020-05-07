package com.asisinfo.datasource.demo.controller;

import com.asisinfo.datasource.demo.domain.InitParam;
import com.asisinfo.datasource.demo.domain.ResponseResult;
import com.asisinfo.datasource.demo.service.RobotInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotInfoController {

    @Autowired
    private RobotInfoService robotInfoService;

    @RequestMapping(value = "/getRobotInfo/v1/{robotCode}")
    public ResponseResult queryRobotInfo(@PathVariable String robotCode) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        try {
            Object obj = robotInfoService.getRobotInfo(robotCode);
            responseResult.setResult(obj);
        } catch (Exception e) {
            responseResult.setSuccess(false);
            responseResult.setMsg(e.getMessage());
        }
        return  responseResult;
    }

    @RequestMapping(value = "/getRobotInfo/v2/{robotCode}")
    public ResponseResult queryRobotInfoEx(@PathVariable String robotCode) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        try {
            Object obj = robotInfoService.getRobotInfoEx(robotCode);
            responseResult.setResult(obj);
        } catch (Exception e) {
            responseResult.setSuccess(false);
            responseResult.setMsg(e.getMessage());
        }
        return  responseResult;
    }

    @RequestMapping(value = "/getRobotInfo/v3/{robotCode}")
    public ResponseResult queryRobotInfoExx(@PathVariable String robotCode) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        try {
            Object obj = robotInfoService.getRobotInfoExx(robotCode);
            responseResult.setResult(obj);
        } catch (Exception e) {
            responseResult.setSuccess(false);
            responseResult.setMsg(e.getMessage());
        }
        return  responseResult;
    }

    @RequestMapping(value = "/modifyRobotInfo/v1/{robotCode}/{robotName}", method = RequestMethod.GET)
    public ResponseResult modifyRobotInfo(@PathVariable String robotCode, @PathVariable String robotName) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        try {
            Object obj = robotInfoService.modifyRobotName(robotCode, robotName);
            responseResult.setResult(obj);
        } catch (Exception e) {
            responseResult.setSuccess(false);
            responseResult.setMsg(e.getMessage());
        }
        return  responseResult;
    }

    @RequestMapping(value = "/modifyRobotInfo/v2/{robotCode}/{robotName}", method = RequestMethod.GET)
    public ResponseResult modifyRobotInfoEx(@PathVariable String robotCode, @PathVariable String robotName) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        try {
            Object obj = robotInfoService.modifyRobotNameEx(robotCode, robotName);
            responseResult.setResult(obj);
        } catch (Exception e) {
            responseResult.setSuccess(false);
            responseResult.setMsg(e.getMessage());
        }
        return  responseResult;
    }

    @RequestMapping(value = "/modifyRobotInfo/v3")
    public ResponseResult modifyRobotInfoExx(InitParam initParam) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        try {
            Object obj = robotInfoService.modifyRobotNameEx((String)initParam.getValue("robotCode"), (String)initParam.getValue("robotName"));
            responseResult.setResult(obj);
        } catch (Exception e) {
            responseResult.setSuccess(false);
            responseResult.setMsg(e.getMessage());
        }
        return responseResult;
    }
}
