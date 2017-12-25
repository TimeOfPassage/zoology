package com.txzhe.dao.system.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.txzhe.dao.base.impl.BaseDaoImpl;
import com.txzhe.dao.system.IPrivilegeDao;
import com.txzhe.entity.system.Privilege;
import com.txzhe.utils.ConnectionUtils;

public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao {

	@Override
	public List<Privilege> queryPrivilegeListByUserId(String userId) {
		List<Privilege> list = null;
		try {
			conn = ConnectionUtils.getConnectiion();
			String sql = "SELECT p.id,p.name,p.parentId,p.url,p.icon,p.status FROM t_system_privilege p LEFT JOIN t_system_role_privilege rp ON rp.privilegeId = p.id LEFT JOIN t_system_role r ON r.id = rp.roleId LEFT JOIN t_system_user_role ur ON ur.roleId = r.id LEFT JOIN t_system_user u ON u.id = ur.userId WHERE u.id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			list = new ArrayList<Privilege>();
			Privilege p = null;
			while (rs.next()) {
				p = new Privilege();
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setIcon(rs.getString("icon"));
				p.setUrl(rs.getString("url"));
				p.setStatus(rs.getInt("status"));
				p.setParentId(rs.getString("parentId"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtils.close(rs, pst, conn);
		}
		return list;
	}
}
