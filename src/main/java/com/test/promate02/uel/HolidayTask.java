package com.test.promate02.uel;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * Title: HolidayTaskQuery.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月09日
 */
public class HolidayTask {
/**
 * Class description:请假流程任务查询和处理
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.创建processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建taskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.根据key查询任务并完成任务
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday02")
                .taskAssignee("wangwu02")
                .list();
        for(Task task : taskList){
            //4.完成zhangsan02的任务
            taskService.complete(task.getId());
        }
    }

}
