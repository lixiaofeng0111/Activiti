package com.test.base;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * Title: HolidayProcessTest.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年11月30日
 */
public class HolidayProcessTest {
/**
 * Class description:流程定义部署(部署流程)
 * Activiti和项目的整合：
 *  1.整合Activiti
 *  2.实现业务流程
 *  3.部署业务流程到Activiti
 *  4.启动业务流程实例
 *  5.查询待办业务
 *  6.处理待办业务
 *  7.结束流程
 * @Author: lxf
 */
    public static void main(String[] args) {
//        //1.创建ProgessEngineConfiguration对象
//        ProcessEngineConfiguration configuration =
//                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//        //2.创建ProgessEngine对象
//        ProcessEngine processEngine = configuration.buildProcessEngine();
//
//        //3.输出processEngine对象检验是否正确
//        System.out.println(processEngine);

        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到RepositoryService实例部署相关信息
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.进行部署
        Deployment deploy = repositoryService.createDeployment()   // 创建deployment对象
                .addClasspathResource("diagram/holiday01.bpmn") // 添加bpmn资源
                .addClasspathResource("diagram/holiday01.png")   //添加png资源
                .name("请假流程部署")
                .category("请假")
                .deploy();//真正的部署相关信息

        System.out.println("***Id***"+deploy.getId());
        System.out.println("***name***"+deploy.getName());



    }
}
