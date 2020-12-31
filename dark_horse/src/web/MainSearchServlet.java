package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.HorseImpl;
import model.PlayerInfoImpl;

@WebServlet("/main_search")
public class MainSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HorseImpl hi = new HorseImpl(); 
		PlayerInfoImpl pi = new PlayerInfoImpl();  
		Gson gson = new Gson();
		String search_val = request.getParameter("search_val");
		
		
		
		if(search_val.equals("hrname")) {
			ArrayList<String> hrname_list = new ArrayList<>();
			ArrayList<String> list = hi.hrnameSelect();
			
			// 영어이름 없애기
			for(String hrname : list) {
				if(hrname.contains("(")) {
					hrname = hrname.substring(0, hrname.indexOf("(")).trim();
				}
				hrname_list.add(hrname);
			}
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String  jsonStr = gson.toJson(hrname_list);
			out.println(jsonStr);
			
		} else if(search_val.equals("pyname")) {
			ArrayList<String> pyname_list = pi.pynameSelect();
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String  jsonStr = gson.toJson(pyname_list);
			out.println(jsonStr);
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	

}
