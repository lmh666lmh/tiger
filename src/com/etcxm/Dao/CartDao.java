package com.etcxm.Dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.Entity.Order;
import com.etcxm.Entity.orderItem;
import com.etcxm.Utils.DBUtil;
import com.etcxm.Utils.JDBCUtils;

public class CartDao {
	JDBCUtils utils = new JDBCUtils();
	DBUtil dbUtil = new DBUtil();

	public CartDao() {
		utils.getConnection();
		dbUtil.getConn();
	}
	// 插入一条orderitem
	public boolean addOrderItem(orderItem oi) throws SQLException {
		String sql = "insert into t_orderitem values (null,?,?,null,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(oi.getPID());
		params.add(oi.getUSERID());
		params.add(oi.getNUM());
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	// 添加购物车 更新一条orderitem
	public boolean updateOrderItem(orderItem oi) throws SQLException {
		String sql = "update  t_orderitem set num=num+? where pid=? and userid=? and oid is null";
		List<Object> params = new ArrayList<Object>();
		params.add(oi.getNUM());
		params.add(oi.getPID());
		params.add(oi.getUSERID());
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	// AJAX更新购物车 orderitem
	public boolean updateOrderItemAjax(orderItem oi) throws SQLException {
		String sql = "update  t_orderitem set num=? where pid=? and userid=? and oid is null";
		List<Object> params = new ArrayList<Object>();
		params.add(oi.getNUM());
		params.add(oi.getPID());
		params.add(oi.getUSERID());
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	// 删除购物车 orderitem
		public boolean deleteOrderItem(orderItem oi) throws SQLException {
			String sql = "delete from t_orderitem where pid=? and userid=? and oid is null";
			List<Object> params = new ArrayList<Object>();
			params.add(oi.getPID());
			params.add(oi.getUSERID());
			boolean result = utils.updateByPreparedStatement(sql, params);
			utils.releaseConn();
			return result;
		}
	//查询orderitem By pid&uid
	public List<orderItem> queryOrderItemByPIDAndUID(int pid,BigDecimal uid) throws Exception {
		String sql = "select * from t_orderitem where pid=? and userid=? and oid is null";
		ResultSet resultSet = dbUtil.Query(sql,pid,uid);
		List<orderItem> list=new ArrayList<orderItem>();
		while(resultSet.next()){
			orderItem oi=new orderItem();
			oi.setID(resultSet.getBigDecimal("ID"));
			oi.setPID(resultSet.getBigDecimal("PID"));
			oi.setUSERID(resultSet.getBigDecimal("USERID"));
			oi.setOID(resultSet.getBigDecimal("OID"));
			oi.setNUM(resultSet.getBigDecimal("NUM"));
			list.add(oi);
		}
		dbUtil.close();
		return list;
	}
	//查询orderitem By pid&uid
	public orderItem SingleOrderItemByPIDAndUID(int pid,BigDecimal uid) throws Exception {
		String sql = "select * from t_orderitem where pid=? and userid=? and oid is null";
		ResultSet resultSet = dbUtil.Query(sql, pid,uid);
		orderItem oi=new orderItem();
		while(resultSet.next()){
			oi.setID(resultSet.getBigDecimal("ID"));
			oi.setPID(resultSet.getBigDecimal("PID"));
			oi.setUSERID(resultSet.getBigDecimal("USERID"));
			oi.setOID(resultSet.getBigDecimal("OID"));
			oi.setNUM(resultSet.getBigDecimal("NUM"));
		}
		dbUtil.close();
		return oi;
	}
	//查询orderitem By uid
		public List<orderItem> queryOrderItemByUID(BigDecimal uid) throws Exception {
			String sql = "select * from t_orderitem where userid=? and oid is null";
			ResultSet resultSet = dbUtil.Query(sql,uid);
			List<orderItem> list=new ArrayList<orderItem>();
			while(resultSet.next()){
				orderItem oi=new orderItem();
				oi.setID(resultSet.getBigDecimal("ID"));
				oi.setPID(resultSet.getBigDecimal("PID"));
				oi.setUSERID(resultSet.getBigDecimal("USERID"));
				oi.setOID(resultSet.getBigDecimal("OID"));
				oi.setNUM(resultSet.getBigDecimal("NUM"));
				list.add(oi);
			}
			dbUtil.close();
			return list;
		}
		
		// 更新orderitem的OID  by uid&pid
		public boolean updateOrderItemOID(BigDecimal oid,BigDecimal oiid) throws SQLException {
			String sql = "update  t_orderitem set oid=? where id=?";
			int update = dbUtil.update(sql, oid,oiid);
			if(update>0){
				return true;
			}else{
				return false;
			}
			
		}
	//创建订单
		public boolean addOrder(Order order) throws SQLException {
			String sql = "insert into t_order values (null,?,?,?,?,?,?,?,null,null,null,?,?)";
			List<Object> params = new ArrayList<Object>();
			params.add(order.getORDERCODE());
			params.add(order.getADDRESS());
			params.add(order.getPOST());
			params.add(order.getRECEVIER());
			params.add(order.getMOBILE());
			params.add(order.getUSERMESSAGE());
			params.add(order.getCREATEDATE());
			params.add(order.getSTATUS());
			params.add(order.getUSERID());
			boolean result = utils.updateByPreparedStatement(sql, params);
			utils.releaseConn();
			return result;
		}
		//查询订单 By code 返回OID
				public BigDecimal queryOrderByCode(String code) throws Exception {
					String sql = "select ID from t_order where ordercode=?";
					ResultSet resultSet = dbUtil.Query(sql,code);
					BigDecimal id = null;
					while(resultSet.next()){
						 id = resultSet.getBigDecimal("ID");
					}
					dbUtil.close();
					return id;
				}
 }
