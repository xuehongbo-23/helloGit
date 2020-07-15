package cn.itcast.test;

import cn.itcast.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xhb
 * @create 2020-05-08-12:26
 */
public class testSpring {

    @Test
    public void fun1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = applicationContext.getBean("accountServiceImpl", IAccountService.class);
        accountService.findAll();
    }

}
