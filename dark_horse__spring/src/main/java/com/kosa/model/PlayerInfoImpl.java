/* 작성자: 최보름
 * 기능: 기수 프로필 jdbc파일 , 
 * PYIntro.java 인터페이스 implements
 *  private String pyname;
	private String agency;
	private String p_birthday;
	private String p_debut;
	private int p_weight;
	private double p_win_rate_all;
	private double p_win_rate_year;
	private String p_cloth;
	private String p_photo;
	private String p_win_cnt_all;
	private String p_win_cnt_year;
	private int p_g_cnt;
	private String place;
 * */
package com.kosa.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.mapper.PlayerMapper;
import com.kosa.vo.PlayerVO;


@Service("playerInfoImpl")
public class PlayerInfoImpl implements PlayerInfo{

	@Autowired
	PlayerMapper mapper;
	
	@Override
	public ArrayList<String> pySelect() {
		return mapper.pySelectSQL();
	}
	
	@Override
	public ArrayList<PlayerVO> pyOrderSelect() {
		return mapper.pyOrderSelectSQL();			
	}

	@Override
	public PlayerVO pyName(String pname) {	
		return mapper.pyNameSQL(pname);	
	}

	@Override
	public void pyInsert(PlayerVO pvo) {
		mapper.pyInsertSQL(pvo);
	}

}
