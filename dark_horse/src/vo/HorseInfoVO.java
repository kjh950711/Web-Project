package vo;

public class HorseInfoVO {
	
	private int rownum;
	private String hrname;
	private String hrno;
	private String h_sex;
	private String h_birthday;
	private String h_class;
	private String trname;
	private String owname;
	private int rating;
	private String place;
	private String h_photo;
	private String h_prize;
	private double h_win_rate;
	private int training_cnt;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getHrname() {
		return hrname;
	}
	public void setHrname(String hrname) {
		this.hrname = hrname;
	}
	public String getHrno() {
		return hrno;
	}
	public void setHrno(String hrno) {
		this.hrno = hrno;
	}
	public String getH_sex() {
		return h_sex;
	}
	public void setH_sex(String h_sex) {
		this.h_sex = h_sex;
	}
	public String getH_birthday() {
		return h_birthday;
	}
	public void setH_birthday(String h_birthday) {
		this.h_birthday = h_birthday;
	}
	public String getH_class() {
		return h_class;
	}
	public void setH_class(String h_class) {
		this.h_class = h_class;
	}
	public String getTrname() {
		return trname;
	}
	public void setTrname(String trname) {
		this.trname = trname;
	}
	public String getOwname() {
		return owname;
	}
	public void setOwname(String owname) {
		this.owname = owname;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getH_photo() {
		return h_photo;
	}
	public void setH_photo(String h_photo) {
		this.h_photo = h_photo;
	}
	public String getH_prize() {
		return h_prize;
	}
	public void setH_prize(String h_prize) {
		this.h_prize = h_prize;
	}
	public double getH_win_rate() {
		return h_win_rate;
	}
	public void setH_win_rate(double h_win_rate) {
		this.h_win_rate = h_win_rate;
	}
	public int getTraining_cnt() {
		return training_cnt;
	}
	public void setTraining_cnt(int training_cnt) {
		this.training_cnt = training_cnt;
	}
	@Override
	public String toString() {
		return "HorseInfoVO [rownum=" + rownum + ", hrname=" + hrname + ", hrno=" + hrno + ", h_sex=" + h_sex
				+ ", h_birthday=" + h_birthday + ", h_class=" + h_class + ", trname=" + trname + ", owname=" + owname
				+ ", rating=" + rating + ", place=" + place + ", h_photo=" + h_photo + ", h_prize=" + h_prize
				+ ", h_win_rate=" + h_win_rate + ", training_cnt=" + training_cnt + "]";
	}
	
	
	
}