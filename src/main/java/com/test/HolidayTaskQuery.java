package com.test;

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
 * @date 2019年12月02日
 */
public class HolidayTaskQuery {
/**
 * Class description:查询待办任务
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取TaskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.查询待办任务(根据业务流程定义的key和业务分配人)
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday01")
                .taskAssignee("zhangsan")
                .list();
        //4.输出待办任务信息
        for(Task list : taskList){
            System.out.println("查询任务的id:"+list.getId());
            System.out.println("查询任务的name:"+list.getName());
            System.out.println("查询任务的执行人员:"+list.getAssignee());
            System.out.println("查询任务流程id:"+list.getProcessDefinitionId());

            //5.根据目前执行的任务的id结束任务
            taskService.complete(list.getId());
            System.out.println("结束完之后上个任务之后的现在的任务"+list.getName());
        }
    }

}
