package com.test.base;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * Title: HolidayZipDeployment.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年12月02日
 */
public class HolidayZipDeployment {
/**
 * Class description:使用zip文件进行部署
 * @Author: lxf
 */

    public static void main(String[] args) {
        //1.获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.对资源文件进行解压
        InputStream inputStream = HolidayProcessTest.class.getClassLoader().getResourceAsStream("diagram/holiday.zip");

        //4.将输入流转换为压缩流

        ZipInputStream zipInputStream = new ZipInputStream(inputStream);


        //3.进行部署
        repositoryService.createDeployment()
                        .addZipInputStream(zipInputStream)
                        .name("请假流程")
                        .deploy();

    }
}
