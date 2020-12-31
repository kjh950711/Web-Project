package vo;

public class ScheduleInfoListVO {
	private String h_class;
	private String distance;
	private String g_name;
	private String g_time;
	private String g_date;
	private int g_round;
	private String place;
	private String hrname;
	private String h_sex;
	private int h_age;
	private double h_weight;
	private String pyname;
	private int hno;
	private String h_photo;
	
	
	public String getH_photo() {
		return h_photo;
	}
	public void setH_photo(String h_photo) {
		this.h_photo = h_photo;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
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
	public String getHrname() {
		return hrname;
	}
	public void setHrname(String hrname) {
		this.hrname = hrname;
	}
	public String getH_sex() {
		return h_sex;
	}
	public void setH_sex(String h_sex) {
		this.h_sex = h_sex;
	}
	public int getH_age() {
		return h_age;
	}
	public void setH_age(int h_age) {
		this.h_age = h_age;
	}
	public double getH_weight() {
		return h_weight;
	}
	public void setH_weight(double h_weight) {
		this.h_weight = h_weight;
	}
	public String getPyname() {
		return pyname;
	}
	public void setPyname(String pyname) {
		this.pyname = pyname;
	}
	@Override
	public String toString() {
		return "ScheduleInfoListVO [h_class=" + h_class + ", distance=" + distance + ", g_name=" + g_name + ", g_time="
				+ g_time + ", g_date=" + g_date + ", g_round=" + g_round + ", place=" + place + ", hrname=" + hrname
				+ ", h_sex=" + h_sex + ", h_age=" + h_age + ", h_weight=" + h_weight + ", pyname=" + pyname + ", hno="
				+ hno + ", h_photo=" + h_photo + "]";
	}
	
}
