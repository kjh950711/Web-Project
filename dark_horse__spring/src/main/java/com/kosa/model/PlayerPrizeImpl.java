/* 작성자: 최보름
 * 기능: 기수의 우승정보 jdbc파일
 * * private String pyname;
	private String p_prize;
	private String g_date;
	private String hrname;
 * */

package com.kosa.model;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.mapper.PlayerPrizeMapper;
import com.kosa.vo.PlayerPrizeVO;

@Service("pyPrizeImpl")
public class PlayerPrizeImpl implements PlayerPrize {
	
	@Autowired
	PlayerPrizeMapper mapper;
	
	@Override
	public void pyPrizeInsert(PlayerPrizeVO pvo) {
		mapper.pyPrizeInsertSQL(pvo);
	}

	@Override
	public ArrayList<PlayerPrizeVO> pyPrizeSelect(String pname) {
		return mapper.pyPrizeSelectSQL(pname);

	}

}