package com.kosa.vo;

public class ScheduleInfoVO {
	private String hClass;
	private String gameDistance;
	private String gameName;
	private String gameTime;
	private String gameDate;
	private int gameRound;
	private String gamePlace;
	
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
	
	@Override
	public String toString() {
		return "ScheduleInfoVO [hClass=" + hClass + ", gameDistance=" + gameDistance + ", gameName=" + gameName
				+ ", gameTime=" + gameTime + ", gameDate=" + gameDate + ", gameRound=" + gameRound + ", gamePlace="
				+ gamePlace + "]";
	}
	
}
