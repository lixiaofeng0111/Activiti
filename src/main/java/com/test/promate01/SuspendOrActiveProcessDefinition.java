package com.test.promate01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * Title: SuspendOrActiveProcessDefinition.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月03日
 */
public class SuspendOrActiveProcessDefinition {
/**
 * Class description:全部流程实例的激活和挂起（全部全部全部全部）
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.获得ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        String key = "holiday01";
        //3，根据业务流程定义id查询业务流程定义信息
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(key)
                .list();
        //4.判断当前流程定义是否挂起，如果挂起则全部激活，如果未挂起则全部挂起
        for(ProcessDefinition processDefinition : processDefinitionList){
            boolean isSuspend = processDefinition.isSuspended();
            if(isSuspend){
                repositoryService.activateProcessDefinitionByKey(key, true, null);
                System.out.println("激活");
            }else{
                repositoryService.suspendProcessDefinitionByKey(key, true, null);
                System.out.println("挂起");
            }
        }
    }

}
