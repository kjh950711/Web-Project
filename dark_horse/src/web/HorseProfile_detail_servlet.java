package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HorseImpl;
import model.HorseScoreImpl;
import vo.HorseInfoVO;
import vo.HorseScoreVO;

@WebServlet("/horse_detail")
public class HorseProfile_detail_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hrname = request.getParameter("hrname");
		HorseImpl hi = new HorseImpl();
		HorseScoreImpl hs = new HorseScoreImpl();
		HorseInfoVO hvo = hi.HorseInfoSelect(hrname);
		String hrno = hvo.getHrno();
		HorseScoreVO hsvo = hs.HorseScoreSelect_rank(hrno);
		System.out.println(hsvo.toString());
		ArrayList<String> monlist = hs.HorseScoreSelect_mon(hrno);
		ArrayList<String> ranklist = hs.HorseScoreSelect_monrank(hrno);
		
		
		//ArrayList<HorseInfoVO> hlist = hi.getHorseList();
		RequestDispatcher rd = request.getRequestDispatcher("hr_profile.jsp");
		request.setAttribute("hvo", hvo);
		request.setAttribute("hsvo", hsvo);
		request.setAttribute("monlist", monlist);
		request.setAttribute("ranklist", ranklist);
		rd.forward(request, response);
	}

}
