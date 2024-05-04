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

 Date: 15/12/2023 13:10:40
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES (1, 306022101, 'Java', '计算机', 306000001);
INSERT INTO `courses` VALUES (2, 306022102, 'Python', '计算机', 306000001);
INSERT INTO `courses` VALUES (3, 306022103, '红楼梦', '语文', 306000002);

-- ----------------------------
-- Table structure for graduate_employment
-- ----------------------------
DROP TABLE IF EXISTS `graduate_employment`;
CREATE TABLE `graduate_employment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rank` int NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `monthly_income` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of graduate_employment
-- ----------------------------
INSERT INTO `graduate_employment` VALUES (1, 1, '软件工程', '7056元');
INSERT INTO `graduate_employment` VALUES (2, 2, '计算机科学与技术', '6686元');
INSERT INTO `graduate_employment` VALUES (3, 3, '电子信息工程', '6514元');
INSERT INTO `graduate_employment` VALUES (4, 4, '机械设计制造及其自动化', '6407元');
INSERT INTO `graduate_employment` VALUES (5, 5, '通信工程', '6391元');
INSERT INTO `graduate_employment` VALUES (6, 6, '电气工程及其自动化', '6376元');
INSERT INTO `graduate_employment` VALUES (7, 7, '土木工程', '6222元');
INSERT INTO `graduate_employment` VALUES (8, 8, '数学与应用数学', '5516元');
INSERT INTO `graduate_employment` VALUES (9, 9, '护理学', '5341元');
INSERT INTO `graduate_employment` VALUES (10, 10, '临床医学', '4851元');

