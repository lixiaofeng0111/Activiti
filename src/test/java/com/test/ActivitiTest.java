package com.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * Title: ActivitiTest.java
 * File description:
 *
 * @copyright: 2019
 * @company: tb
 * @Author: lxf
 * @version: 1.0
 * @date 2019年11月28日
 */
public class ActivitiTest {
/**
 * Class description:测试类
 * @Author: lxf
 */

    //测试类：测试Activiti所需要的25张表的生成
    @Test
    public void test01(){
        //1.创建ProgessEngineConfiguration对象
        ProcessEngineConfiguration configuration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //2.创建ProgessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();

        //3.输出processEngine对象检验是否正确
        System.out.println(processEngine);
    }

}
