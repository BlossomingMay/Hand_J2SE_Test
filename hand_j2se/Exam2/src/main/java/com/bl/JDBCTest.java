package com.bl;


import java.sql.*;
public class JDBCTest {
    public static void main(String[] args) {

        // 只需要将不同的驱动放在配置文件中，就可以实现连接不同的数据库
        try {
            // 1.注册驱动
            Class.forName(PropertiesUtil.getDriverProperties("MySQL"));
            // 2. 连接数据库
            Connection conn = DriverManager.getConnection(
                    PropertiesUtil.getUrlProperties("MySQL"),       PropertiesUtil.getUsernameProperties("MySQL"),              PropertiesUtil.getPasswordProperties("MySQL"));
            // 3. 创建执行的sql语句, 建议使用PreparedStatement
            //String sql = "select city_id,city from city where country_id = ?";
            String sql = "select rental_date,customer_id from rental where customer_id = ? order by rental_date desc";
            PreparedStatement prep = null;
            prep = (PreparedStatement) conn.prepareStatement(sql);
            prep.setInt(1, 367);
            // 4. 查询sql 语句, 返回一个结果集
            ResultSet result = prep.executeQuery();
            // 5. 处理结果集， 释放资源
            while (result.next()) {
                System.out.print(result.getInt("customer_id")+" | ");
                System.out.print(result.getDate("rental_date")+" ");
                System.out.println("");
            }
//            while (result.next()) {
//                System.out.print(result.getInt("city_id")+" | ");
//                System.out.print(result.getString("city")+" ");
//                System.out.println("");
//
//            }
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("驱动注册未成功");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}