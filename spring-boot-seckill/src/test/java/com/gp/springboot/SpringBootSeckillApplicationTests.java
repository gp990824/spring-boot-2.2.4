package com.gp.springboot;

import com.gp.springboot.dao.CommodityDao;
import com.gp.springboot.dao.OrderDao;
import com.gp.springboot.entity.Commodity;
import com.gp.springboot.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSeckillApplicationTests {
    @Autowired
    OrderDao orderDao;

    @Autowired
    CommodityDao commodityDao;

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
//        System.out.println(dataSource.getConnection());
//        System.out.println(commodityDao.queryAllCommodity());
//        System.out.println(commodityDao.queryCommodityById(2));
//        System.out.println(commodityDao.updateCommodity(1));
//        System.out.println(commodityDao.queryStockCountById(1));
//        System.out.println(orderDao.queryAllOrder());
        Order order = new Order(98.9f, 13852362051L, new Date(), (short) 0);
        Commodity commodity = new Commodity();
        commodity.setId(1);
        order.setCommodity(commodity);
        System.out.println(orderDao.addOrder(order));
//        System.out.println(commodityDao.queryStockCountById(1L));

    }

}
