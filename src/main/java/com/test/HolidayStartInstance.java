package com.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * Title: HolidayStartInstance.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月01日
 */
public class HolidayStartInstance {
/**
 * Class description:启动流程实例
 * @Author: lxf
 */
    public static void main(String[] args) {
        //启动流程实例的步骤
        //1.获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunTimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.创建流程实例（根据流程定义的唯一值key启动）
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday01");

        //输出相关信息
        System.out.println("业务流程的key"+processInstance.getBusinessKey());
        System.out.println("当前创建的实例的id"+processInstance.getId());
        System.out.println("当前创建实例部署的流程业务的id"+processInstance.getDeploymentId());
        System.out.println("启动流程实例的名称"+processInstance.getName());
        System.out.println("整个activiti的id"+processInstance.getActivityId());
        System.out.println("过程定义的的id"+processInstance.getProcessDefinitionId());
    }
}