-- ----------------------------
-- Table structure for programming_languages
-- ----------------------------
DROP TABLE IF EXISTS `programming_languages`;
CREATE TABLE `programming_languages`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rank` int NULL DEFAULT NULL,
  `language` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `popularity` float NULL DEFAULT NULL,
  `comparison_last_month` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `annual_star` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of programming_languages
-- ----------------------------
INSERT INTO `programming_languages` VALUES (1, 1, 'Python', 13.86, '-0.3%', '2021, 2020');
INSERT INTO `programming_languages` VALUES (2, 2, 'C', 11.44, '-0.33%', '2019, 2017');
INSERT INTO `programming_languages` VALUES (3, 3, 'C++', 10.01, '-0.35%', '2022, 2003');
INSERT INTO `programming_languages` VALUES (4, 4, 'Java', 7.99, '-0.36%', '2015, 2005');
INSERT INTO `programming_languages` VALUES (5, 5, 'C#', 7.3, '-0.35%', NULL);
INSERT INTO `programming_languages` VALUES (6, 6, 'JavaScript', 2.9, '-0.31%', '2014');
INSERT INTO `programming_languages` VALUES (7, 7, 'PHP', 2.01, '-0.29%', '2004');
INSERT INTO `programming_languages` VALUES (8, 8, 'Visual Basic', 1.82, '-0.28%', NULL);
INSERT INTO `programming_languages` VALUES (9, 9, 'SQL', 1.61, '-0.27%', NULL);
INSERT INTO `programming_languages` VALUES (10, 10, 'Assembly language', 1.11, '-0.24%', NULL);
INSERT INTO `programming_languages` VALUES (11, 11, 'Scratch', 1.08, '-0.23%', NULL);
INSERT INTO `programming_languages` VALUES (12, 12, 'Fortran', 1.07, '-0.23%', NULL);
INSERT INTO `programming_languages` VALUES (13, 13, 'Go', 1.03, '-0.16%', '2016, 2009');
INSERT INTO `programming_languages` VALUES (14, 14, 'MATLAB', 0.93, '-0.22%', NULL);
INSERT INTO `programming_languages` VALUES (15, 15, 'Kotlin', 0.92, '-0.23%', NULL);
INSERT INTO `programming_languages` VALUES (16, 16, 'Delphi/Object Pascal', 0.92, '-0.22%', NULL);
INSERT INTO `programming_languages` VALUES (17, 17, 'Swift', 0.82, '-0.22%', NULL);
INSERT INTO `programming_languages` VALUES (18, 18, 'Rust', 0.8, '-0.11%', NULL);
INSERT INTO `programming_languages` VALUES (19, 19, 'Ruby', 0.77, '-0.22%', '2006');
INSERT INTO `programming_languages` VALUES (20, 20, 'R', 0.72, '-0.21%', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生选课信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentcourse
-- ----------------------------
INSERT INTO `studentcourse` VALUES (1, 301, 306022101, '张三', 'Java', NULL);
INSERT INTO `studentcourse` VALUES (2, 302, 306022102, '李四', 'Python', NULL);
INSERT INTO `studentcourse` VALUES (3, 301, 306022102, '张三', 'Python', NULL);
INSERT INTO `studentcourse` VALUES (4, 303, 306022103, '王五', '红楼梦', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (2, 301, '计算机', '张三', '男', 18);
INSERT INTO `students` VALUES (3, 302, '计算机', '李四', '女', 18);
INSERT INTO `students` VALUES (4, 303, '计算机', '王五', '男', 18);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `menu_type` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2850 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '教师', -1, 0, NULL, 'system/dept/index', '', '0', '0', 'system:dept:list', '#', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2, '学生', -1, 0, NULL, 'system/student/index', '', '0', '0', 'system:student:list', '#', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (3, '学生信息', 0, 0, '/index/student', '', '', '0', '0', 'system:student:list', 'location', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (4, '所有学生', 3, 0, '/admin/allstudent', '', '', '0', '0', 'system:dept:list', 'UserFilled', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (5, '学生选课', 3, 0, '/admin/studentcourses', '', '', '0', '0', 'system:student:list', 'WindPower', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (6, '教师信息', 0, 0, '/index/teacher', '', '', '0', '0', 'system:student:list', 'location', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (7, '所有教师', 6, 0, '/admin/allteacher', '', '', '0', '0', 'system:student:list', 'Avatar', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (8, '教师单位', 6, 0, '/admin/units', '', '', '0', '0', 'system:dept:list', 'OfficeBuilding', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (9, '首页', 0, 0, '/admin/home', NULL, '', '0', '0', 'system:student:list', 'HomeFilled', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (10, '课程信息', 0, 0, '/admin/courses', NULL, '', '0', '0', 'system:student:list', 'Menu', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (11, '教师授课', 6, 0, '/admin/teachercourses', NULL, '', '0', '0', 'system:student:list', 'Coin', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (12, '设置', 0, 0, '/index/setting', NULL, '', '0', '0', 'system:student:list', 'setting', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (13, '注册学生', 12, 0, '/admin/registerStudent', NULL, '', '0', '0', 'system:dept:list', 'Operation', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (14, '注册教师', 12, 0, '/admin/registerTeacher', NULL, '', '0', '0', 'system:dept:list', 'VideoPlay', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (15, '修改密码', 12, 0, '/admin/updatePassword', NULL, '', '0', '0', 'system:student:list', 'VideoPlay', '', NULL, '', NULL, '');

-- ----------------------------
-- Table structure for sys_menu1
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu1`;
CREATE TABLE `sys_menu1`  (
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
-- Records of sys_menu1
-- ----------------------------
INSERT INTO `sys_menu1` VALUES (1, '教师', 'dept', 'system/dept/index', '0', '0', 'system:dept:list', '#', NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `sys_menu1` VALUES (2, '学生', 'test', 'system/student/index', '0', '0', 'system:student:list', '#', NULL, NULL, NULL, NULL, 0, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '回眸一笑醉倾城', '$2a$10$yZw0SafUm0xGqv.sYEE8ku/pEOW1TrfYJpU2/Pn.n/9G3dFf6qdha', '0', '123456789@qq.com', '78945612311', '男', NULL, '0', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (2, 'test', '外吃大米', '$2a$10$xR42yh/2i1LRr3k.QI4LNeidqDl8GNDw4i/GvDn1xKYpPTEqHjUpy', '0', '123456@qq.com', '12345678911', '男', NULL, '1', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (3, '789', 'NULL', '$2a$10$a4csGysMbkLXukDMknJ5ve8x4qtR2a2nrDaGtP5s.YSTqiR8nk2mG', '0', NULL, '12345678911', '女', NULL, '1', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (4, '123456', 'NULL', '$2a$10$.4dBzUtfiECl8fFFGg4QBujnityGC5hDAtJaGs2uVXqxkj9UUfUFK', '0', NULL, '12345678911', '男', NULL, '1', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (5, 'admin2', '我姓李，字白', '$2a$10$kDral84oVHwUY6/utC.Hne56h2BtPriPlSgksiCLw85a3BdmNVeVW', '0', '123456@qq.com', '12345678911', '女', NULL, '0', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `UserId` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `RoleId` bigint NOT NULL DEFAULT 0 COMMENT '角色id',
  PRIMARY KEY (`UserId`, `RoleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 2);
INSERT INTO `sys_user_role` VALUES (4, 2);
INSERT INTO `sys_user_role` VALUES (5, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师选课表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachercourse
-- ----------------------------
INSERT INTO `teachercourse` VALUES (1, 306000001, 306022101, '王阳明', 'Java', NULL);
INSERT INTO `teachercourse` VALUES (2, 306000001, 306022102, '王阳明', 'Python', NULL);
INSERT INTO `teachercourse` VALUES (3, 306000002, 306022103, '李白', '红楼梦', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES (1, 306000001, '王阳明', '男', '教授', '计算机');
INSERT INTO `teachers` VALUES (5, 306000002, '李白', '女', '教授', '语文');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '单位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of units
-- ----------------------------
INSERT INTO `units` VALUES (1, '计算机', '78945612311', 306000001, '王阳明');
INSERT INTO `units` VALUES (2, '语文', '12345678911', 306000002, '李白');

SET FOREIGN_KEY_CHECKS = 1;
