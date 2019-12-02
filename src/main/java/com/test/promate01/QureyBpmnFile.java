package com.test.promate01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

/**
 * Title: QureyBpmnFile.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月02日
 */
public class QureyBpmnFile {
/**
 * Class description:
 *      需求：
 *          1.从Activi的act_ge_bytearray 表中读取两个资源文件
 *          2.将两个资源文件保存到指定路径中
 *
 *       技术方案：
 *          1.第一种方式使用activiti的api来实现
 *          2.第二种方式：其实就是于艳丽层面，可以使用jdbc的对blob类型，clob类型数据的读取并保存
 *          3.第三种方式:IO流的转换，最好使用commons-io.jar包可以轻松解决IO操作
 *
 * 真实应用场景：用户想要查看这个请假流程具体有哪些步骤要走
 * @Author: lxf
 */
    public static void main(String[] args) throws IOException {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到repositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.得到查询器ProcessDefinitionQuery对象
        //4.设置查询条件
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday01")
                .orderByProcessDefinitionVersion()
                .desc().list();

        //5.执行查询操作，查询出想要的流程定义
        for(ProcessDefinition processDefinition : processDefinitionList){
            //6.通过流程定义信息，得到部署Id
            String departmentId = processDefinition.getDeploymentId();

            //7.通过repositoryService的方法，实现读取图片信息及bpmn文件信息（输入流）
            //关于getResourceAsStream的说明：第一个参数是流程部署的id，第二个参数与是获取的资源文件
            //getDiagramResourceName方法的说明：获取png图片资源的名称
            //getResourceName方法的说明：获取bpmn资源文件的名称

            //输入流
            InputStream isPng = repositoryService
                    .getResourceAsStream(departmentId,processDefinition.getDiagramResourceName());
            InputStream isBpmn = repositoryService
                    .getResourceAsStream(departmentId,processDefinition.getResourceName());

            //8.输入流，输出流的转化
            OutputStream osPng = new FileOutputStream("F:\\0---面试必备\\" + processDefinition.getDiagramResourceName());
            OutputStream osBpmn = new FileOutputStream("F:\\0---面试必备\\" + processDefinition.getResourceName());

            IOUtils.copy(isBpmn, osBpmn);
            IOUtils.copy(isPng, osPng);

            //9.关闭流（先关闭输出流，再关闭输入流）
            osBpmn.close();
            osPng.close();
            isBpmn.close();
            isPng.close();
        }


    }

}
