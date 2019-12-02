package com.test.promate01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * Title: QueryProcessDefine.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月02日
 */
public class QueryProcessDefinition {
/**
 * Class description:Activiti进阶1，查询流程定义相关信息
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.查询流程定义信息
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday01")
                .orderByProcessDefinitionVersion()
                .desc().list();

        //4.输出查询出来的李路成定义信息
        for(ProcessDefinition processDefinition : processDefinitionList){
            System.out.println("流程定义的Id:"+processDefinition.getId());
            System.out.println("流程定义的Name:"+processDefinition.getName());
            System.out.println("流程定义的Version:"+processDefinition.getVersion());
            System.out.println("流程定义的部署Id:"+processDefinition.getDeploymentId());
            System.out.println("-----------------------------------------");

        }
    }
}
