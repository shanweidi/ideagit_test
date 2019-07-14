package cn.xiaoshan.test;

import cn.xiaoshan.dao.RoleDao;
import cn.xiaoshan.dao.UserDao;
import cn.xiaoshan.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// 查询所有角色,同时显示有该角色的用户信息
public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;
    @Before
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("----每个角色的所有信息----");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
