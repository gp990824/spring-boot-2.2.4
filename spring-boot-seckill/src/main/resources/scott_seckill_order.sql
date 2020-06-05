create table seckill_order
(
    id           int(20) auto_increment comment '秒杀商品ID'
        primary key,
    money        decimal(10, 2)                      null comment '支付金额',
    user_phone   bigint                              null comment '用户手机号',
    create_time  timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    status       tinyint   default -1                not null comment '状态：-1无效 0成功 1已付款',
    commodity_id int                                 not null comment '秒杀的商品信息',
    constraint seckill_order_unique
        unique (user_phone, commodity_id),
    constraint seckill_order___fk__commodity
        foreign key (commodity_id) references seckill_commodity (id)
)
    comment '秒杀订单表';

INSERT INTO scott.seckill_order (id, money, user_phone, create_time, status, commodity_id) VALUES (1, 59.90, 134654524122, '2020-06-05 11:23:13', 1, 1);
INSERT INTO scott.seckill_order (id, money, user_phone, create_time, status, commodity_id) VALUES (2, 99.90, 13852363251, '2020-06-05 11:23:13', 0, 1);
INSERT INTO scott.seckill_order (id, money, user_phone, create_time, status, commodity_id) VALUES (3, 1100.00, 137676545241, '2020-06-05 11:25:31', 1, 1);
INSERT INTO scott.seckill_order (id, money, user_phone, create_time, status, commodity_id) VALUES (4, 1100.00, 13767654524, '2020-06-05 11:23:13', 1, 1);
INSERT INTO scott.seckill_order (id, money, user_phone, create_time, status, commodity_id) VALUES (5, 98.90, 13852362051, '2020-06-04 23:46:42', 0, 1);