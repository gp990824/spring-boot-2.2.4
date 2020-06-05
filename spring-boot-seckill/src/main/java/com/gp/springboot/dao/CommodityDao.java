package com.gp.springboot.dao;

/**
 * @author Gp
 * @create 2020/6/3 9:46
 */

import com.gp.springboot.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 秒杀商品DAO层
 */
@Mapper
public interface CommodityDao {
    /**
     * 查询出所有的秒杀商品
     * @return
     */
    List<Commodity> queryAllCommodity();

    /**
     * 根据商品id, 查询其库存
     * @param id
     * @return
     */
    Integer queryStockCountById(Integer id);

    /**
     * 根据 id 查询商品
     * @param id
     * @return
     */
    Commodity queryCommodityById(Integer id);

    /**
     * 减库存, 在此操作前应当查询出 库存数应当 > 0
     * @param commodityId
     * @return
     */
    boolean updateCommodity(Integer commodityId);
}
