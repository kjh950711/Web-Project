/* 작성자: 최보름
 * 기능: 기수 프로필 구조 인터페이스
 * */

package model;
import java.util.ArrayList;

import vo.PyVO;

public interface PYIntro {
		//public abstract 
		ArrayList<PyVO> pySelect();
		PyVO pySelect(String pyname);
		int	pyInsert(PyVO evo);
		int	pyUpdate(PyVO pvo);
		int	pyDelete(String pyname);		
}
