/* 작성자: 최보름
 * 기능: 기수프로필 vo
 * */

package vo;

public class PyVO {	
	private int rownum;
	private String pyname;
	private String agency;
	private String p_birthday;
	private String p_debut;
	private int p_weight;
	private double p_win_rate_all;
	private double p_win_rate_year;
	private String p_cloth;
	private String p_photo;
	private String p_win_cnt_all;
	private String p_win_cnt_year;
	private int p_g_cnt;
	private String place;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getPyname() {
		return pyname;
	}
	public void setPyname(String pyname) {
		this.pyname = pyname;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getP_birthday() {
		return p_birthday;
	}
	public void setP_birthday(String p_birthday) {
		this.p_birthday = p_birthday;
	}
	public String getP_debut() {
		return p_debut;
	}
	public void setP_debut(String p_debut) {
		this.p_debut = p_debut;
	}
	public int getP_weight() {
		return p_weight;
	}
	public void setP_weight(int p_weight) {
		this.p_weight = p_weight;
	}
	public double getP_win_rate_all() {
		return p_win_rate_all;
	}
	public void setP_win_rate_all(double p_win_rate_all) {
		this.p_win_rate_all = p_win_rate_all;
	}
	public double getP_win_rate_year() {
		return p_win_rate_year;
	}
	public void setP_win_rate_year(double p_win_rate_year) {
		this.p_win_rate_year = p_win_rate_year;
	}
	public String getP_cloth() {
		return p_cloth;
	}
	public void setP_cloth(String p_cloth) {
		this.p_cloth = p_cloth;
	}
	public String getP_photo() {
		return p_photo;
	}
	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}
	public String getP_win_cnt_all() {
		return p_win_cnt_all;
	}
	public void setP_win_cnt_all(String p_win_cnt_all) {
		this.p_win_cnt_all = p_win_cnt_all;
	}
	public String getP_win_cnt_year() {
		return p_win_cnt_year;
	}
	public void setP_win_cnt_year(String p_win_cnt_year) {
		this.p_win_cnt_year = p_win_cnt_year;
	}
	public int getP_g_cnt() {
		return p_g_cnt;
	}
	public void setP_g_cnt(int p_g_cnt) {
		this.p_g_cnt = p_g_cnt;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "PyVO [rownum=" + rownum + ", pyname=" + pyname + ", agency=" + agency + ", p_birthday=" + p_birthday
				+ ", p_debut=" + p_debut + ", p_weight=" + p_weight + ", p_win_rate_all=" + p_win_rate_all
				+ ", p_win_rate_year=" + p_win_rate_year + ", p_cloth=" + p_cloth + ", p_photo=" + p_photo
				+ ", p_win_cnt_all=" + p_win_cnt_all + ", p_win_cnt_year=" + p_win_cnt_year + ", p_g_cnt=" + p_g_cnt
				+ ", place=" + place + "]";
	}
	
	
	
}
