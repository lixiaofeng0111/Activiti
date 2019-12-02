package com.test.promate01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * Title: DeleteProcessDefinition.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月02日
 */
public class DeleteProcessDefinition {
/**
 * Class description:删除流程定义信息
 * Action（删除时的注意事项）：
 *          1.当我们正在执行的一套流程没有完全审批结束的时候，此时如果要删除流程定义信息就会失败
 *          2.如果公司层面要强制删除，可以使用repsitoryService.deleteDeployment("1",true);
 *              //参数true代表级联删除，此时就会先删除没有完成的流程节点，最后就可以删除流程定义信息，不加true或者是加false表示不级联删除
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
        //4.根据流程部署Id删除未完成的业务流程信息（actinst）
        for(ProcessDefinition processDefinition : processDefinitionList){
            //5.根据查询出来的流程定义的部署id删除流程定义信息（注意，如果当前流程尚未结束，则需要在后面加上true）
            repositoryService.deleteDeployment(processDefinition.getDeploymentId(),true);
        }
    }
}
