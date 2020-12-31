package com.kosa.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.mapper.HorseInfoMapper;
import com.kosa.vo.HorseInfoVO;


@Service("HorseInfoImpl")
public class HorseInfoImpl implements HorseInfo{
	
	@Autowired
	HorseInfoMapper mapper;
	
	@Override
	public ArrayList<String> hNameSelect() {
		return mapper.hNameSelectSQL();
	}
	
	@Override
	public void horseInfoInsert(HorseInfoVO hivo) {
		System.out.println("insert 성공");
	}
	@Override
	public void horseInfoUpdate(HorseInfoVO hvo) {
		System.out.println("Update 성공");
	}

	@Override
	public HorseInfoVO HorseInfoSelect(String hname) {
		return mapper.HorseInfoSelectSQL(hname);
	}

	@Override
	public ArrayList<HorseInfoVO> horseSelect() {
		return mapper.horseSelectSQL();
	}
	
	
}