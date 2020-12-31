package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.HorseScoreImpl;
import model.ScheduleImpl;
import vo.NewsVO;
import vo.ScheduleInfoListVO;
import vo.ScheduleInfoVO;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduleImpl sch = new ScheduleImpl();
		
		String place = request.getParameter("place");
		String g_date = request.getParameter("g_date");
		String g_round = request.getParameter("g_round");
		
		if(place == null) { // 서울 기본화면 설정
			
			ScheduleInfoVO ssivo = new ScheduleInfoVO();
			ssivo.setPlace("서울");
			ssivo.setG_date("2019.10.12 (토)");
			ssivo.setG_round(1);
			ArrayList<ScheduleInfoListVO> sList = sch.getRaceList(ssivo);
		
			// 옵션 리스트
			ArrayList<ScheduleInfoVO> s_optList = sch.getOptionList("서울");
			ArrayList<NewsVO> nList = sch.getNews();
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("sList", sList);                   // list info
			request.setAttribute("sList_infoVo", sList.get(0));     // 공통 info
			request.setAttribute("s_optList", s_optList);           // option list
			request.setAttribute("nList", nList);
			
			
			HorseScoreImpl HorseScoreImpl = new HorseScoreImpl();
	        ArrayList<Double> avgscorearr = new ArrayList<>();
	        ArrayList<String> hrnameList = new ArrayList<>();
	        String todayhrname = null;
	        for(int i=0; i<sList.size(); i++) {
	            todayhrname=sList.get(i).getHrname();
	            System.out.println(todayhrname);
	            String hrname = "'" + todayhrname + "'";
	            System.out.println(HorseScoreImpl.chartavgrank(hrname));
	            String num = String.format("%.2f" , HorseScoreImpl.chartavgrank(todayhrname));
	            avgscorearr.add(Double.parseDouble(num));
	            hrnameList.add(hrname);
	        }
	         System.out.println(avgscorearr);
	         request.setAttribute("avgscorearr", avgscorearr); 
	         request.setAttribute("hrnameList", hrnameList); 		
			
			rd.forward(request, response);
		} else { // place 값만 들어왔을 때
			Gson gson = new Gson();
			ArrayList<ScheduleInfoListVO> hList = null;
			ArrayList<ScheduleInfoVO> optList = null;
			if(g_date.equals("") && g_round.equals("")) { 
				
				if(place.equals("서울")) {
					ScheduleInfoVO ssivo = new ScheduleInfoVO();
					ssivo.setPlace("서울");
					ssivo.setG_date("2019.10.12 (토)");
					ssivo.setG_round(1);
					hList = sch.getRaceList(ssivo);
					System.out.println("place 값만 들어왔을 때 : 서울 " + hList.toString());
				
					// 옵션 리스트
					optList = sch.getOptionList("서울");
					
				}else if(place.equals("부경")) {
					ScheduleInfoVO ssivo = new ScheduleInfoVO();
					ssivo.setPlace("부경");
					ssivo.setG_date("2019.10.11 (금)");
					ssivo.setG_round(1);
					hList = sch.getRaceList(ssivo);
					System.out.println("place 값만 들어왔을 때 : 부경 " + hList.toString());
				
					// 옵션 리스트
					optList = sch.getOptionList("부경");

					
				}else if(place.equals("제주")) {
					ScheduleInfoVO ssivo = new ScheduleInfoVO();
					ssivo.setPlace("제주");
					ssivo.setG_date("2019.10.11 (금)");
					ssivo.setG_round(1);
					hList = sch.getRaceList(ssivo);
					System.out.println("place 값만 들어왔을 때 : 제주 " + hList.toString());
				
					// 옵션 리스트
					optList = sch.getOptionList("제주");
					
				}
				
			} else {  // 탭으로 넘기고 (place값 받고), search버튼 눌렀을 때
				
				ScheduleInfoVO sivo = new ScheduleInfoVO();
				sivo.setPlace(place);
				sivo.setG_date(g_date);
				sivo.setG_round(Integer.parseInt(g_round));
				hList = sch.getRaceList(sivo);
				System.out.println(" 탭으로 넘기고 (place값 받고), search버튼 눌렀을 때 " + hList.toString());
				
				// 옵션 리스트
				optList = sch.getOptionList(place);
				
			}
			
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hList", hList);
			map.put("optList", optList);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String  jsonStr = gson.toJson(map);
			out.println(jsonStr);
			
			
		}
	}
	
	

}
