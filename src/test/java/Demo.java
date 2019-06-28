
import com.bj186.ssm.mapper.OrderMapper;
import com.bj186.ssm.pojo.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        Map<String, String> map = new HashMap<>();
        //map.put("menNum","18482117000");
        map.put("roomNum","1-101");
        List<Order> orders1 = mapper.selectAllByCondition(map);
        System.out.println(orders1.get(0));
        //List<Order> orders = mapper.selectAll();
        //System.out.println(orders.get(0));
    }
}
