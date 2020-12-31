package com.kosa.vo;

public class HorseScoreVO {
	
	private String hName;
	private String hno;
	private String gameDate;
	private int hRank;
	private int gameDistance;
	private String pName;
	private String hRecord;
	private int gameMonth;
	private String gamePlace;
	private int gameCnt;
	private double avgRankAll;
	
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
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public int gethRank() {
		return hRank;
	}
	public void sethRank(int hRank) {
		this.hRank = hRank;
	}
	public int getGameDistance() {
		return gameDistance;
	}
	public void setGameDistance(int gameDistance) {
		this.gameDistance = gameDistance;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String gethRecord() {
		return hRecord;
	}
	public void sethRecord(String hRecord) {
		this.hRecord = hRecord;
	}
	public int getGameMonth() {
		return gameMonth;
	}
	public void setGameMonth(int gameMonth) {
		this.gameMonth = gameMonth;
	}
	public String getGamePlace() {
		return gamePlace;
	}
	public void setGamePlace(String gamePlace) {
		this.gamePlace = gamePlace;
	}
	public int getGameCnt() {
		return gameCnt;
	}
	public void setGameCnt(int gameCnt) {
		this.gameCnt = gameCnt;
	}
	public double getAvgRankAll() {
		return avgRankAll;
	}
	public void setAvgRankAll(double avgRankAll) {
		this.avgRankAll = avgRankAll;
	}
	
	@Override
	public String toString() {
		return "HorseScoreVO [hName=" + hName + ", hno=" + hno + ", gameDate=" + gameDate + ", hRank=" + hRank
				+ ", gameDistance=" + gameDistance + ", pName=" + pName + ", hRecord=" + hRecord + ", gameMonth="
				+ gameMonth + ", gamePlace=" + gamePlace + ", gameCnt=" + gameCnt + ", avgRankAll=" + avgRankAll + "]";
	}
	
	
}