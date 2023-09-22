/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : scsms

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 22/09/2023 12:19:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `CourseID` int NULL DEFAULT NULL COMMENT '课程编号',
  `CourseName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `DepartmentOffering` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任课单位',
  `TeacherID` int NULL DEFAULT NULL COMMENT '任课教师号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES (1, 1, '水浒', '艺术学院', 1);
INSERT INTO `courses` VALUES (2, 2, '红楼梦', '艺术', 2);
INSERT INTO `courses` VALUES (3, 3, '三国志', '计算机', 3);
INSERT INTO `courses` VALUES (4, 4, '西游记', '计算机', 3);
INSERT INTO `courses` VALUES (5, 5, '高数', '语言文学', 4);
INSERT INTO `courses` VALUES (6, 6, '英语', '语言文学', 5);
INSERT INTO `courses` VALUES (7, 7, 'Java', '计算机', 3);
INSERT INTO `courses` VALUES (8, 8, 'web', '计算机', 3);
INSERT INTO `courses` VALUES (9, 9, '语文', '语言文学', 4);
INSERT INTO `courses` VALUES (10, 10, '化学', '计算机', 3);
INSERT INTO `courses` VALUES (11, 11, '化学', '计算机', 3);
INSERT INTO `courses` VALUES (12, 12, '化学', '计算机', 3);
INSERT INTO `courses` VALUES (13, 13, '化学', '语言文学', 12);

-- ----------------------------
-- Table structure for studentcourse
-- ----------------------------
DROP TABLE IF EXISTS `studentcourse`;
CREATE TABLE `studentcourse`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `StudentID` int NULL DEFAULT NULL COMMENT '学号',
  `CourseID` int NULL DEFAULT NULL COMMENT '课程号',
  `StudentName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `CourseName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `CourseGrade` decimal(5, 2) NULL DEFAULT NULL COMMENT '课程成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生选课信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentcourse
-- ----------------------------
INSERT INTO `studentcourse` VALUES (1, 1, 1, '张三', '水浒', 55.00);
INSERT INTO `studentcourse` VALUES (2, 1, 1, '张三', '水浒', 55.00);
INSERT INTO `studentcourse` VALUES (3, 2, 2, '2', '红楼梦', 45.00);
INSERT INTO `studentcourse` VALUES (4, 3, 3, '3', '三国志', 78.00);
INSERT INTO `studentcourse` VALUES (5, 4, 10, '4', '化学', 44.00);
INSERT INTO `studentcourse` VALUES (6, 4, 4, '4', '西游记', 22.00);
INSERT INTO `studentcourse` VALUES (7, 4, 7, '4', 'Java', 55.00);
INSERT INTO `studentcourse` VALUES (8, 2, 5, '2', '高数', 55.00);
INSERT INTO `studentcourse` VALUES (9, 3, 4, '3', '西游记', 88.00);
INSERT INTO `studentcourse` VALUES (10, 3, 5, '3', '高数', 55.00);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `StudentID` int NOT NULL COMMENT '学号\r\n',
  `Department` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所在系',
  `Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `Gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `Age` int NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`, `StudentID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, 1, '艺术学院', '张三', '男', 20);
INSERT INTO `students` VALUES (2, 5, '艺术', '5', '男', 0);
INSERT INTO `students` VALUES (3, 2, '计算机', '2', '男', 54);
INSERT INTO `students` VALUES (3, 123, '啦啦啦', '123', '男', 0);
INSERT INTO `students` VALUES (4, 3, '计算机', '3', '男', 45);
INSERT INTO `students` VALUES (5, 4, '机械制造', '4', '男', 45);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` int NULL DEFAULT 0 COMMENT '是否删除（0未删除 1已删除）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '教师', 'dept', 'system/dept/index', '0', '0', 'system:dept:list', '#', NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `sys_menu` VALUES (2, '学生', 'test', 'system/student/index', '0', '0', 'system:student:list', '#', NULL, NULL, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色权限字符串',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
  `del_flag` int NULL DEFAULT 0 COMMENT 'del_flag',
  `create_by` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` bigint NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'CEO', 'ceo', '0', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (2, 'Coder', 'coder', '0', 0, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `RoleId` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `menu_id` bigint NOT NULL DEFAULT 0 COMMENT '菜单id',
  PRIMARY KEY (`RoleId`, `menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (2, 2);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `UserName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `NickName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NULL' COMMENT '昵称',
  `Password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `Status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  `Email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `PhoneNumber` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `Gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
  `Avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `UserType` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人的用户id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` int NULL DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '3', 'bei', '$2a$10$dA5KQnry0bIoBtD7zV1u4.pz4RaV0bsqh84r1Ntxb3LwZay9/tswS', '0', '123.@a1', '12345612345', '女', '123', '0', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (2, '5', 'NULL', '$2a$10$0tJ2n7m7Ab7/4XXy57b8iu7c0KS2JmK4pfUq7C3/USa73X5ntB3/K', '0', NULL, NULL, '男', NULL, '1', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (3, '456', 'NULL', '$2a$10$7jFYZ.2mSk8r8Kxf9yf05OXx77CIfucLAhTnLSudjNl5EsuwAXPvO', '0', NULL, NULL, '男', NULL, '1', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (4, '789', 'NULL', '$2a$10$Ca8YVbEksIFSJSXvxTCatOgVdix4f0eOjfDanFBPuknlEE3BkDR1y', '0', NULL, NULL, '男', NULL, '1', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `UserId` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `RoleId` bigint NOT NULL DEFAULT 0 COMMENT '角色id',
  PRIMARY KEY (`UserId`, `RoleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 2);
INSERT INTO `sys_user_role` VALUES (4, 2);

-- ----------------------------
-- Table structure for teachercourse
-- ----------------------------
DROP TABLE IF EXISTS `teachercourse`;
CREATE TABLE `teachercourse`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `TeacherID` int NULL DEFAULT NULL COMMENT '教师号',
  `CourseID` int NULL DEFAULT NULL COMMENT '所授课程号',
  `TeacherName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `CourseName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所选课程名',
  `CourseCredit` int NULL DEFAULT NULL COMMENT '所授课程分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师选课表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachercourse
-- ----------------------------
INSERT INTO `teachercourse` VALUES (1, 1, 1, '王五', '水浒', 5);
INSERT INTO `teachercourse` VALUES (2, 2, 2, '张三', '红楼梦', 5);
INSERT INTO `teachercourse` VALUES (3, 3, 3, '李四', '三国志', 4);
INSERT INTO `teachercourse` VALUES (4, 3, 4, '李四', '西游记', NULL);
INSERT INTO `teachercourse` VALUES (12, 12, NULL, '周八', NULL, NULL);
INSERT INTO `teachercourse` VALUES (13, 12, 13, '周八', '化学', NULL);

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `TeacherID` int UNSIGNED NOT NULL COMMENT '教师号',
  `Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `Gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `Title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职称',
  `Department` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所在系',
  PRIMARY KEY (`id`, `TeacherID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES (1, 1, '王五', '男', '教授', '艺术学院');
INSERT INTO `teachers` VALUES (2, 2, '张三', '男', '教授', '艺术');
INSERT INTO `teachers` VALUES (3, 3, '李四', '男', '教授', '计算机');
INSERT INTO `teachers` VALUES (4, 4, '赵六', '女', '教授', '语言文学');
INSERT INTO `teachers` VALUES (5, 5, '菲奥娜', '男', '教授', '语言文学');
INSERT INTO `teachers` VALUES (6, 6, '艾克', '男', '教授', '语言文学');
INSERT INTO `teachers` VALUES (7, 7, '提莫', '男', '教授', '计算机');
INSERT INTO `teachers` VALUES (8, 8, '诺克萨斯', '男', '教授', '计算机');
INSERT INTO `teachers` VALUES (9, 9, '赵信', '男', '教授', '语言文学');
INSERT INTO `teachers` VALUES (10, 10, '周八', '男', '教授', '语言文学');
INSERT INTO `teachers` VALUES (11, 11, '周八', '男', '教授', '语言文学');
INSERT INTO `teachers` VALUES (12, 12, '周八', '男', '教授', '语言文学');

-- ----------------------------
-- Table structure for units
-- ----------------------------
DROP TABLE IF EXISTS `units`;
CREATE TABLE `units`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `UnitName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `Phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `TeacherID` int NULL DEFAULT NULL COMMENT '教师号',
  `TeacherName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '单位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of units
-- ----------------------------
INSERT INTO `units` VALUES (1, '艺术学院', NULL, 1, '王五');
INSERT INTO `units` VALUES (2, '艺术', NULL, 2, '张三');
INSERT INTO `units` VALUES (3, '计算机', NULL, 3, '李四');
INSERT INTO `units` VALUES (12, '语言文学', NULL, 12, '周八');

SET FOREIGN_KEY_CHECKS = 1;
