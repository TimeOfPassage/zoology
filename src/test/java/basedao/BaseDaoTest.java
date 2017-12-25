package basedao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.txzhe.dao.system.IRoleDao;
import com.txzhe.dao.system.impl.RoleDaoImpl;
import com.txzhe.entity.system.Role;

public class BaseDaoTest {

	private IRoleDao roleDao = null;
	
	@Before
	public void init(){
		roleDao = new RoleDaoImpl();
	}
	
	@Test
	public void testAdd() throws Exception {
		Role r = new Role();
		r.setId("5");
		r.setRoleName("five level");
		roleDao.add(r);
	}
	
	@Test
	public void testQuery() throws Exception {
		List<Role> query = roleDao.query();
		for (Role role : query) {
			System.out.println(role);
		}
	}
	
	@Test
	public void testDelete() throws Exception {
		Role r = new Role();
		r.setId("5");
		roleDao.delete(r);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Role r = new Role();
		r.setId("5");
		r.setRoleName("五级管理组");
		roleDao.update(r);
	}
}
