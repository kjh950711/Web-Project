package com.kosa.vo;

public class HorseInfoVO {
	
	private int rownum;
	private String hName;
	private String hno;
	private String hSex;
	private String hBirthday;
	private String hClass;
	private String trName;
	private String owName;
	private int hRating;
	private String gamePlace;
	private String hPhoto;
	private String hPrize;
	private double hWinRate;
	private int hTrainingCnt;
	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String gethSex() {
		return hSex;
	}
	public void sethSex(String hSex) {
		this.hSex = hSex;
	}
	public String gethBirthday() {
		return hBirthday;
	}
	public void sethBirthday(String hBirthday) {
		this.hBirthday = hBirthday;
	}
	public String gethClass() {
		return hClass;
	}
	public void sethClass(String hClass) {
		this.hClass = hClass;
	}
	public String getTrName() {
		return trName;
	}
	public void setTrName(String trName) {
		this.trName = trName;
	}
	public String getOwName() {
		return owName;
	}
	public void setOwName(String owName) {
		this.owName = owName;
	}
	public int gethRating() {
		return hRating;
	}
	public void sethRating(int hRating) {
		this.hRating = hRating;
	}
	public String getGamePlace() {
		return gamePlace;
	}
	public void setGamePlace(String gamePlace) {
		this.gamePlace = gamePlace;
	}
	public String gethPhoto() {
		return hPhoto;
	}
	public void sethPhoto(String hPhoto) {
		this.hPhoto = hPhoto;
	}
	public String gethPrize() {
		return hPrize;
	}
	public void sethPrize(String hPrize) {
		this.hPrize = hPrize;
	}
	public double gethWinRate() {
		return hWinRate;
	}
	public void sethWinRate(double hWinRate) {
		this.hWinRate = hWinRate;
	}
	public int gethTrainingCnt() {
		return hTrainingCnt;
	}
	public void sethTrainingCnt(int hTrainingCnt) {
		this.hTrainingCnt = hTrainingCnt;
	}
	
	@Override
	public String toString() {
		return "HorseInfoVO [rownum=" + rownum + ", hName=" + hName + ", hno=" + hno + ", hSex=" + hSex + ", hBirthday="
				+ hBirthday + ", hClass=" + hClass + ", trName=" + trName + ", owName=" + owName + ", hRating="
				+ hRating + ", gamePlace=" + gamePlace + ", hPhoto=" + hPhoto + ", hPrize=" + hPrize + ", hWinRate="
				+ hWinRate + ", hTrainingCnt=" + hTrainingCnt + "]";
	}
	
	
	
}