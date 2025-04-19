/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 90200 (9.2.0)
 Source Host           : localhost:3306
 Source Schema         : BookManager

 Target Server Type    : MySQL
 Target Server Version : 90200 (9.2.0)
 File Encoding         : 65001

 Date: 19/04/2025 15:38:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK17io542rmnlpvhcc041w5790h` (`student_id`),
  CONSTRAINT `FKr46tvf8h6nnw1c93s9bxiv1t` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` (`id`, `password`, `username`, `role`, `email`, `student_id`) VALUES (1, '$2a$10$spw5n.I8vi08ZgbmZQQpAepVBsK9iGzzYnMMIMDehw.jpZt8HP3.S', 'admin', 'admin', 'test@gmail.com', 1);
INSERT INTO `account` (`id`, `password`, `username`, `role`, `email`, `student_id`) VALUES (6, '$2a$10$Jym3jRU5cvE36AjjnLa9e.wC9XE1IWkBOUbMb6hSLO0tB0qou1B3e', 'user', 'user', '1904474691@qq.com', 6);
COMMIT;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of books
-- ----------------------------
BEGIN;
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (1, '讲述伞兵如何在逆风局拿下29杀上央视', 99, 'allowed', '伞兵一号');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (2, '讲述农民玩斗地主被17张牌秒杀的故事', 88, 'borrowed', '17张牌你能秒我');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (3, '讲述卢本伟传奇的一生', 50, 'allowed', '卢本伟自传');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (4, '余华的经典作品，讲述了一个普通农民家庭的悲欢离合。', 39.5, 'allowed', '活着');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (5, '路遥的小说，描写了中国农民在改革开放中的奋斗与挣扎。', 45, 'allowed', '平凡的世界');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (6, '加西亚·马尔克斯的魔幻现实主义小说，描写了布恩蒂亚家族的百年兴衰。', 59.8, 'borrowed', '百年孤独');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (7, '清代作家曹雪芹的经典之作，描写了贾、王、史、薛四大家族的兴衰。', 89, 'allowed', '红楼梦');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (8, '中国古代四大名著之一，讲述了唐僧师徒四人取经的故事。', 34.8, 'allowed', '西游记');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (9, '辛夷坞的小说，讲述了一个关于成长与爱情的故事。', 40, 'allowed', '我在未来等你');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (10, '刘慈欣的科幻小说，讲述了人类与外星文明的接触与冲突。', 68.5, 'allowed', '三体');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (11, '钱钟书的经典小说，描写了民国时期知识分子的生活与思想困境。', 52, 'allowed', '围城');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (12, 'J.K.罗琳的魔幻小说，讲述了年轻巫师哈利·波特的成长故事。', 49.9, 'allowed', '哈利·波特与魔法石');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (13, 'W.萨默塞特·毛姆的小说，讲述了主人公对生活的反思与寻找意义。', 55, 'allowed', '刀锋');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (14, '斯宾塞·约翰逊的经典管理书籍，讲述了变化中的适应与成长。', 28, 'allowed', '谁动了我的奶酪');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (15, '东野圭吾的推理小说，讲述了数学天才为爱情隐瞒罪行的故事。', 40, 'allowed', '嫌疑人X的献身');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (16, '鲁迅的文学作品集，包含了小说、散文、杂文等多种文学形式。', 198, 'allowed', '鲁迅全集');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (17, '简·奥斯汀的小说，讲述了伊丽莎白与达西之间的爱情故事。', 39.9, 'allowed', '傲慢与偏见');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (18, '安东尼·德·圣-埃克苏佩里的经典童话，讲述了一个小王子与世界的故事。', 36.8, 'allowed', '小王子');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (19, '日本作家稻盛和夫的经典著作，讲述了关于人生与经营的哲理。', 45, 'allowed', '活法');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (20, '亚历山大·小仲马的小说，讲述了茶花女玛格丽特的爱情故事。', 48, 'allowed', '茶花女');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (21, '当年明月的历史书籍，通过轻松幽默的方式讲述了明朝的历史。', 55.9, 'allowed', '明朝那些事儿');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (22, '马伯庸的历史小说，讲述了唐代长安城的奇案与破案过程。', 59, 'allowed', '长安十二时辰');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (23, '东野圭吾的推理小说，讲述了一段充满秘密与悬疑的爱情故事。', 45, 'allowed', '白夜行');
INSERT INTO `books` (`id`, `description`, `price`, `status`, `title`) VALUES (24, '余秋雨的文化散文，通过旅行的故事谈论中国文化的变迁与痛苦。', 39, 'allowed', '文化苦旅');
COMMIT;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` datetime(6) DEFAULT NULL,
  `bid` int DEFAULT NULL,
  `sid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKec9fp1mrk8e2vp6d6tgkfb655` (`bid`),
  KEY `FKbwi3je5042ggose42q7dlbipd` (`sid`),
  CONSTRAINT `FKbwi3je5042ggose42q7dlbipd` FOREIGN KEY (`sid`) REFERENCES `student` (`id`),
  CONSTRAINT `FKec9fp1mrk8e2vp6d6tgkfb655` FOREIGN KEY (`bid`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of borrow
-- ----------------------------
BEGIN;
INSERT INTO `borrow` (`id`, `time`, `bid`, `sid`) VALUES (5, '2025-04-13 15:31:54.369000', 2, 1);
INSERT INTO `borrow` (`id`, `time`, `bid`, `sid`) VALUES (6, '2025-04-18 15:50:04.429000', 6, 1);
COMMIT;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
BEGIN;
INSERT INTO `persistent_logins` (`username`, `series`, `token`, `last_used`) VALUES ('admin', 'hhAO+DBji7mRqEuWI7ne7Q==', 'fDE2PvzuCN0kh4act12sJg==', '2025-04-19 15:00:38');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `grade` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`id`, `email`, `name`, `sex`, `grade`) VALUES (1, NULL, '小明', '男', 1);
INSERT INTO `student` (`id`, `email`, `name`, `sex`, `grade`) VALUES (2, NULL, '小红', '女', 2);
INSERT INTO `student` (`id`, `email`, `name`, `sex`, `grade`) VALUES (6, '1904474691@qq.com', 'user', '武装直升机', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
