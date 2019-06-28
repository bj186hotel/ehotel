
import com.bj186.ssm.mapper.*;
import com.bj186.ssm.pojo.*;
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
       // RoomMapper mapper1 = sqlSession.getMapper(RoomMapper.class);
        Order order = new Order();
        Map<String,String> map = new HashMap<>();
        map.put("roomNum","1-101");
        List<Order> orders1 = mapper.selectAllByCondition(map);
        System.out.println(orders1.get(0));
        /*map.put("menNum","18482117000");
        map.put("roomNum","1-101");
        List<Order> orders1 = mapper.selectAllByCondition(map);
        System.out.println(orders1.get(0));*/
        //List<Order> orders = mapper.selectAll();
        //System.out.println(orders.get(0));
        //Room room = mapper1.selectByPrimaryKey(1001);
        //System.out.println(room);
    }
    @Test
    public void test12(){
        SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Member member = mapper.selectByMenNum("18482117000");
        System.out.println(member);

    }

    @Test
    public void test3(){
        SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EnterOrderMapper mapper = sqlSession.getMapper(EnterOrderMapper.class);
       /* List<EnterOrder> enterOrders = mapper.selectAll();
        System.out.println(enterOrders);*/
        Map<String,String> map = new HashMap<>();
        map.put("usersId","1001");
        map.put("status","1");
        map.put("usersId","1001");
        map.put("status","2");
       // List<EnterOrder> enterOrders = mapper.selectAllByCondition(map);
        //System.out.println(enterOrders);
        mapper.insertSelective(map);

    }
}
