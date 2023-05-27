

CREATE TABLE `customers`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `username`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `nickname`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
    `phone`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `email`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `avatar_url`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
    `roles`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '角色',
    `is_valid`    tinyint(1) NULL DEFAULT NULL,
    `create_date` datetime(0) NULL DEFAULT NULL,
    `update_date` datetime(0) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

INSERT INTO `customers` VALUES (1, 'abc', '昵称st', '13888888888', 'abc@imooc.com', 'e10adc3949ba59abbe56e057f20f883e', '/abc', 'ROLE_USER', 1, '2020-11-06 16:17:52', '2020-11-06 16:17:55');
INSERT INTO `customers` VALUES (2, 'test', 'test', '13666666666', NULL, 'e10adc3949ba59abbe56e057f20f883e', '/test', 'ROLE_USER', 1, '2020-11-12 12:01:13', '2020-11-12 12:01:13');
INSERT INTO `customers` VALUES (3, 'test2', 'test2', '13666666667', NULL, 'e10adc3949ba59abbe56e057f20f883e', '/test2', 'ROLE_USER', 1, '2020-11-12 17:47:12', '2020-11-12 17:47:12');
INSERT INTO `customers` VALUES (5, 'aaa', 'aaa', '12311112222', NULL, 'e10adc3949ba59abbe56e057f20f883e', '/aaa', 'ROLE_USER', 1, '2020-11-13 12:29:49', '2020-11-13 12:29:49');



-- 创建 coupon_template 数据表
CREATE TABLE IF NOT EXISTS `coupon_template` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `expired` boolean NOT NULL DEFAULT false COMMENT '是否过期; true: 是, false: 否',
    `name` varchar(64) NOT NULL DEFAULT '' COMMENT '优惠券名称',
    `category` varchar(64) NOT NULL DEFAULT '' COMMENT '优惠券分类',
    `coupon_count` int(11) NOT NULL DEFAULT '0' COMMENT '总数',
    `template_key` varchar(128) NOT NULL DEFAULT '' COMMENT '优惠券模板的编码',
    `is_valid`    tinyint(1) NULL DEFAULT NULL,
    `create_date` datetime(0) NULL DEFAULT NULL,
    `update_date` datetime(0) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_category` (`category`),
    UNIQUE KEY `name` (`name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='优惠券模板表';



DROP TABLE IF EXISTS `user_coupons`;
CREATE TABLE `user_coupons`
(
    `id`           int(10) NOT NULL AUTO_INCREMENT,
    `user_id`      int(10) DEFAULT NULL COMMENT '用户 ID',
    `coupon_id`    int(10) DEFAULT NULL COMMENT '优惠券 ID',
    `token`        varchar(36) DEFAULT NULL COMMENT 'Token 值',
    `assign_date`  datetime    DEFAULT NULL COMMENT '领取日期',
    `consume_date` datetime    DEFAULT NULL COMMENT '消费日期',
    PRIMARY KEY (`id`),
    KEY            `user_id_index` (`user_id`) USING BTREE COMMENT '用户 ID 索引'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of coupon_template
-- ----------------------------
INSERT INTO `coupon_template` VALUES (10, 1, 0, '优惠券模板-1603809231926', 'http://www.baidu.com', '这是一张优惠券模板', '001', 1, 10000, '2020-10-27 14:33:52', 10001, '100120201027', 1, '{\"discount\":{\"base\":1,\"quota\":5},\"expiration\":{\"deadline\":1608993231927,\"gap\":1,\"period\":1},\"limitation\":1,\"usage\":{\"city\":\"桐城市\",\"goodsType\":\"[\\\"文娱\\\",\\\"家居\\\"]\",\"province\":\"安徽省\"},\"weight\":\"[]\"}');

-- 创建 coupon 数据表

CREATE TABLE IF NOT EXISTS `coupon` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `template_id` int(11) NOT NULL DEFAULT '0' COMMENT '关联优惠券模板的主键',
    `customer_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '领取用户',
    `coupon_code` varchar(64) NOT NULL DEFAULT '' COMMENT '优惠券码',
    `assign_time` datetime NOT NULL DEFAULT '0000-01-01 00:00:00' COMMENT '领取时间',
    `status` int(11) NOT NULL DEFAULT '0' COMMENT '优惠券的状态',
    `is_valid`  int(11) NULL DEFAULT NULL ,
    `create_date`  datetime NULL DEFAULT NULL ,
    `update_date`  datetime NULL DEFAULT NULL ,
    PRIMARY KEY (`id`),
    KEY `idx_template_id` (`template_id`),
    KEY `idx_customer_id` (`customer_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='优惠券(用户领取的记录)';


CREATE TABLE `vouchers` (
                            `id`  int(10) NOT NULL AUTO_INCREMENT ,
                            `title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代金券标题' ,
                            `amount`  int(11) NULL DEFAULT NULL COMMENT '抵扣金额' ,
                            `price`  decimal(10,2) NULL DEFAULT NULL COMMENT '售价' ,
                            `status`  int(10) NULL DEFAULT NULL COMMENT '-1=过期 0=下架 1=上架' ,
                            `start_use_time`  datetime NULL DEFAULT NULL COMMENT '开始使用时间' ,
                            `expire_time`  datetime NULL DEFAULT NULL COMMENT '过期时间' ,
                            `create_date`  datetime NULL DEFAULT NULL ,
                            `update_date`  datetime NULL DEFAULT NULL ,
                            `is_valid`  tinyint(1) NULL DEFAULT NULL ,
                            PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1 ROW_FORMAT=COMPACT;


CREATE TABLE `seckill_vouchers` (
                                    `id`  int(11) NOT NULL AUTO_INCREMENT ,
                                    `voucher_id`  int(11) NULL DEFAULT NULL ,
                                    `amount`  int(11) NULL DEFAULT NULL ,
                                    `start_time`  datetime NULL DEFAULT NULL ,
                                    `end_time`  datetime NULL DEFAULT NULL ,
                                    `is_valid`  int(11) NULL DEFAULT NULL ,
                                    `create_date`  datetime NULL DEFAULT NULL ,
                                    `update_date`  datetime NULL DEFAULT NULL ,
                                    PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;


CREATE TABLE `voucher_orders` (
                                  `id`  int(11) NOT NULL AUTO_INCREMENT ,
                                  `order_no`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
                                  `voucher_id`  int(11) NULL DEFAULT NULL ,
                                  `custmer_id`  int(11) NULL DEFAULT NULL ,
                                  `status`  tinyint(1) NULL DEFAULT NULL COMMENT '订单状态：-1=已取消 0=未支付 1=已支付 2=已消费 3=已过期' ,
                                  `seckill_id`  int(11) NULL DEFAULT NULL COMMENT '如果是抢购订单时，抢购订单的id' ,
                                  `create_date`  datetime NULL DEFAULT NULL ,
                                  `update_date`  datetime NULL DEFAULT NULL ,
                                  `is_valid`  int(11) NULL DEFAULT NULL ,
                                  PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
    DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
    AUTO_INCREMENT=1
    ROW_FORMAT=COMPACT
;