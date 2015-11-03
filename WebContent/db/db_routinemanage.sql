/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : db_routinemanage

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2015-11-03 11:33:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_criticism
-- ----------------------------
DROP TABLE IF EXISTS `t_criticism`;
CREATE TABLE `t_criticism` (
  `criticismId` int(11) NOT NULL AUTO_INCREMENT,
  `criticismContent` varchar(255) NOT NULL,
  `criticismTime` datetime NOT NULL,
  `userId` int(11) NOT NULL,
  `messageId` int(11) NOT NULL,
  PRIMARY KEY (`criticismId`),
  KEY `userId` (`userId`),
  KEY `messageId` (`messageId`),
  CONSTRAINT `t_criticism_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userId`),
  CONSTRAINT `t_criticism_ibfk_2` FOREIGN KEY (`messageId`) REFERENCES `t_message` (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_criticism
-- ----------------------------
INSERT INTO `t_criticism` VALUES ('1', '批复', '2015-10-27 13:22:25', '1', '1');
INSERT INTO `t_criticism` VALUES ('4', '测试批复', '2015-10-27 13:31:53', '1', '2');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `messageTitle` varchar(255) NOT NULL,
  `messageContent` longtext NOT NULL,
  `userId` int(11) NOT NULL,
  `publicTime` datetime NOT NULL,
  PRIMARY KEY (`messageId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_message_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('1', '测试消息', '测试内容', '1', '2015-10-27 11:39:43');
INSERT INTO `t_message` VALUES ('2', '测试消息修改', '测试内容修改', '1', '2015-10-27 11:40:15');
INSERT INTO `t_message` VALUES ('3', '消息', '消息', '1', '2015-10-27 11:40:27');
INSERT INTO `t_message` VALUES ('4', '测试信息2015年10月28日12:00:40', '<div style=\"text-align:center;\">\r\n	<img src=\"/RoutineSystem/upload/image/20151027/20151027185743_954.png\" alt=\"\" />\r\n</div>', '6', '2015-10-28 12:00:53');
INSERT INTO `t_message` VALUES ('5', 'Java笔记1', '<p style=\"color:#646464;font-family:\'Hiragino Sans GB W3\', \'Hiragino Sans GB\', Arial, Helvetica, simsun, u5b8bu4f53;font-size:16px;background-color:#FFFFFF;\">\r\n	<span>基本知识<br />\r\n一．&nbsp;Java基础<br />\r\n1. java语言的特点：<br />\r\n①简单：没有头文件、指针、运算符重载<br />\r\n②面向对象<br />\r\n③分布式：可以通过URL打开访问网络上的应用<br />\r\n④健壮性：Java消除有出错倾向的状态：指针<br />\r\n⑤安全：禁止运行时堆栈溢出...<br />\r\n⑥可移植性：JVM<br />\r\n⑦体系结构中立<br />\r\n⑧解释型<br />\r\n⑨高性能<br />\r\n⑩多线程<br />\r\n⑾动态性<br />\r\n2. jdk的三个版本：<br />\r\n&nbsp;① j2se--&gt;JAVASE--&gt;标准版&nbsp; 主要用于桌面应用程序<br />\r\n&nbsp;② j2me--&gt;JAVAME--&gt;微缩版&nbsp; 主要应用于嵌入式系统开发 如手机、PDA的编程<br />\r\n③ j2ee--&gt;JAVAEE--&gt;企业版&nbsp; 主要应用于分布式网络程序的开发，电子商务及ERP<br />\r\n3. JDK目录：<br />\r\n&nbsp;bin：java开发工具，是一些可执行程序<br />\r\n&nbsp;lib: Java的一些库文件，是java运行的基础<br />\r\n&nbsp;demo：java自带一些示例<br />\r\n4. 环境变量的配置：<br />\r\n&nbsp;JAVA_HOME：jdk安装路径<br />\r\n&nbsp;path：%JAVA_HOME%\\bin<br />\r\n&nbsp;classpath:与我们import和include有关<br />\r\n&nbsp;&nbsp;%JAVA_HOME%\\lib\\tools.jar<br />\r\n&nbsp;&nbsp;%JAVA_HOME%\\lib\\dt.jar<br />\r\n.表示当前路径<br />\r\n5.java中常用命令<br />\r\n&nbsp;包的命名规范：<br />\r\n&nbsp;公司的域名倒写+项目名称+模块名称<br />\r\n带包编译：<br />\r\n&nbsp;javac -d ./ HelloWorld.java(其中的/可以省略)</span>\r\n</p>\r\n<p style=\"color:#646464;font-family:\'Hiragino Sans GB W3\', \'Hiragino Sans GB\', Arial, Helvetica, simsun, u5b8bu4f53;font-size:16px;background-color:#FFFFFF;\">\r\n	<span>带包运行：<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; java com.ambow.javabase.day1.HelloWorld(包的路径 注意运行时文件名首字母大写)<br />\r\njava中的注释类型：<br />\r\n&nbsp;//单行注释<br />\r\n&nbsp;/*... ...*/多行注释<br />\r\n&nbsp;/**... ...*/文档注释</span>\r\n</p>\r\n<p style=\"color:#646464;font-family:\'Hiragino Sans GB W3\', \'Hiragino Sans GB\', Arial, Helvetica, simsun, u5b8bu4f53;font-size:16px;background-color:#FFFFFF;\">\r\n	<span>javadoc -d ./docs HelloWorld.java</span>\r\n</p>\r\n<p style=\"color:#646464;font-family:\'Hiragino Sans GB W3\', \'Hiragino Sans GB\', Arial, Helvetica, simsun, u5b8bu4f53;font-size:16px;background-color:#FFFFFF;\">\r\n	<span>java中的压缩命令：<br />\r\n&nbsp;jar -cvf jar文件名 包路径(压缩包存放在当前路径)(c代表create)</span>\r\n</p>\r\n<p style=\"color:#646464;font-family:\'Hiragino Sans GB W3\', \'Hiragino Sans GB\', Arial, Helvetica, simsun, u5b8bu4f53;font-size:16px;background-color:#FFFFFF;\">\r\n	<span>java中的解压缩命令：<br />\r\n&nbsp;jar -xvf (包路径)jar包名(x代表extend)<br />\r\n运行jar包里面的程序：java -classpath (jar包名) (路径+类文件)<br />\r\n或java -cp (jar包名) (路径+类文件)<br />\r\n6.编写Java代码时要注意的一些小知识点<br />\r\n一个源文件中至多只能有一个public的class<br />\r\n源文件名必须和它定义的public的类名相同<br />\r\n一个文件中可以同时写多个类，但是只能有一个公开的类<br />\r\nMain方法是java程序的入口<br />\r\n7.类加载：<br />\r\n加载代码&nbsp; (类加载器)<br />\r\n&nbsp;将class字节码文件读入内存,并放在数据的方法区,在堆区中创建java.lang.Class对象,用于封装类在方法区内的数据结构<br />\r\n连接&nbsp;&nbsp;<br />\r\n&nbsp;把已经读入内存的类的二进制数据合并到jvm运行环境中去<br />\r\n验证代码&nbsp; (字节码校验器)<br />\r\n&nbsp;保证加载类有正确的内部结构,并与其他类协调一致辞主要有以下几个方面:文件结构检查,语义检查,字节码验证,二进制兼容的验证<br />\r\n准备&nbsp;&nbsp;&nbsp;<br />\r\n&nbsp;Jvm为类的静态变量分配内存,并调置默认的初始值<br />\r\n解析&nbsp;&nbsp;&nbsp;<br />\r\n&nbsp;Jvm把类的二进制数据中的符号引用替换为直接引用<br />\r\n执行代码&nbsp; (解释器)<br />\r\n&nbsp;Jvm执行类初始化语句,为类静态变量赋以初值<br />\r\n8. 标识符、关键字、数据类型：<br />\r\n&nbsp;标识符命名规则：<br />\r\n&nbsp; 1.只能是字母、_、$开头<br />\r\n&nbsp; 2.允许名称中存在字母、_、$、数字<br />\r\n&nbsp; 3.区分大小写<br />\r\n&nbsp; 4.不能使用java中的关键字<br />\r\n&nbsp; 5.长度不限<br />\r\n&nbsp;标识符命名规范：<br />\r\n&nbsp; 1.见名知意<br />\r\n&nbsp; 2.尽量避免使用_，$<br />\r\n&nbsp; 3.类和接口的命名每个单词的首字母要大写<br />\r\n&nbsp; 4.字段方法以及对象的首字母小写其他单词的首字母大写<br />\r\n&nbsp; 5.常量全部大写<br />\r\n&nbsp; 6.包名全部小写<br />\r\n9. 关键字列表：<br />\r\nabstract&nbsp;&nbsp;&nbsp;&nbsp; boolean&nbsp;&nbsp;&nbsp;&nbsp; break&nbsp;&nbsp;&nbsp;&nbsp; byte&nbsp;&nbsp;&nbsp;&nbsp; case&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; catch&nbsp;&nbsp;&nbsp;&nbsp; char&nbsp;&nbsp;&nbsp; class&nbsp;&nbsp;&nbsp;&nbsp; continue&nbsp;&nbsp;&nbsp;&nbsp; default&nbsp;&nbsp;&nbsp;&nbsp; do&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; double&nbsp; else&nbsp;&nbsp;&nbsp;&nbsp; extends&nbsp;&nbsp;&nbsp;&nbsp; enum(枚举)&nbsp;&nbsp;&nbsp;&nbsp; false&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; final&nbsp;&nbsp;&nbsp; finally&nbsp; float&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if&nbsp;&nbsp;&nbsp; implements&nbsp;&nbsp;&nbsp;&nbsp; import&nbsp;&nbsp;&nbsp; instanceof&nbsp;&nbsp; int&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; interface&nbsp;&nbsp;&nbsp;&nbsp; long&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; native&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; new&nbsp;&nbsp;&nbsp;&nbsp; null&nbsp;&nbsp; package&nbsp;&nbsp;&nbsp;&nbsp; private&nbsp;&nbsp;&nbsp;&nbsp; protected&nbsp;&nbsp;&nbsp; public&nbsp;&nbsp;&nbsp; return&nbsp;&nbsp; short&nbsp; static&nbsp;&nbsp;&nbsp;&nbsp; super&nbsp;&nbsp;&nbsp;&nbsp; switch&nbsp;&nbsp;&nbsp;&nbsp; synchronized(线程同步)&nbsp;&nbsp;&nbsp;&nbsp; this&nbsp;&nbsp;&nbsp; throw&nbsp;&nbsp;&nbsp; throws&nbsp;&nbsp;&nbsp; transient&nbsp;&nbsp;&nbsp; true&nbsp;&nbsp;&nbsp; try&nbsp;&nbsp;&nbsp; void&nbsp;&nbsp;&nbsp;&nbsp; volatile(共享)&nbsp;&nbsp; while&nbsp;<br />\r\nJava 中&nbsp;&nbsp; true&nbsp;&nbsp; false&nbsp; 不是关键字,而是boolean类型的字面量<br />\r\n保留字：const，goto<br />\r\n所有的关键字都是小写，friendly，sizeof不是java的关键字<br />\r\n10. 数据类型：<br />\r\n&nbsp;①基本数据类型<br />\r\n&nbsp;&nbsp;byte 8<br />\r\n&nbsp;&nbsp;short 16<br />\r\n&nbsp;&nbsp;int 32<br />\r\n&nbsp;&nbsp;float 32<br />\r\n&nbsp;&nbsp;long 64<br />\r\n&nbsp;&nbsp;double 64<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp; char 16 unicode---一个字符占两个字节<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp; boolean(布尔值)<br />\r\nfloat f = 0.1;编译错误，系统默认把小数当做double来看待，double是64位，float是32位，会造成精度丢失<br />\r\n直接表示一个float类型的值必须在数字后跟‘f’或‘F’<br />\r\n直接表示一个double类型的值必须在数字后跟‘d’或‘D’<br />\r\n②引用数据类型：数组、类、接口<br />\r\n③基本数据类型的转换顺序<br />\r\nbyte---&gt;short---&gt;int---&gt;long---&gt;float---&gt;double<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; char---&gt;(char指向int)<br />\r\n在上图中，顺着箭头方向的类型转换可以自动进行，逆箭头方向的转换或无箭头类型之间的转换必须强制进行。<br />\r\n&nbsp;</span>\r\n</p>\r\n<p align=\"center\" style=\"color:#646464;font-family:\'Hiragino Sans GB W3\', \'Hiragino Sans GB\', Arial, Helvetica, simsun, u5b8bu4f53;font-size:16px;background-color:#FFFFFF;\">\r\n	<span><img alt=\"Java学习笔记(原创) - Magicc - 異次元藍客\" src=\"http://img2.ph.126.net/6eoceH46oKFN7HKSjgL20Q==/6597897698914233548.png\" style=\"height:auto;\" /></span>\r\n</p>\r\n<p style=\"color:#646464;font-family:\'Hiragino Sans GB W3\', \'Hiragino Sans GB\', Arial, Helvetica, simsun, u5b8bu4f53;font-size:16px;background-color:#FFFFFF;\">\r\n	<span>&nbsp;<br />\r\n在图3-1中有6个实箭头，表示无数据丢失的转换；有3个虚箭头，表示可能有精度损失的转换<br />\r\n11. 转义字符：<br />\r\n&nbsp;转义字符&nbsp;描述<br />\r\n&nbsp;\\ddd&nbsp;1到3位8进制数所表示的字符(ddd)<br />\r\n&nbsp;\\uxxxx&nbsp;1到4位16进制数所表示的字符(xxxx)<br />\r\n&nbsp;\\’&nbsp;&nbsp;单引号字符<br />\r\n&nbsp;\\’’&nbsp;双引号字符<br />\r\n&nbsp;\\\\&nbsp;&nbsp;反斜杠字符<br />\r\n&nbsp;\\r&nbsp;&nbsp;回车<br />\r\n&nbsp;\\n&nbsp;&nbsp;换行<br />\r\n&nbsp;\\f&nbsp;&nbsp;走纸换页<br />\r\n&nbsp;\\t&nbsp;&nbsp;横向跳格(一次跳8个字位)<br />\r\n&nbsp;\\b&nbsp;&nbsp;退格</span>\r\n</p>', '6', '2015-10-28 19:41:02');
INSERT INTO `t_message` VALUES ('6', '测试', '<div style=\"text-align:center;\">\r\n	<span style=\"line-height:1.5;\">a</span><span style=\"line-height:1.5;\">sdsd</span>\r\n</div>', '6', '2015-10-29 12:33:43');
INSERT INTO `t_message` VALUES ('7', '测试信息', '<div style=\"text-align:center;\">\r\n	<span style=\"line-height:1.5;\">adffdasf</span>\r\n</div>', '6', '2015-11-02 12:03:39');
INSERT INTO `t_message` VALUES ('8', 'adsfdsafadsfdasfads', 'asdfasdfadsfadsf<img src=\"/RoutineSystem/upload/image/20151102/20151102120405_553.jpg\" alt=\"\" />', '6', '2015-11-02 12:04:11');
INSERT INTO `t_message` VALUES ('9', 'ZvCZXVcxvzxc', '<div style=\"text-align:center;\">\r\n	<span style=\"line-height:1.5;\"><img src=\"/RoutineSystem/upload/image/20151102/20151102120501_329.png\" alt=\"\" /></span>\r\n</div>', '6', '2015-11-02 12:05:07');
INSERT INTO `t_message` VALUES ('11', 'AAAA', 'AAAA', '6', '2015-11-02 12:05:28');
INSERT INTO `t_message` VALUES ('12', 'Java笔记2', '<pre class=\"prettyprint lang-js\">&lt;%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%&gt;\r\n&lt;%\r\nString path = request.getContextPath();\r\nString basePath = request.getScheme()+\"://\"+request.getServerName()+\":\"+request.getServerPort()+path+\"/\";\r\n%&gt;\r\n&lt;%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\"%&gt;\r\n&lt;!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"&gt;\r\n&lt;html&gt;\r\n&lt;head&gt;\r\n&lt;meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"&gt;\r\n&lt;title&gt;日常事务管理系统-消息管理&lt;/title&gt;\r\n&lt;link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"bootstrap/css/bootstrap.min.css\"&gt;\r\n&lt;link href=\"css/jumbotron-narrow.css\" rel=\"stylesheet\"&gt;\r\n&lt;link href=\"css/signin.css\" rel=\"stylesheet\"&gt;\r\n&lt;/head&gt;\r\n&lt;body&gt;\r\n	&lt;div class=\"container\"&gt;\r\n		&lt;div class=\"header clearfix\"&gt;\r\n			&lt;nav&gt;\r\n				&lt;ul class=\"nav nav-pills pull-right\"&gt;\r\n					&lt;li&gt;&lt;a href=\"index.html\"&gt;主&amp;nbsp;&amp;nbsp;页&lt;/a&gt;&lt;/li&gt;\r\n					&lt;c:choose&gt;\r\n						&lt;c:when test=\"${sessionScope.userstatus!=null}\"&gt;\r\n							&lt;c:choose&gt;\r\n								&lt;c:when test=\"${sessionScope.userstatus.isAdmin==1}\"&gt;\r\n									&lt;li&gt;&lt;a href=\"manage_1.html\"&gt;消息管理&lt;/a&gt;&lt;/li&gt;\r\n									&lt;li&gt;&lt;a href=\"manage.html\"&gt;用户管理&lt;/a&gt;&lt;/li&gt;\r\n									&lt;li&gt;&lt;a href=\".html\"&gt;批复管理&lt;/a&gt;&lt;/li&gt;\r\n									&lt;li&gt;&lt;a href=\"#\"&gt;${sessionScope.userstatus.userName}&lt;/a&gt;&lt;/li&gt;\r\n								&lt;/c:when&gt;\r\n							&lt;/c:choose&gt;\r\n						&lt;/c:when&gt;\r\n						&lt;c:otherwise&gt;\r\n							&lt;!-- 无权限操作未登录 --&gt;\r\n						&lt;/c:otherwise&gt;\r\n					&lt;/c:choose&gt;\r\n				&lt;/ul&gt;\r\n			&lt;/nav&gt;\r\n			&lt;h3 class=\"text-muted\"&gt;日常事务管理系统管理界面&lt;/h3&gt;\r\n		&lt;/div&gt;\r\n		&lt;div class=\"jumbotron\"&gt;\r\n			&lt;table class=\"table table-bordered\"&gt;\r\n				&lt;tr&gt;\r\n					&lt;td&gt;编号&lt;/td&gt;\r\n					&lt;td&gt;标题&lt;/td&gt;\r\n					&lt;td&gt;发布时间&lt;/td&gt;\r\n					&lt;td&gt;发布人&lt;/td&gt;\r\n					&lt;td&gt;操作&lt;/td&gt;\r\n				&lt;/tr&gt;\r\n				&lt;c:forEach items=\"${messagelist}\" var=\"message\"&gt;\r\n					&lt;tr&gt;\r\n					&lt;td&gt;${message.messageId}&lt;/td&gt;\r\n					&lt;td&gt;&lt;a href=\"message_2_${message.messageId}.html\"&gt;${message.messageTitle}&lt;/a&gt;&lt;/td&gt;\r\n					&lt;td&gt;${message.publicTime}&lt;/td&gt;\r\n					&lt;td&gt;${message.user.userName}&lt;/td&gt;\r\n					&lt;td&gt;&lt;a href=\"manage_6_${message.messageId}.html\"&gt;删除&lt;/a&gt;&lt;/td&gt;\r\n					&lt;/tr&gt;\r\n				&lt;/c:forEach&gt;\r\n			&lt;/table&gt;\r\n			&lt;ul class=\"pager\"&gt;\r\n			&lt;c:choose&gt;\r\n				&lt;c:when test=\"${page!=null}\"&gt;\r\n					&lt;c:choose&gt;\r\n				       	&lt;c:when test=\"${page.index==1}\"&gt;\r\n							&lt;li class=\"disabled\"&gt;&lt;a href=\"#\"&gt;&amp;larr;上一页&lt;/a&gt;&lt;/li&gt;\r\n				       	&lt;/c:when&gt;              \r\n				           &lt;c:otherwise&gt;\r\n				           	&lt;li&gt;&lt;a href=\"manage_1_10_${page.index-1}.html\"&gt;&amp;larr;上一页&lt;/a&gt;&lt;/li&gt;\r\n				           &lt;/c:otherwise&gt;\r\n				    &lt;/c:choose&gt;\r\n					&lt;li&gt;&lt;a href=\"#\"&gt;${page.index}&lt;/a&gt;&lt;/li&gt;\r\n					&lt;c:choose&gt;\r\n				       	&lt;c:when test=\"${page.index&gt;=page.allpage}\"&gt;\r\n							&lt;li class=\"disabled\"&gt;&lt;a href=\"#\"&gt;下一页&amp;rarr;&lt;/a&gt;&lt;/li&gt;\r\n			       		&lt;/c:when&gt;              \r\n			            &lt;c:otherwise&gt;\r\n			            	&lt;li&gt;&lt;a href=\"manage_1_10_${page.index+1}.html\"&gt;下一页&amp;rarr;&lt;/a&gt;&lt;/li&gt;\r\n			            &lt;/c:otherwise&gt;\r\n			        &lt;/c:choose&gt;\r\n				&lt;/c:when&gt;\r\n			&lt;/c:choose&gt;\r\n				当前：第${page.index }页,共：${page.allpage }页,每页：${page.pagesize }条数据,共${page.allcount }条数据\r\n			&lt;/ul&gt;\r\n		&lt;/div&gt;\r\n		&lt;footer class=\"footer\"&gt;\r\n		&lt;p&gt;&copy; Company 2015&lt;/p&gt;\r\n		&lt;/footer&gt;\r\n\r\n	&lt;/div&gt;\r\n	&lt;!-- /container --&gt;\r\n&lt;/body&gt;\r\n&lt;script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"&gt;&lt;/script&gt;\r\n&lt;!-- IE10 viewport hack for Surface/desktop Windows 8 bug --&gt;\r\n&lt;script src=\"bootstrap/js/ie10-viewport-bug-workaround.js\"&gt;&lt;/script&gt;\r\n&lt;script type=\"text/javascript\" src=\"js/jquery-1.9.1.min.js\"&gt;&lt;/script&gt;\r\n&lt;/html&gt;</pre>', '1', '2015-11-02 23:53:01');

-- ----------------------------
-- Table structure for t_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply` (
  `replyId` int(11) NOT NULL AUTO_INCREMENT,
  `replyContent` varchar(255) NOT NULL,
  `replyDate` datetime NOT NULL,
  `userId` int(11) NOT NULL,
  `messageId` int(11) NOT NULL,
  PRIMARY KEY (`replyId`),
  KEY `userId` (`userId`),
  KEY `messageId` (`messageId`),
  CONSTRAINT `t_reply_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userId`),
  CONSTRAINT `t_reply_ibfk_2` FOREIGN KEY (`messageId`) REFERENCES `t_message` (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_reply
-- ----------------------------
INSERT INTO `t_reply` VALUES ('1', '回复测试消息', '2015-10-27 12:56:02', '1', '1');
INSERT INTO `t_reply` VALUES ('2', '回复测试消息', '2015-10-27 12:54:54', '1', '1');
INSERT INTO `t_reply` VALUES ('3', '<div style=\"text-align:center;\">\r\n	<span style=\"line-height:1.5;\">replycontent</span>\r\n</div>', '2015-11-02 21:28:21', '6', '8');
INSERT INTO `t_reply` VALUES ('4', '<div style=\"text-align:center;\">\r\n	<span style=\"line-height:1.5;\">回复</span>\r\n</div>', '2015-11-02 21:29:33', '6', '8');
INSERT INTO `t_reply` VALUES ('5', '<img src=\"/RoutineSystem/upload/image/20151027/20151027185809_762.png\" alt=\"\" />', '2015-11-02 21:30:51', '6', '8');
INSERT INTO `t_reply` VALUES ('6', 'asdf', '2015-11-02 21:49:25', '6', '8');
INSERT INTO `t_reply` VALUES ('7', 'asdf', '2015-11-02 21:49:29', '6', '8');
INSERT INTO `t_reply` VALUES ('8', 'asdf', '2015-11-02 21:49:32', '6', '8');
INSERT INTO `t_reply` VALUES ('9', 'asdf', '2015-11-02 21:49:35', '6', '8');
INSERT INTO `t_reply` VALUES ('10', 'asdf', '2015-11-02 21:49:38', '6', '8');
INSERT INTO `t_reply` VALUES ('11', 'asdf', '2015-11-02 21:49:41', '6', '8');
INSERT INTO `t_reply` VALUES ('12', 'asdf', '2015-11-02 21:49:43', '6', '8');
INSERT INTO `t_reply` VALUES ('13', 'asdfasdf', '2015-11-02 21:49:54', '6', '8');
INSERT INTO `t_reply` VALUES ('14', '管理员', '2015-11-02 22:00:35', '1', '8');
INSERT INTO `t_reply` VALUES ('15', 'cxz', '2015-11-02 23:45:24', '1', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userSex` int(1) DEFAULT NULL,
  `userBirthDay` datetime DEFAULT NULL,
  `userPhoneNumber` varchar(255) DEFAULT NULL,
  `userPlace` varchar(255) DEFAULT NULL,
  `isAdmin` int(1) NOT NULL,
  `joinTime` datetime NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70', '1', '2015-10-26 23:59:05', '11111111111', '黑龙江', '1', '2015-10-26 23:52:59', '0');
INSERT INTO `t_user` VALUES ('2', 'zhangsan', '123', '1', '2015-10-26 23:59:26', '11111111111', '黑龙江', '1', '2015-10-26 23:58:16', '0');
INSERT INTO `t_user` VALUES ('4', 'abc', '202cb962ac59075b964b07152d234b70', '1', '2015-10-28 00:37:48', '11111111111', '黑龙江', '1', '2015-10-27 00:48:34', '0');
INSERT INTO `t_user` VALUES ('5', 'tms', '202cb962ac59075b964b07152d234b70', '1', '2015-10-27 01:06:31', '11111111111', '黑龙江', '1', '2015-10-27 01:06:31', '1');
INSERT INTO `t_user` VALUES ('6', 'test', '202cb962ac59075b964b07152d234b70', '1', '2015-10-28 00:36:45', '11111111111', '黑龙江', '2', '2015-10-28 00:36:45', '1');
INSERT INTO `t_user` VALUES ('9', 'test1', '5edb79884e2f55688b7ea75698703b66', '1', '2015-11-11 09:57:00', '213123', '12321', '2', '2015-11-02 21:59:58', '1');
INSERT INTO `t_user` VALUES ('10', 'asfdads', 'e708864855f3bb69c4d9a213b9108b9f', '1', '2015-11-03 10:00:00', 'adsfasdf', 'asdf', '2', '2015-11-02 22:00:09', '1');
