package com.txzhe.dao.base.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.txzhe.dao.base.IBaseDao;
import com.txzhe.utils.ConnectionUtils;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	/** 操作常量 */
	public static final String SQL_INSERT = "insert";
	public static final String SQL_UPDATE = "update";
	public static final String SQL_DELETE = "delete";
	public static final String SQL_SELECT = "select";
	public static final String HANDLE_TABLE_PREFIX = "com.txzhe.entity.";

	// t_system_user ==> t_packageName_entityName com.txzhe.entity包下开始
	private String TABLE_NAME = "t_";
	private Class<T> entityClass = null;

	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			entityClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
			// 获取表名
			String tmpName = entityClass.getName();
			TABLE_NAME = tmpName.substring(tmpName.lastIndexOf(HANDLE_TABLE_PREFIX) + HANDLE_TABLE_PREFIX.length())
					.replace(".", "_").toLowerCase();
			TABLE_NAME = "t_" + TABLE_NAME;
		}
	}

	public Integer add(T t) {
		try {
			conn = ConnectionUtils.getConnectiion();
			String sql = getSql(SQL_INSERT);
			pst = conn.prepareStatement(sql);
			Object[] objects = setArgs(t, SQL_INSERT);
			for (int i = 0, len = objects.length; i < len; i++) {
				pst.setObject(i + 1, objects[i]);
			}
			return pst.executeUpdate();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtils.close(rs, pst, conn);
		}
		return 0;
	}

	@Override
	public Integer delete(T t) {
		try {
			conn = ConnectionUtils.getConnectiion();
			String sql = getSql(SQL_DELETE);
			pst = conn.prepareStatement(sql);
			Object[] objects = setArgs(t, SQL_DELETE);
			for (int i = 0, len = objects.length; i < len; i++) {
				pst.setObject(i + 1, objects[i]);
			}
			return pst.executeUpdate();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtils.close(rs, pst, conn);
		}
		return 0;
	}

	@Override
	public Integer update(T t) {
		try {
			conn = ConnectionUtils.getConnectiion();
			String sql = getSql(SQL_UPDATE);
			pst = conn.prepareStatement(sql);
			Object[] objects = setArgs(t, SQL_UPDATE);
			for (int i = 0, len = objects.length; i < len; i++) {
				pst.setObject(i + 1, objects[i]);
			}
			return pst.executeUpdate();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtils.close(rs, pst, conn);
		}
		return 0;
	}

	@Override
	public List<T> query() {
		List<T> list = null;
		T obj = null;
		try {
			conn = ConnectionUtils.getConnectiion();
			String sql = this.getSql(SQL_SELECT);
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			Field fields[] = entityClass.getDeclaredFields();
			list = new ArrayList<T>();
			while (rs.next()) {
				obj = entityClass.newInstance();
				for (int i = 0; i < fields.length; i++) {
					fields[i].setAccessible(true);
					Object value = rs.getObject(fields[i].getName());
					//对java基本类型判断
					//TODO 后期补充
					if(value instanceof Integer){
						fields[i].set(obj, Integer.toString((int) value));
					}else{
						fields[i].set(obj, value);
					}
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtils.close(rs, pst, conn);
		}
		return list;
	}

	// sql拼接函数 形如 : insert into User(id,username,password,email,grade) values(?,?,?,?,?)
	private String getSql(String operator) {
		StringBuffer sql = new StringBuffer();
		// 通过反射获取实体类中的所有变量
		Field fields[] = entityClass.getDeclaredFields();

		// 插入操作
		if (operator.equals(SQL_INSERT)) {
			sql.append("insert into " + TABLE_NAME);
			sql.append("(");
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true); // 这句话必须要有,否则会抛出异常.
				String column = fields[i].getName();
				sql.append(column).append(",");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(") values (");
			for (int i = 0; fields != null && i < fields.length; i++) {
				sql.append("?,");
			}
			sql.deleteCharAt(sql.length() - 1);
			// 是否需要添加分号
			sql.append(")");
		} else if (operator.equals(SQL_UPDATE)) {
			sql.append("update " + TABLE_NAME + " set ");
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true);
				String column = fields[i].getName();
				if (column.equals("id")) {
					continue;
				}
				sql.append(column).append("=").append("?,");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" where id=?");
		} else if (operator.equals(SQL_DELETE)) {
			sql.append("delete from " + TABLE_NAME + " where id=?");
		} else if (operator.equals(SQL_SELECT)) {
			sql.append("select * from " + TABLE_NAME);
		}
		return sql.toString();
	}

	// 获取参数.
	private Object[] setArgs(T entity, String operator) throws IllegalArgumentException, IllegalAccessException {

		Field fields[] = entityClass.getDeclaredFields();
		if (operator.equals(SQL_INSERT)) {

			Object obj[] = new Object[fields.length];
			for (int i = 0; obj != null && i < fields.length; i++) {
				fields[i].setAccessible(true);
				obj[i] = fields[i].get(entity);
			}
			return obj;

		} else if (operator.equals(SQL_UPDATE)) {

			Object Tempobj[] = new Object[fields.length];
			for (int i = 0; Tempobj != null && i < fields.length; i++) {
				fields[i].setAccessible(true);
				Tempobj[i] = fields[i].get(entity);
			}

			Object obj[] = new Object[fields.length];
			System.arraycopy(Tempobj, 1, obj, 0, Tempobj.length - 1);
			obj[obj.length - 1] = Tempobj[0];
			return obj;

		} else if (operator.equals(SQL_DELETE)) {

			Object obj[] = new Object[1];
			fields[0].setAccessible(true);
			obj[0] = fields[0].get(entity);
			return obj;
		} else if (operator.equals(SQL_SELECT)) {

			Object obj[] = new Object[1];
			fields[0].setAccessible(true);
			obj[0] = fields[0].get(entity);
			return obj;
		}
		return null;
	}

}
