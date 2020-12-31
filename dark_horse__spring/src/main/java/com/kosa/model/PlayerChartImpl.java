/* 작성자: 최보름
 * 기능: service : playerChartService이름을 갖는 객체 => playerCharController에 주입됨 (DI)
 *               +playerChartMapper이름을 갖는 mapper객체를 주입받음(DI)
 *               
 *      playerChart 인터페이스를 상속받아서 공통의 구조와 다형성을 유지함
 * */

package com.kosa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kosa.mapper.PlayerChartMapper;
import com.kosa.vo.PlayerChartVO;




@Service("playerChartImpl")
public class PlayerChartImpl implements PlayerChart{

//	public static void main(String[] args) {
//		/*playerChartImpl c = new playerChartImpl();
//		ArrayList p = c.secondSelect("김옥성");
//		System.out.println(p);*/
//	}
	
	@Resource(name="playerChartMapper")
	PlayerChartMapper mapper;
	
	@Override
	public ArrayList<String> monthSelect(String pyname) {		
		return mapper.monthSelectSQL(pyname);	
	}
	
	@Override
	public ArrayList<Integer> firstSelect(String pyname) {		
		return mapper.firstSelectSQL(pyname);	
	}
	
	@Override
	public ArrayList<Integer> secondSelect(String pyname) {		
		return mapper.secondSelectSQL(pyname);	
	}

}
