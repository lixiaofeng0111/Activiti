package com.test.promate02.processVariable;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: VariableTest.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月11日
 */
public class VariableTest {
/**
 * Class description:流程变量的测试
 * @Author: lxf
 */
    public static void main(String[] args) {
        //新的流程定义的部署
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiady03.bpmn")
                .addClasspathResource("diagram/holiady03.png")
                .name("请假申请03")
                .category("请假申请--流程变量")
                .deploy();
    }

    @Test
    public void startProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.启动流程定义并定义流程变量
        Holiday holiday = new Holiday();
        holiday.setNum(1F);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("holiday", holiday);
        map.put("assignee0", "zhangsan03");
        map.put("assignee1", "lisi03");
        map.put("assignee2", "wangwu03");
        map.put("assignee3", "maliu03");

        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday03",map);

    }

    //查询任务流程节点信息
    @Test
    public void taskQuery(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .taskAssignee("lisi03")
                .singleResult();
        System.out.println("查询任务："+task);
        taskService.complete(task.getId());
    }


    //设置完成当前查询的任务
    @Test
    public void completeTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .taskAssignee("lisi03")
                .singleResult();

        //完成当前查询到的任务
        taskService.complete(task.getId());
    }

    @Test
    public void deleteDepartment(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //删除流程部署定义
        repositoryService.deleteDeployment("30001",true);
        //删除流程实例
        runtimeService.deleteProcessInstance("32501","重复添加的流程开始实例");

    }


}
