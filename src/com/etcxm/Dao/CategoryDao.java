package com.etcxm.Dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;


import com.etcxm.Entity.Category;
import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductQueryObject;
import com.etcxm.Utils.BaseDao;
import com.etcxm.Utils.DBUtil;
import com.etcxm.Utils.JDBCUtils;
import com.etcxm.Utils.StringToDate;


import com.sun.org.apache.bcel.internal.generic.NEW;


public class CategoryDao {
	JDBCUtils utils = new JDBCUtils();
    DBUtil dbUtil=new DBUtil();
    BaseDao base = new BaseDao();
	public CategoryDao() {
		utils.getConnection();
		dbUtil.getConn();
	}

	// 查询分类
	public List<Category> queryCategory() throws Exception {
		String sql = "SELECT * FROM t_category";
		List<Category> list = utils
				.findMoreRefResult(sql, null, Category.class);
		utils.releaseConn();
		return list;
	}
	
	
	// 增加分类
	public boolean addCategory(String name) throws SQLException {
		String sql = "insert into t_category values (null,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	// 删除分类
	public boolean deleteCategory(int id) throws SQLException {
		String sql = "delete from t_category where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}

	// 根据名称查询
	public Category queryByName(String name) throws Exception {
		String sql = "select * from t_category where name=?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		Category result = utils
				.findSimpleRefResult(sql, params, Category.class);
		utils.releaseConn();
		return result;
	}
	//更新
	public boolean updateCategory(String name,int id) throws SQLException {
		String sql = "update t_category set name=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(id);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	//根据ID查询
	public Category queryById(int id) throws Exception {
		String sql = "select * from t_category where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		Category result = utils
				.findSimpleRefResult(sql, params, Category.class);
		utils.releaseConn();
		return result;
	}
	// 分页查询
	public List<Category> queryCategorylimit(int currentPage) throws Exception {
		String sql = "select * from (select rownum r,t1.* from t_category t1 where rownum<?) t2 where t2.r > ?";
		int r1=(currentPage*5+1);
		int r2=(currentPage-1)*5;
		ResultSet result = dbUtil.Query(sql, r1,r2);
		List<Category> list=new ArrayList<Category>();
		while(result.next()){
			Category c=new Category();
			c.setId(BigDecimal.valueOf(Long.valueOf(result.getString("id"))));
			c.setName(result.getString("name"));
			list.add(c);
		}
		return list;
	}
	// 模糊查询
		public List<Category> querymohu(String NAME) throws Exception {
			String sql = "SELECT NAME FROM t_category where NAME like ?";
			List<Object> pr = new ArrayList<Object>();
			pr.add("%"+NAME+"%");
			List<Category> list = utils.findMoreRefResult(sql, pr, Category.class);
			utils.releaseConn();
			return list;
		}
	
	
	
	//查找  多商品
	public List<Product> queryAllproducts() throws Exception{
		String sql = "SELECT * FROM t_product";
		List<Product> select = (List<Product>)BaseDao.select(sql, Product.class, null);
		
		return select;
		}
	/**
	 * 高级查询方法   只要一个对象参数
	 * @param op
	 * @return
	 * @throws Exception
	 */
	public List<Product> query(ProductQueryObject op) throws Exception{
		
		String sql = "SELECT * FROM t_product "+op.getQuerySql();
		System.out.println(sql);
		List<Product> list=new ArrayList<Product>();
		ResultSet result = dbUtil.Query(sql, op.getTITLE(),op.getMaxPrice(),op.getMinPrice());
		while(result.next()){
			Product p = new Product();
			p.setID(BigDecimal.valueOf(Long.valueOf(result.getString("id"))));
			p.setCID(BigDecimal.valueOf(Long.valueOf(result.getString("cid"))));
			p.setNAME(result.getString("name"));
			p.setTITLE(result.getString("title"));
			p.setPRICE(BigDecimal.valueOf(Double.valueOf(result
					.getString("price"))));
			p.setDISCOUNTPRICE(BigDecimal.valueOf(Double.valueOf(result
					.getString("DISCOUNTPRICE"))));
			p.setSTOCK(BigDecimal.valueOf(Long.valueOf(result
					.getString("stock"))));
			p.setCREATEDATE(StringToDate.toSqlTimestamp(result
					.getString("CREATEDATE")));
			list.add(p);
		}
		utils.releaseConn();
		return list;
		
	}
	
	
	
	//商品总条数
	public long totalCount() {
		String sql = "SELECT count(*) FROM t_product ";
		ResultSet resultSet = utils.query(sql, null);
		long result = 0;
		try {
			if(resultSet.next()){
				result = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
