package com.txzhe.controller.page.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.txzhe.controller.page.AbstractController;
import com.txzhe.dao.system.IPrivilegeDao;
import com.txzhe.dao.system.impl.PrivilegeDaoImpl;
import com.txzhe.entity.base.DataRow;
import com.txzhe.entity.system.Privilege;
import com.txzhe.utils.LoggerUtils;
import com.txzhe.utils.RequestUtils;

public class IndexController extends AbstractController {

	private List<Object> sonTree;
	@Override
	public DataRow returnMapModel(HttpServletRequest req, HttpServletResponse resp) {
		LoggerUtils.info("index controller start");
		sonTree = new ArrayList<>();
		String userId = RequestUtils.getCookie("userId", req);
		IPrivilegeDao pDao = new PrivilegeDaoImpl();
		userId = "bca1acfeb2034cf3a595f06a77da7952";
		List<Privilege> privilegeList = pDao.queryPrivilegeListByUserId(userId);
		//���β˵��ṹ
		/**
		 * 
		 * ���ڵ�
		 * |
		 * һ���˵�
		 * | |
		 * | �����˵�1
		 * | �����˵�2
		 * | 	|
		 * |	�����˵�
		 * һ���˵�
		 *			
		 */
		/**
		 * privilegeList 
		 * [id:1;pid=0,name:one]
		 * [id:2;pid=1,name:2j]
		 * [id:3;pid=1,name:2j]
		 * [id:4;pid=1,name:2j]
		 */
		
		
		//���޼����� ������ https://www.jianshu.com/p/ff07b46666c7
		getSubTree(privilegeList,"0",0);
		
		//��ӡ�˵�
		/*for (Object ss : sonTree) {
			Privilege s = JSON.parseObject(ss.toString(), Privilege.class);
			if(s.getSort() == 0){
				System.out.println(s.toString());
			}else if(s.getSort() == 1){
				System.out.println("\t"+s.toString());
			}else{
				System.out.println("\t \t"+s.toString());
			}
		}*/
		DataRow dr = new DataRow();
		dr.put("treeList", sonTree);
		LoggerUtils.info("index controller end");
		return dr;
	}
	/**
	 * ��ȡ��������
	 * @param privilegeList ����������
	 * @param ��ID
	 * @param �ڵ�ȼ�
	 * @return ������
	 */
	private void getSubTree(List<Privilege> privilegeList, String parentId, int level) {
		
		for (Privilege privilege : privilegeList) {
			if(parentId.equals(privilege.getParentId())){
				privilege.setSort(level);
				sonTree.add(JSON.toJSONString(privilege));
				getSubTree(privilegeList, privilege.getId(), level+1);
			}
		}
	}
}
