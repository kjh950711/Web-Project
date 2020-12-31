package com.kosa.vo;

public class HorseChartVO {
	private int gameMonth;
	private int avgRankMon;
	
	public int getGameMonth() {
		return gameMonth;
	}
	public void setGameMonth(int gameMonth) {
		this.gameMonth = gameMonth;
	}
	public int getAvgRankMon() {
		return avgRankMon;
	}
	public void setAvgRankMon(int avgRankMon) {
		this.avgRankMon = avgRankMon;
	}
	
	@Override
	public String toString() {
		return "HorseChartVO [gameMonth=" + gameMonth + ", avgRankMon=" + avgRankMon + "]";
	}
	
	
} 
