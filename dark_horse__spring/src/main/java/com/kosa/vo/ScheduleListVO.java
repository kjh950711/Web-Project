package com.kosa.vo;

public class ScheduleListVO {
	private int gameRound;
	private String hName;
	private String hSex;
	private int hAge;
	private Double hWeight;
	private String pName;
	private String gamePlace;
	private String gameDate;
	private int gameHno;
	private String hPhoto;
	
	public int getGameRound() {
		return gameRound;
	}
	public void setGameRound(int gameRound) {
		this.gameRound = gameRound;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String gethSex() {
		return hSex;
	}
	public void sethSex(String hSex) {
		this.hSex = hSex;
	}
	public int gethAge() {
		return hAge;
	}
	public void sethAge(int hAge) {
		this.hAge = hAge;
	}
	
	public Double gethWeight() {
		return hWeight;
	}
	public void sethWeight(Double hWeight) {
		this.hWeight = hWeight;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getGamePlace() {
		return gamePlace;
	}
	public void setGamePlace(String gamePlace) {
		this.gamePlace = gamePlace;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public int getGameHno() {
		return gameHno;
	}
	public void setGameHno(int gameHno) {
		this.gameHno = gameHno;
	}
	public String gethPhoto() {
		return hPhoto;
	}
	public void sethPhoto(String hPhoto) {
		this.hPhoto = hPhoto;
	}
	
	@Override
	public String toString() {
		return "ScheduleListVO [gameRound=" + gameRound + ", hName=" + hName + ", hSex=" + hSex + ", hAge=" + hAge
				+ ", hWeight=" + hWeight + ", pName=" + pName + ", gamePlace=" + gamePlace + ", gameDate=" + gameDate
				+ ", gameHno=" + gameHno + ", hPhoto=" + hPhoto + "]";
	}
	
}
