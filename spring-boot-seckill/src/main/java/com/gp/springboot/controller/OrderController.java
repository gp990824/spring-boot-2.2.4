package com.gp.springboot.controller;

import com.gp.springboot.dto.CommonResult;
import com.gp.springboot.entity.Commodity;
import com.gp.springboot.entity.Order;
import com.gp.springboot.entity.User;
import com.gp.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gp
 * @create 2020/6/3 18:12
 */

/**
 * 订单控制层 , 应当满足以下功能
 * 1. 查看所有订单(应当需要进行权限验证)  GET /order/list
 * 2. 查看单个订单信息   GET  /order/{id}
 * 3. 执行秒杀  POST  /order/excute/{id}/{md5}
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/{id}")
    public String singleOrder(@PathVariable("id") Integer id, Model model) {
        if (id == null) {
            model.addAttribute("message", "订单号有问题!");
            return "error";
        }
        Order order = orderService.queryOrderById(id);
        if (order == null) {
            model.addAttribute("message", "没有该编号的订单, 请重试!");
            return "error";
        } else {
            return "order-detail";
        }
    }

    /**
     * 执行秒杀 , 检查库存, 锁定库存, 减库存, 插入订单记录
     *
     * @param id
     * @param md5
     * @return
     */
    @PostMapping("/order/excute/{id}/{md5}")
    public String excuteSeckill(@PathVariable("id") Integer id, @PathVariable("md5") String md5,
                                HttpServletRequest request) {
        if (id == null || md5 == null || "".equals(md5)) {
            request.setAttribute("message", "错误的提交请求");
            return "error";
        }
        User user = (User) request.getSession().getAttribute("user");
        CommonResult<Commodity> result = orderService.excuteSeckill(id, md5, user.getPhone());
        if (result.isSuccess()) {
            return "success";
        } else {
            request.setAttribute("message", result.getMessage());
            return "error";
        }
    }

}
