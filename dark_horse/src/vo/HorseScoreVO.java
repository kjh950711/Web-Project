package vo;

public class HorseScoreVO {
   
   private String hrname;
   private String hrno;
   private String racing_date;
   private int rank;
   private int distance;
   private String pyname;
   private String record;
   private int racing_month;
   private String place;
   private int gamecnt;
   private double avgrank;
   
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
   public String getRacing_date() {
      return racing_date;
   }
   public void setRacing_date(String racing_date) {
      this.racing_date = racing_date;
   }
   public int getRank() {
      return rank;
   }
   public void setRank(int rank) {
      this.rank = rank;
   }
   public int getDistance() {
      return distance;
   }
   public void setDistance(int distance) {
      this.distance = distance;
   }
   public String getPyname() {
      return pyname;
   }
   public void setPyname(String pyname) {
      this.pyname = pyname;
   }
   public String getRecord() {
      return record;
   }
   public void setRecord(String record) {
      this.record = record;
   }
   public int getRacing_month() {
      return racing_month;
   }
   public void setRacing_month(int racing_month) {
      this.racing_month = racing_month;
   }
   
   public String getPlace() {
      return place;
   }
   public void setPlace(String place) {
      this.place = place;
   }
   
   
   public int getGamecnt() {
      return gamecnt;
   }
   public void setGamecnt(int gamecnt) {
      this.gamecnt = gamecnt;
   }
   public double getAvgrank() {
      return avgrank;
   }
   public void setAvgrank(double avgrank) {
      this.avgrank = avgrank;
   }
   @Override
   public String toString() {
      return "HorseScoreVO [hrname=" + hrname + ", hrno=" + hrno + ", racing_date=" + racing_date + ", rank=" + rank
            + ", distance=" + distance + ", pyname=" + pyname + ", record=" + record + ", racing_month="
            + racing_month + ", place=" + place + ", gamecnt=" + gamecnt + ", avgrank=" + avgrank + "]";
   }
   
   
}