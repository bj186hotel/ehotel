
import com.bj186.ssm.mapper.UserMapper;
import com.bj186.ssm.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 郑金城
 * @title: Demo
 * @projectName spring_mybatis
 * @description: TODO
 * @date 2019/6/514:36
 */
public class Demo {

    private ApplicationContext context = null;
    @Before
   public void  init(){
        context = new ClassPathXmlApplicationContext("config/spring.xml");
    }
    @Test
    public void test1(){
        SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setCustomerName("郑金城");
        user.setCustomerPwd("12345");
        int insert = mapper.insert(user);
        System.out.println(user);
    }
}
