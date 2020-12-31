/* 작성자: 최보름
 * 기능: playerChartImpl service를 위한 인터페이스
 * */

package com.kosa.model;

import java.util.ArrayList;

import com.kosa.vo.PlayerChartVO;

public interface PlayerChart {
	public ArrayList<String> monthSelect(String pyname);
	public ArrayList<Integer> firstSelect(String pyname);
	public ArrayList<Integer> secondSelect(String pyname);
}
