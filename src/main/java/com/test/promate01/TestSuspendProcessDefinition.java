package com.test.promate01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * Title: TestSuspendProcessDefinition.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月03日
 */
public class TestSuspendProcessDefinition {
/**
 * Class description:测试单个流程实例挂起是是否还能执行任务
 * 描述：当实例已经处于挂起状态时，如果此时让该实例继续执行，问题是：是否可以成功？
 *      如果不能执行，是否会抛出异常？ActivitiException：cannot complete  a suspended task
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

        //3.根据key查询相关流程实例
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday01")
                .taskAssignee("wangwu")
                .list();

        //4.完成任务
        for (Task task : taskList){
            taskService.complete(task.getId());
        }
    }
}
