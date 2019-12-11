package com.test.promate02.uel;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: HolidayStart.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月09日
 */
public class HolidayStart {
/**
 * Class description:启动请假流程实例
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.创建processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建runtimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3.设置assign的分配人，用户可以在页面上设置流程的执行人
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("assign01", "zhangsan02");
        map.put("assign02", "lisi02");
        map.put("assign03", "wangwu02");

        //4.启动流程实例,同时还要设置流程定义的assing的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday02",map);

    }

}
