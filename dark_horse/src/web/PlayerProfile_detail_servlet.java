/* 작성자: 최보름
 * 기능: player_list.jsp 에서 이름에 걸린 a href 클릭 => get으로 들어옴 
        request.getparameter(pyname)으로 받고 
		vo, arraylist를 set해서 기수프로필 페이지 pyprofile.jsp로 포워딩 하는 서블릿
 * 넘겨 받아야 하는 정보: pyname (기수명)  => pyname으로 impl해서 vo,arraylist 만듬
 * */

package web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.fastinfoset.Encoder;

import model.PlayerInfoImpl;
import model.PyPrizeImpl;
import model.playerChartImpl;
import vo.PyPrizeVO;
import vo.PyVO;


@WebServlet("/player_detail") 
public class PlayerProfile_detail_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String pyname = request.getParameter("pyname");
		 System.out.println(pyname);
		 PlayerInfoImpl pyImpl = new PlayerInfoImpl(); 
		 
		 //기수명 받아서 기수 프로필 vo생성 
		 PyVO pyprofile = pyImpl.pySelect(pyname); //pyname의 select 데이터 담긴 vo
		 System.out.println(pyprofile.toString());
		 System.out.println(pyprofile.getP_win_rate_all());
		 
		 PyPrizeImpl prImpl = new PyPrizeImpl();
		//기수명 받아서 기수 우승정보 arraylist생성 
		 ArrayList<PyPrizeVO> prlist = prImpl.prSelect(pyname);
		 
		 playerChartImpl chartImpl = new playerChartImpl();
		 ArrayList<String> chartlist = chartImpl.monthSelect(pyname);
		 ArrayList firstlist = chartImpl.firstSelect(pyname);
		 ArrayList secondlist = chartImpl.secondSelect(pyname);
		 
//		 System.out.println("두겟 실행됨...");
//		 response.sendRedirect("GoYou/pyprofile.jsp");
		 RequestDispatcher rd = request.getRequestDispatcher("py_profile.jsp");
		 request.setAttribute("gvo", pyprofile); 
		 request.setAttribute("prizelist", prlist); 
		 request.setAttribute("chartlist", chartlist); 
		 request.setAttribute("firstlist", firstlist); 
		 request.setAttribute("secondlist", secondlist); 
		 rd.forward(request, response); 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}
