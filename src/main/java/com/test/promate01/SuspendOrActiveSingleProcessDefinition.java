package com.test.promate01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * Title: SuspendOrActiveSingleProcessDefinition.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月03日
 */
public class SuspendOrActiveSingleProcessDefinition {
/**
 * Class description:单个单个单个单个流程实例的挂起和激活
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取RepositoryService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3.查询需要判断的实例是否挂起
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("2501").singleResult();

        boolean suspended =   processInstance.isSuspended();
        if(suspended){
            runtimeService.activateProcessInstanceById("2501");
            System.out.println("激活");
        }else{
            runtimeService.suspendProcessInstanceById("2501");
            System.out.println("挂起");
        }


    }
}
