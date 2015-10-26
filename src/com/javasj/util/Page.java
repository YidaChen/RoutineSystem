package com.javasj.util;
/**
* 
* @ClassName: Page 
* @Description: TODO(分页基本属性) 
* @author 王小圈 
* @date 2015年10月26日 下午10:37:08 
*
*/
public class Page {
	/**
	 * 分页当前索引
	 */
	private int index;
	/**
	 * 当前页数大小
	 */
	private int pagesize;
	/**
	 * 查询总数
	 */
	private int allcount;
	/**
	 * 分页总数
	 */
	private int allpage;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getAllcount() {
		return allcount;
	}
	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	
}
