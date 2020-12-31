/* 작성자: 최보름
 * 기능: arraylist를 set해서 기수목록(상위승률50위)페이지 player_list.jsp로 포워딩하는 서블릿
 * 넘겨 받아야 하는 정보: 없음
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

import model.PlayerInfoImpl;
import vo.PyVO;

@WebServlet("/player_list")
public class PlayerProfile_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerInfoImpl pyImpl = new PlayerInfoImpl(); 
		ArrayList<PyVO> pyprofileList = pyImpl.pySelect(); //모든 기수들의 데이터 담긴 vo ArrayList

		 RequestDispatcher rd = request.getRequestDispatcher("py_list.jsp");
		 request.setAttribute("pyVOList", pyprofileList);  
		 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
