package com.test.base;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

/**
 * Title: HolidayCompleteTask.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月02日
 */
public class HolidayCompleteTask {
/**
 * Class description:
 * @Author: lxf
 */
public static void main(String[] args) {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    TaskService taskService = processEngine.getTaskService();
    //5.根据目前执行的任务的id结束任务
    taskService.complete("7502");
}

}
