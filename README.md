### Exam1只利用工厂模式创建了返回50个随机数并存在hashmap的工厂方法，尚未完成对List的排序算法。

### Exam2连接了数据库并打印出相关的数据，但是尚未封装到函数里，建立了一个property文件存放配置的mysql的相关信息。

连接数据库的具体property配置如下
#mysql database driver
MySQLdriverClass=com.mysql.cj.jdbc.Driver
MySQLurl=jdbc:mysql://xxx.xxx.xxx.xxx:3306/sakila?useSSL=false&serverTimezone=Asia/Shanghai
MySQLusername=xxxxx
MySQLpassword=xxxxxx

同时Exam2有一个工具类PropertyUtil负责读取property文件。
主函数在App类里
