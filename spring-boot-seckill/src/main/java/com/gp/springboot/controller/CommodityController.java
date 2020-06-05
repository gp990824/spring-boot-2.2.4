package com.gp.springboot.controller;

import com.gp.springboot.entity.Commodity;
import com.gp.springboot.dto.CommonResult;
import com.gp.springboot.dto.ExposeURL;
import com.gp.springboot.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Gp
 * @create 2020/6/3 9:56
 */

/**
 * 商品控制层, 应该包含这些功能  使用 RESTful 风格
 * 1. 查出所有秒杀商品  GET : /commodity/list
 * 2. 查看商品详情页    GET : /commodity/{id}
 * 3. 得到该商品秒杀地址  POST :  /commodity/seckill-url/{id}
 */
@Controller
public class CommodityController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/commodity/{id}")
    public String queryCommodityById(@PathVariable("id") Integer id) {
        if (id == null) {
            logger.info("错误, 请重试!");
            return "redirect:/commodity/list";
        }
        Commodity commodity = commodityService.queryCommodityById(id);
        if (commodity == null) {
            logger.info("商品不存在!");
            return "redirect:/commodity/list";
        }
        return "simgle-commodity";
    }

    /**
     * 查看所有的秒杀商品, 该页面应当先登录才能查看
     *
     * @return
     */
    @GetMapping("/commodity/list")
    public String commodityList(Model model) {
        List<Commodity> commodities = commodityService.queryAllCommodity();
        if (commodities == null) {
            model.addAttribute("message", "无法查看所有秒杀商品!");
            return "error";
        }
        model.addAttribute("commodities", commodities);
        return "commodity-list";
    }

    /**
     * 得到商品的详细信息, 前提是时间正确
     *
     * @param id
     * @return
     */
    @GetMapping("/commodity/seckill-url/{id}")
    public String getCommodityDetails(@PathVariable("id") Integer id, Model model) {
        Commodity commodity = commodityService.queryCommodityById(id);
        if (commodity == null) {
            model.addAttribute("message", "无法根据ID找出商品! 请联系管理员");
            return "error";
        }
        try {
            ExposeURL exposeURL = commodityService.getURLWithCommodityId(id);
            if (exposeURL != null) {
                //如果成功, 则来到详情页
                if (exposeURL.isSuccess()) {
                    model.addAttribute("url", exposeURL);
                    return "commodity-detail";
                } else {
                    model.addAttribute("message", exposeURL.getMessage());
                    return "error";
                }
            } else {
                model.addAttribute("message", "系统错误, 请重试!");
                return "error";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }
}
