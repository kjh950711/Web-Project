/* 작성자: 최보름
 * 기능: 기수의 우승정보 vo
 * private String pyname;
	private String p_prize;
	private String g_date;
	private String hrname;
 * */
//2차수정:정란


package com.kosa.vo;

import java.io.Serializable;

public class PlayerPrizeVO implements Serializable{
	private String pName;
	private String pPrize;
	private String gameDate;
	private String hName;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPrize() {
		return pPrize;
	}
	public void setpPrize(String pPrize) {
		this.pPrize = pPrize;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	@Override
	public String toString() {
		return "PyPrizeVO [pName=" + pName + ", pPrize=" + pPrize + ", gameDate=" + gameDate + ", hName=" + hName + "]";
	}
	
		
}
