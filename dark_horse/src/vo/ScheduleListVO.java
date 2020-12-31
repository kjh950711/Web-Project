package vo;

public class ScheduleListVO {
	private int hno;
	private int g_round;
	private String g_date;
	private String hrname;
	private String h_sex;
	private int h_age;
	private double h_weight;
	private String pyname;
	private String place;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "ScheduleListVO [hno=" + hno + ", g_round=" + g_round + ", g_date=" + g_date + ", hrname=" + hrname
				+ ", h_sex=" + h_sex + ", h_age=" + h_age + ", h_weight=" + h_weight + ", pyname=" + pyname + ", place="
				+ place + ", h_photo=" + h_photo + "]";
	}
	
	
	
}
