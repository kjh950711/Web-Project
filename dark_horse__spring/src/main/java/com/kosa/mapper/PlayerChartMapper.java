/* 작성자: 최보름
 * 기능: mapper : playerChartMapper이름을 갖는 객체 => playerCharImpl에 주입됨 (DI)
 *     mapper.xml에 sql문 있음 
 *     dao와 같은 기능
 * */

package com.kosa.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosa.vo.PlayerChartVO;

@Repository("playerChartMapper")
@Mapper
public interface PlayerChartMapper {
	ArrayList<String> monthSelectSQL(String pyname);
	ArrayList<Integer> firstSelectSQL(String pyname);
	ArrayList<Integer> secondSelectSQL(String pyname);
}
