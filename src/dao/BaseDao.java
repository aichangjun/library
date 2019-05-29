package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

//存在太多模板代码，提取出来
public class BaseDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
//通用的增删改所有的表，所有的条件
	public int executeUpdate(String sql,Object...params ) {
		int rows = 0 ;
		try {
			conn =JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}			
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return rows;
	}
	
	public<T> List<T> executeQuery(String sql,Class<T> clz,Object...params){
		List<T> lists = new ArrayList<T>();
		try {
			conn =JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}			
			rs=ps.executeQuery();	
			//询问rs(rs的元数据：解释数据的数据)
			ResultSetMetaData md = rs.getMetaData();
			int count = md.getColumnCount();
			while(rs.next()) {
				T t=clz.newInstance();//通过反射
				for(int i=0;i<count;i++) {
					//1.获取列名
					String name = md.getColumnName(i+1);
					//2.获取列值
					Object value = rs.getObject(name);
					
					//3.获取同名属性
					Field field = clz.getDeclaredField(name);
					//4.为属性赋值
					field.setAccessible(true);
					if(value!=null) {
						field.set(t,value);
					}
					
				}
				
				lists.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, ps, rs);
		}
		
		return lists;
	
	}
}
