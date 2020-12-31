package com.kosa.vo;

public class ScheduleInfoListVO {
	
	private String hClass;
	private String gameDistance;
	private String gameName;
	private String gameTime;
	private String gameDate;
	private int gameRound;
	private String gamePlace;
	private String hName;
	private String hSex;
	private int hAge;
	private double hWeight;
	private String pName;
	private int gameHno;
	private String hPhoto;
	
	public String gethClass() {
		return hClass;
	}
	public void sethClass(String hClass) {
		this.hClass = hClass;
	}
	public String getGameDistance() {
		return gameDistance;
	}
	public void setGameDistance(String gameDistance) {
		this.gameDistance = gameDistance;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameTime() {
		return gameTime;
	}
	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public int getGameRound() {
		return gameRound;
	}
	public void setGameRound(int gameRound) {
		this.gameRound = gameRound;
	}
	public String getGamePlace() {
		return gamePlace;
	}
	public void setGamePlace(String gamePlace) {
		this.gamePlace = gamePlace;
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
	public double gethWeight() {
		return hWeight;
	}
	public void sethWeight(double hWeight) {
		this.hWeight = hWeight;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
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
		return "ScheduleInfoListVO [hClass=" + hClass + ", gameDistance=" + gameDistance + ", gameName=" + gameName
				+ ", gameTime=" + gameTime + ", gameDate=" + gameDate + ", gameRound=" + gameRound + ", gamePlace="
				+ gamePlace + ", hName=" + hName + ", hSex=" + hSex + ", hAge=" + hAge + ", hWeight=" + hWeight
				+ ", pName=" + pName + ", gameHno=" + gameHno + ", hPhoto=" + hPhoto + "]";
	}
	
	
	
}
