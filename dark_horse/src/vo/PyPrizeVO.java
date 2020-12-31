/* 작성자: 최보름
 * 기능: 기수의 우승정보 vo
 * private String pyname;
	private String p_prize;
	private String g_date;
	private String hrname;
 * */

package vo;

import java.io.Serializable;

public class PyPrizeVO implements Serializable{
	private String pyname;
	private String p_prize;
	private String g_date;
	private String hrname;
	
	public String getPyname() {
		return pyname;
	}
	public void setPyname(String pyname) {
		this.pyname = pyname;
	}
	public String getP_prize() {
		return p_prize;
	}
	public void setP_prize(String p_prize) {
		this.p_prize = p_prize;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
	public String getHrname() {
		return hrname;
	}
	public void setHrname(String hrname) {
		this.hrname = hrname;
	}
	
	@Override
	public String toString() {
		return "PyPrizeVO [pyname=" + pyname + ", p_prize=" + p_prize + ", g_date=" + g_date + ", hrname=" + hrname
				+ "]";
	}
	
	
	
}
