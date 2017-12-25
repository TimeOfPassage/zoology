package com.txzhe.entity.base;

/**
 * 结果集合
 * 
 * @author heyangda-bizcent
 * 
 *         <pre>
         第一种：返回默认实体对象
   {
		"error_no":100,
		"error_msg" : "调用成功",
		"data" : {
			"id" : 1,
			"username" : "tianxingzhe",
			"age":20
		}
	}
 *         </pre>
 * 
 *         <pre>
   第二种：返回集合形式
   {
		"error_no":100,
		"error_msg" : "调用成功",
		"data" : {
			"id" : 1,
			"username" : "tianxingzhe",
			"age":20
		}
	}
 *         </pre>
 * 
 */
public class ResultSet {
	protected String errorNo = "0";
	private String errorMessage = "调用成功";
	private Object data;// 支持扩展

	public String getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
