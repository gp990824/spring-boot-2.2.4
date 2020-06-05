package com.gp.springboot.service.impl;

import com.gp.springboot.dao.CommodityDao;
import com.gp.springboot.entity.Commodity;
import com.gp.springboot.dto.ExposeURL;
import com.gp.springboot.service.CommodityService;
import com.gp.springboot.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Gp
 * @create 2020/6/3 15:00
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public List<Commodity> queryAllCommodity() {
        return commodityDao.queryAllCommodity();
    }

    @Override
    public Commodity queryCommodityById(Integer id) {
        return commodityDao.queryCommodityById(id);
    }

    @Override
    public ExposeURL getURLWithCommodityId(Integer id) {
        Commodity commodity = queryCommodityById(id);
        ExposeURL exposeURL = new ExposeURL();

        //如果找不到商品, 则秒杀失败
        if (commodity == null) {
            exposeURL.setSuccess(false);
            exposeURL.setMessage("找不到商品, 请重试!");
            return exposeURL;
        }
        exposeURL.setSuccess(true);
        exposeURL.setMd5(MD5Utils.getMD5ByCommodityById(id));
        exposeURL.setCommodity(commodity);
        exposeURL.setCurrentTime(new Date());
        return exposeURL;
    }
}
