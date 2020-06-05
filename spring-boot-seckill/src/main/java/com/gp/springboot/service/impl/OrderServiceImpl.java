package com.gp.springboot.service.impl;

import com.gp.springboot.dao.CommodityDao;
import com.gp.springboot.dao.OrderDao;
import com.gp.springboot.dto.CommonResult;
import com.gp.springboot.entity.Commodity;
import com.gp.springboot.entity.Order;
import com.gp.springboot.service.CommodityService;
import com.gp.springboot.service.OrderService;
import com.gp.springboot.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Gp
 * @create 2020/6/3 14:00
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CommodityDao commodityDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Order> queryAllOrder() {
        List<Order> orders = orderDao.queryAllOrder();
        if (orders != null) {
            return orders;
        }
        return null;
    }

    @Override
    public Order queryOrderById(Integer id) {
        Order order = orderDao.queryOrderById(id);
        if (order != null) {
            return order;
        }
        return null;
    }


    /**
     * 执行秒杀, 地址验证, 检查库存, 锁定库存, 减库存, 增加订单
     *
     * @param id
     * @param md5 URL地址校验, 一个请求对应只有唯一的MD5值
     * @return
     */
    @Transactional(rollbackFor = DuplicateKeyException.class)
    @Override
    public CommonResult<Commodity> excuteSeckill(Integer id, String md5, Long phone) {
        CommonResult<Commodity> result = null;
        Commodity commodity;
        if (md5 == null || "".equals(md5) || !md5.equals(MD5Utils.getMD5ByCommodityById(id))) {
            return new CommonResult<>(false, "请不要使用脚本提交数据!");
        }
        Integer stockCount = commodityDao.queryStockCountById(id);
        if (stockCount < 0) {
            return new CommonResult<>(false, "库存不足, 秒杀失败!");
        }
        boolean success = commodityDao.updateCommodity(id);
        if (!success) {
            logger.info("商品秒杀失败!");
            return new CommonResult<>(false, "商品秒杀失败!");
        }
        commodity = commodityDao.queryCommodityById(id);
        Order order = new Order(commodity.getCostPrice(), phone, new Date(), (short) 1);
        order.setCommodity(commodity);
        boolean addSuccess = false;
        try {
            addSuccess = orderDao.addOrder(order);
            if (addSuccess) {
                return new CommonResult<>(true, "秒杀成功!");
            }
            return new CommonResult<>(false, "增加订单失败!");
        } catch (DuplicateKeyException e) {
            //如果增加订单信息出错, 直接抛出异常, 事务回滚
            throw e;
        }
    }
}
