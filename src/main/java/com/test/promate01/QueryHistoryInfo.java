package com.test.promate01;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;

import java.util.List;

/**
 * Title: QueryHistoryInfo.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月03日
 */
public class QueryHistoryInfo {
/**
 * Class description:查询业务流程历史信息（act_hi_actinst）
 * @Author: lxf
 */
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取HistoryService对象
        HistoryService historyService = processEngine.getHistoryService();

        //3.根据条件查询信息(流程定义的id)
        List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId("10001").list();

        for(HistoricActivityInstance historicActivityInstance : historicActivityInstanceList){
            System.out.println("活动节点ID"+historicActivityInstance.getId());
            System.out.println("活动节点名称"+historicActivityInstance.getActivityName());
            System.out.println("活动节点执行人"+historicActivityInstance.getAssignee());
        }


    }
}
