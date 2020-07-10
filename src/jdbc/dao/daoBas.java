/**
 * DaoBas.java
 *
 * @author minlc
 * @date 2020年6月23日
 * @version 1.0
 */
package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class daoBas {
    // 数据库驱动字符串
    private static String driver = "org.mariadb.jdbc.Driver";
    // mariadb的连接字符串，32405i0f99.wicp.vip:50593/t2 代表着连接了这个链接下的数据库t2
    private static String url = "jdbc:mariadb://192.168.123.140:3306/my?useUnicode=true&characterEncoding=utf-8";
    //private static String url = "jdbc:mariadb://32405i0f99.wicp.vip:42353/my?useUnicode=true&characterEncoding=utf-8";
    // 数据库帐号
    private static String name = "root";
    // 数据库密码
    private static String password = "";
    /**
     * 静态执行方法
     */
    static {
        try {
            Class.forName(driver);	// 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法：getConnection 获取数据库连接
     * @return Connection
     * @date 2020年6月23日
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
        }
        return null;
    }
}
