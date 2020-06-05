create table seckill_commodity
(
    id          int auto_increment comment '商品ID'
        primary key,
    title       varchar(1000)                           null comment '商品标题',
    image       varchar(255)                            null comment '商品图片',
    price       decimal(10, 2)                          null comment '商品原价格',
    cost_price  decimal(10, 2)                          null comment '商品秒杀价格',
    stock_count int                                     null comment '剩余库存数量',
    start_time  timestamp default '2020-02-01 00:00:01' not null comment '秒杀开始时间',
    end_time    timestamp default '2025-02-01 00:00:01' not null comment '秒杀结束时间'
)
    comment '秒杀商品表';

INSERT INTO scott.seckill_commodity (id, title, image, price, cost_price, stock_count, start_time, end_time) VALUES (1, 'Apple/苹果 iPhone 6s Plus 国行原装苹果6sp 5.5寸全网通4G手机', 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i3/2249262840/O1CN011WqlHkrSuPEiHxd_!!2249262840.jpg_230x230.jpg', 2600.00, 1100.00, 493, '2020-06-01 16:30:00', '2020-06-17 16:30:00');
INSERT INTO scott.seckill_commodity (id, title, image, price, cost_price, stock_count, start_time, end_time) VALUES (2, 'ins新款连帽毛领棉袄宽松棉衣女冬外套学生棉服', 'https://gw.alicdn.com/bao/uploaded/i3/2007932029/TB1vdlyaVzqK1RjSZFzXXXjrpXa_!!0-item_pic.jpg_180x180xz.jpg', 200.00, 150.00, 10, '2020-06-06 16:30:00', '2020-10-17 16:30:00');
INSERT INTO scott.seckill_commodity (id, title, image, price, cost_price, stock_count, start_time, end_time) VALUES (3, '可爱超萌兔子毛绒玩具垂耳兔公仔布娃娃睡觉抱女孩玩偶大号女生 ', 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/3828650009/TB22CvKkeOSBuNjy0FdXXbDnVXa_!!3828650009.jpg_230x230.jpg', 160.00, 130.00, 20, '2018-10-06 16:30:00', '2018-10-17 16:30:00');