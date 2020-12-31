/* 작성자: 최보름
 * 기능: 기수 차트 month,1위횟수,2위횟수 VO파일 , 
 	private String pyname;
 	//pyname을 받아서 쿼리
	private int first_count;
	private int second_count;
	private String month;
 * */

package vo;

public class playerChartVO {
	
	private String pyname;
	private int first_count;
	private int second_count;
	private String month;
	
	public String getPyname() {
		return pyname;
	}
	public void setPyname(String pyname) {
		this.pyname = pyname;
	}
	public int getFirst_count() {
		return first_count;
	}
	public void setFirst_count(int first_count) {
		this.first_count = first_count;
	}
	public int getSecond_count() {
		return second_count;
	}
	public void setSecond_count(int second_count) {
		this.second_count = second_count;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}
