package cn.itcast.test;

import cn.itcast.dao.IAccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xhb
 * @create 2020-05-08-14:02
 */
public class testMybatis {

    @Test
    public void fun1() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IAccountDao iAccountDao = sqlSession.getMapper(IAccountDao.class);


        List<Account> accounts = iAccountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
//        Account account=new Account();
//        account.setName("李寻欢");
//        account.setMoney(4000);
//
//        iAccountDao.saveAccount(account);

        sqlSession.commit();

        sqlSession.close();
        in.close();

    }

}
