package com.test.promate02.uel;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * Title: HolidayDeployment.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月09日
 */
public class HolidayDeployment {
/**
 * Class description:请假申请流程部署
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.创建processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建repositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.部署请假流程
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday02.bpmn")
                .addClasspathResource("diagram/holiday02.png")
                .name("请假部署流程02")
                .category("请假02")
                .deploy();

    }

}
