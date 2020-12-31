/* 작성자: 최보름
 * 기능: 기수프로필 vo
 * */
//2차수정: 정란

package com.kosa.vo;

public class PlayerVO {	
	private int rownum;
	private String pName;
	private String pAgency;
	private String pBirthday;
	private String pDebut;
	private int pWeight;
	private double pWinRateAll;
	private double pWinRateYear;
	private String pCloth;
	private String pPhoto;
	private String pWinCntAll;
	private String pWinCntYear;
	private int pGameCnt;
	private String gamePlace;
	

	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpAgency() {
		return pAgency;
	}
	public void setpAgency(String pAgency) {
		this.pAgency = pAgency;
	}
	public String getpBirthday() {
		return pBirthday;
	}
	public void setpBirthday(String pBirthday) {
		this.pBirthday = pBirthday;
	}
	public String getpDebut() {
		return pDebut;
	}
	public void setpDebut(String pDebut) {
		this.pDebut = pDebut;
	}
	public int getpWeight() {
		return pWeight;
	}
	public void setpWeight(int pWeight) {
		this.pWeight = pWeight;
	}
	public double getpWinRateAll() {
		return pWinRateAll;
	}
	public void setpWinRateAll(double pWinRateAll) {
		this.pWinRateAll = pWinRateAll;
	}
	public double getpWinRateYear() {
		return pWinRateYear;
	}
	public void setpWinRateYear(double pWinRateYear) {
		this.pWinRateYear = pWinRateYear;
	}
	public String getpCloth() {
		return pCloth;
	}
	public void setpCloth(String pCloth) {
		this.pCloth = pCloth;
	}
	public String getpPhoto() {
		return pPhoto;
	}
	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}
	public String getpWinCntAll() {
		return pWinCntAll;
	}
	public void setpWinCntAll(String pWinCntAll) {
		this.pWinCntAll = pWinCntAll;
	}
	public String getpWinCntYear() {
		return pWinCntYear;
	}
	public void setpWinCntYear(String pWinCntYear) {
		this.pWinCntYear = pWinCntYear;
	}
	public int getpGameCnt() {
		return pGameCnt;
	}
	public void setpGameCnt(int pGameCnt) {
		this.pGameCnt = pGameCnt;
	}
	public String getGamePlace() {
		return gamePlace;
	}
	public void setGamePlace(String gamePlace) {
		this.gamePlace = gamePlace;
	}
	
	@Override
	public String toString() {
		return "PyVO [rownum=" + rownum + ", pName=" + pName + ", pAgency=" + pAgency + ", pBirthday=" + pBirthday
				+ ", pDebut=" + pDebut + ", pWeight=" + pWeight + ", pWinRateAll=" + pWinRateAll + ", pWinRateYear="
				+ pWinRateYear + ", pCloth=" + pCloth + ", pPhoto=" + pPhoto + ", pWinCntAll=" + pWinCntAll
				+ ", pWinCntYear=" + pWinCntYear + ", pGameCnt=" + pGameCnt + ", gamePlace=" + gamePlace + "]";
	}

}
