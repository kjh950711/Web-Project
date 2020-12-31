/* 작성자: 최보름
 * 기능: 기수 차트 month,1위횟수,2위횟수 VO파일 , 
 	private String pyname;
 	//pyname을 받아서 쿼리
	private int first_count;
	private int second_count;
	private String month;
 * */
//2차 수정 완료:정란

package com.kosa.vo;

public class PlayerChartVO {
	
	private String pName;
	private int firstCount;
	private int secondCount;
	private String gameMonth;
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getFirstCount() {
		return firstCount;
	}
	public void setFirstCount(int firstCount) {
		this.firstCount = firstCount;
	}
	public int getSecondCount() {
		return secondCount;
	}
	public void setSecondCount(int secondCount) {
		this.secondCount = secondCount;
	}
	public String getGameMonth() {
		return gameMonth;
	}
	public void setGameMonth(String gameMonth) {
		this.gameMonth = gameMonth;
	}
		
}
