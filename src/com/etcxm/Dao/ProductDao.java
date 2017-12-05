package com.etcxm.Dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.Entity.Product;
import com.etcxm.Entity.ProductImg;
import com.etcxm.Entity.ProductValue;
import com.etcxm.Utils.DBUtil;
import com.etcxm.Utils.JDBCUtils;
import com.etcxm.Utils.StringToDate;

public class ProductDao {
	JDBCUtils utils = new JDBCUtils();
	DBUtil dbUtil = new DBUtil();

	public ProductDao() {
		utils.getConnection();
		dbUtil.getConn();
	}

	// ResultSet转List
	private List<Product> resultToList(ResultSet result)
			throws NumberFormatException, SQLException {
		List<Product> list = new ArrayList<Product>();
		while (result.next()) {
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
		result.close();
		return list;
	}

	// 查询商品
	public List<Product> queryProduct() throws Exception {
		String sql = "SELECT * FROM t_product";
		ResultSet result = dbUtil.Query(sql);
		List<Product> list = resultToList(result);
		dbUtil.close();
		return list;
	}

	// 通过id查询商品
	public Product queryProductById(int pid) throws Exception {
		String sql = "select * from t_product where id=?";
		ResultSet result = dbUtil.Query(sql, pid);
		List<Product> list = resultToList(result);
		Product product = list.get(0);
		dbUtil.close();
		return product;
	}
	//通过Cid查询商品
	public List<Product> queryProductByCId(int cid) throws Exception {
		String sql = "select * from t_product where cid=?";
		ResultSet result = dbUtil.Query(sql, cid);
		List<Product> list = resultToList(result);
		return list;
	}
	// 模糊查询商品
	public List<Product> likeQueryProduct(String content) throws Exception {
		String sql = "select * from t_product where NAME like ?";
		ResultSet result = dbUtil.Query(sql, "%"+content+"%");
		List<Product> list = resultToList(result);
		dbUtil.close();
		return list;
	}
	// 新增商品
	public boolean addProduct(Product p) throws SQLException {
		String sql = "insert into t_product values (null,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(p.getCID());
		params.add(p.getNAME());
		params.add(p.getTITLE());
		params.add(p.getPRICE());
		params.add(p.getDISCOUNTPRICE());
		params.add(p.getSTOCK());
		params.add(p.getCREATEDATE());
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	//删除商品
	public boolean deleteProductById(int id) throws SQLException {
		String sql = "delete from t_product WHERE id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	// 更新商品
	public boolean updateProduct(Product p) throws SQLException {
		String sql = "update t_product set name=?,title=?,price=?,discountprice=?,stock=? WHERE id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(p.getNAME());
		params.add(p.getTITLE());
		params.add(p.getPRICE());
		params.add(p.getDISCOUNTPRICE());
		params.add(p.getSTOCK());
		params.add(p.getID());
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}

	// 新增商品图片
	public boolean addProductImg(int pid, String type) throws SQLException {
		String sql = "insert into t_productimg values (null,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(pid);
		params.add(type);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}

	// 删除商品图片
	public boolean deleteProductImg(int id) throws SQLException {
		String sql = "delete from t_productimg where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}

	// 降序查询商品图片
	public List<ProductImg> queryProductImgDesc() throws Exception {
		String sql = "select * from t_productImg order by id desc";
		List<ProductImg> list = utils.findMoreRefResult(sql, null,
				ProductImg.class);
		utils.releaseConn();
		return list;
	}

	// 商品list-->图片ID list
	public List<String> queryProductImgIdByList(List<Product> list)
			throws NumberFormatException, Exception {
		List<String> list1 = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			BigDecimal id = list.get(i).getID();
			List<ProductImg> list2 = this.queryProductImgDesc(Integer
					.valueOf(id.toString()));
			if (list2.size() == 0) {
				list1.add("");
			} else {
				list1.add(list2.get(0).getID().toString());
			}
		}
		return list1;
	}

	// 根据CID分页查询
	public List<Product> queryProductlimit(int currentPage, int cid)
			throws Exception {
		String sql = "select * from (select rownum r,t1.* from t_product t1 where rownum<? and cid=?) t2 where t2.r > ?";
		int r1 = (currentPage * 5 + 1);
		int r2 = (currentPage - 1) * 5;
		ResultSet result = dbUtil.Query(sql, r1, cid, r2);
		List<Product> list = resultToList(result);
		dbUtil.close();
		return list;
	}

	// 查询商品图片
	public List<ProductImg> queryProductImg(int pid) throws Exception {
		String sql = "select * from t_productimg where pid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(pid);
		List<ProductImg> list = utils.findMoreRefResult(sql, params,
				ProductImg.class);
		utils.releaseConn();
		return list;
	}

	// 查询single商品图片降序
	public List<ProductImg> queryProductImgDesc(int pid) throws Exception {
		String sql = "select * from t_productimg where pid=? and type='single' order by id desc";
		List<Object> params = new ArrayList<Object>();
		params.add(pid);
		List<ProductImg> list = utils.findMoreRefResult(sql, params,
				ProductImg.class);
		utils.releaseConn();
		return list;
	}

	// 查询商品属性byPID
	public List<ProductValue> queryProductValueByPID(int pid) throws Exception {
		String sql = "select t2.id,t1.id as pid,t1.name,t2.value from (select t3.id,t4.id as ptid,t4.name from t_product t3,t_property t4 where t3.cid=t4.cid and t3.id=?) t1 left join t_propertyvalue t2 on t1.id=t2.pid and t1.ptid=t2.ptid";
		ResultSet resultSet = dbUtil.Query(sql, pid);
		List<ProductValue> list = new ArrayList<ProductValue>();
		while (resultSet.next()) {
			ProductValue pv = new ProductValue();
			pv.setID(resultSet.getBigDecimal("ID"));
			pv.setPID(resultSet.getBigDecimal("PID"));
			pv.setNAME(resultSet.getString("NAME"));
			pv.setVALUE(resultSet.getString("VALUE"));
			list.add(pv);
		}
		dbUtil.close();
		return list;
	}

	// 更新商品属性值
	public boolean updateProductValue(int pvid, String value)
			throws SQLException {
		String sql = "update t_propertyvalue set value=? WHERE id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(value);
		params.add(pvid);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}

	// 插入商品属性值
	public boolean addProductValue(int pid, int ptid, String value)
			throws SQLException {
		String sql = "insert into t_propertyvalue values(null,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(pid);
		params.add(ptid);
		params.add(value);
		boolean result = utils.updateByPreparedStatement(sql, params);
		utils.releaseConn();
		return result;
	}
	
}