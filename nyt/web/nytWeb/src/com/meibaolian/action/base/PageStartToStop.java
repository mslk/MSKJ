package com.meibaolian.action.base;

/**
 * 页数显示 类
 * 
 * @author Administrator
 * 
 */
public class PageStartToStop {

	public static final int countPage=10;
	
	/**
	 * 开始页数
	 */
	private int start;

	/**
	 * 结束页数
	 */
	private int stop;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStop() {
		return stop;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}

	/**
	 * 页数显示
	 * 
	 * @param currentPage
	 * @param totalPage
	 */
	public PageStartToStop(int currentPage, int totalPage) {

		if (currentPage <= 0 || currentPage - countPage/2 <= 0) {
			start = 1;
		} else {
			start = currentPage - countPage/2;
		}
		if (currentPage == totalPage || currentPage + (countPage/2-1) >= totalPage) {
			stop = currentPage;
		} else {
			stop = currentPage + (countPage/2-1);
		}
		int midl = stop - start;

		if (midl != (countPage-1)) {
			stop = stop + ((countPage-1) - midl);
			if (stop >= totalPage) {
				stop = totalPage;
			}
		}
		
		if(start<1){
			start=1;
		}
		if(stop<1){
			stop=1;
		}

	}
	
	public static void main(String[] args) {
		
//		for(int i=1;i<100;i++){
//		    PageStartToStop a=new PageStartToStop(1,11);
////		    System.out.println("---------------------------"+i);
//		    System.out.println(a.getStart());
//		    System.out.println(a.getStop());
//		}
		
//		System.out
//				.println(UtilHelp.encodeByType("%E4%B8%80%E5%B1%82", null));
//		
		
	}

}
