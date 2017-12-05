package com.etcxm.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static String driver = "oracle.jdbc.driver.OracleDriver";

	private String url = "jdbc:oracle:thin:@192.168.11.223:1521:orcl";

	private String user = "tiger";// oracle数据库的用户名
	private String pwd = "scott";// oracle数据库的用户密码
	private PreparedStatement sta = null;
	private ResultSet rs = null;
	private Connection conn = null;

	/**
	 * 加载驱动程序
	 */
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return 连接对象
	 */
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * @param sql
	 *            sql语句 增加，删除，修改
	 * @param obj
	 *            参数
	 * @return
	 */
	public int update(String sql, Object... obj) {
		int count = 0;
		conn = getConn();
		try {
			sta = conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					sta.setObject(i + 1, obj[i]);
				}
			}
			count = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();
		}
		return count;
	}

	/**
	 * @param sql
	 *            sql语句
	 * @param obj
	 *            参数
	 * @return 数据集合
	 */
	public ResultSet Query(String sql, Object... obj) {
		conn = getConn();
		try {
			sta = conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					sta.setObject(i + 1, obj[i]);
				}
			}
			rs = sta.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 关闭资源
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
