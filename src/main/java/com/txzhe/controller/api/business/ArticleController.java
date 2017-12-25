package com.txzhe.controller.api.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.controller.api.AbstractSysApiController;
import com.txzhe.entity.User;
import com.txzhe.entity.base.DataRow;
import com.txzhe.entity.base.Page;
import com.txzhe.entity.base.ResultSet;

public class ArticleController extends AbstractSysApiController {

	@Override
	public ResultSet execute(HttpServletRequest request, HttpServletResponse response) {
		ResultSet rs = new ResultSet();

		DataRow dr = new DataRow();

		User u = null;
		
		//获取页面
		int pageIndex = 1;
		
		int pageNumber = 10;
		
		
		String searchText = request.getParameter("searchText");
		
		
		
		//搜索框功能
        //当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
        if (null != searchText) {
            try {
                searchText = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Page page = new Page();

		List<Object> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			u = new User();
			u.setId("1");
			u.setUserName("tianxingzhe");
			u.setPassword(UUID.randomUUID().toString().replaceAll("-", ""));

			list.add(u);

		}
		page.setTotalRecords(30);
		page.setList(list);
		
		
		
		dr.put("rows", page.getList());//所有记录
		dr.put("total", page.getTotalRecords());//分页信息
		rs.setData(dr);

		return rs;
	}
}
