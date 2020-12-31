package vo;

public class ScheduleInfoVO {
	private String h_class;
	private String distance;
	private String g_name;
	private String g_time;
	private String g_date;
	private int g_round;
	private String place;
	
	public String getH_class() {
		return h_class;
	}
	public void setH_class(String h_class) {
		this.h_class = h_class;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_time() {
		return g_time;
	}
	public void setG_time(String g_time) {
		this.g_time = g_time;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
	public int getG_round() {
		return g_round;
	}
	public void setG_round(int g_round) {
		this.g_round = g_round;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	@Override
	public String toString() {
		return "ScheduleInfoVO [h_class=" + h_class + ", distance=" + distance + ", g_name=" + g_name + ", g_time="
				+ g_time + ", g_date=" + g_date + ", g_round=" + g_round + ", place=" + place + "]";
	}
}
