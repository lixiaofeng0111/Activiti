package com.test.promate01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * Title: AddBusinessKey.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月03日
 */
public class AddBusinessKey {
/**
 * Class description:需要在启动业务流程节点的时候添加请假单BusinessKey
 * 本质：根据act_ru_exception的businessKey字段存入业务标识
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        
        //2.获取RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3.启动业务流程实例节点，同时还要指定业务标识businessKey（他本身就是业务详情的id）
        //第一个参数指的是业务流程的key
        //第二个参数指的是业务标识businessKey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday01", "20004");

        //4.输出业务流程实例的businessKey
        System.out.println("获取流程实例的businesskey"+processInstance.getBusinessKey());
        
    }
}
