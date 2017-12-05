package com.etcxm.Dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.Entity.Category;
import com.etcxm.Entity.Property;
import com.etcxm.Utils.DBUtil;
import com.etcxm.Utils.JDBCUtils;

public class PropertyDao {
	JDBCUtils utils = new JDBCUtils();

	 DBUtil dbUtil=new DBUtil();
	public PropertyDao() {
		utils.getConnection();
		 dbUtil.getConn();
	}
	// 查询属性
	public List<Property> queryProperty() throws Exception {
		String sql = "SELECT * FROM t_property";
		List<Property> list = utils
				.findMoreRefResult(sql, null, Property.class);
		utils.releaseConn();
		return list;
	}
	//新增属性
	public boolean addProperty(String name,int cId) throws SQLException {
		String sql = "insert into t_property values (null,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(cId);
		params.add(name);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	// 删除属性
	public boolean deleteProperty(int id) throws SQLException {
		String sql = "delete from t_property where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	//更新
	public boolean updateProperty(String name,int id) throws SQLException {
		String sql = "update t_property set name=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(id);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	//根据ID查询
	public Property queryById(int id) throws Exception {
		String sql = "select * from t_property where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		Property result = utils
				.findSimpleRefResult(sql, params, Property.class);
		utils.releaseConn();
		return result;
	}
	//根据CID查询
	public List<Property> queryByCID(int cid) throws Exception {
		String sql = "select * from t_property where cid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(cid);
		 List<Property> list = utils
				.findMoreRefResult(sql, params, Property.class);
		utils.releaseConn();
		return list;
	}
	//根据cid&name查询
		public Property queryBycidAndname(int cid,String name) throws Exception {
			String sql = "select * from t_property where cid=? and name=?";
			List<Object> params = new ArrayList<Object>();
			params.add(cid);
			params.add(name);
			Property result = utils
					.findSimpleRefResult(sql, params, Property.class);
			utils.releaseConn();
			return result;
		}
	// 根据CID分页查询
	public List<Property> queryPropertylimit(int currentPage,int cid) throws Exception {
		String sql = "select * from (select rownum r,t1.* from t_property t1 where rownum<? and cid=?) t2 where t2.r > ?";
		int r1=(currentPage*5+1);
		int r2=(currentPage-1)*5;
		ResultSet result = dbUtil.Query(sql, r1,cid,r2);
		List<Property> list=new ArrayList<Property>();
		while(result.next()){
			Property p=new Property();
			p.setID(BigDecimal.valueOf(Long.valueOf(result.getString("id"))));
			p.setCID(BigDecimal.valueOf(Long.valueOf(cid)));
			p.setName(result.getString("name"));
			list.add(p);
		}
		return list;
	}
}
