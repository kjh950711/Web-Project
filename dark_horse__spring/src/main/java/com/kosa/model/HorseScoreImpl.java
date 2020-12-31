package com.kosa.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.mapper.HorseScoreMapper;
import com.kosa.vo.HorseChartVO;
import com.kosa.vo.HorseScoreVO;

@Service("HorseScoreImpl")
public class HorseScoreImpl implements HorseScore{
	
	@Autowired
	HorseScoreMapper mapper;
	
	@Override
	public HorseScoreVO HorseScoreSelect(String hrno) {
		return mapper.HorseScoreSelectSQL(hrno); //메모리에 올려준 객체 자체를 반환
	}

	@Override
	public HorseScoreVO HorseScoreSelect_rank(String hrno) {
		return mapper.HorseScoreSelect_rankSQL(hrno); //메모리에 올려준 객체 자체를 반환
	}
	
	@Override
    public ArrayList<HorseChartVO> HorseScoreSelect_monrank(String hrno) {
		return mapper.HorseScoreSelect_monrankSQL(hrno); //메모리에 올려준 객체 자체를 반환
	}
	
	@Override
    public void HorseScoreInsert(HorseScoreVO hsvo) {
		System.out.println("insert 성공");
	}
   
	@Override
	public Double chartavgrank(String hrname) {
       return mapper.chartavgrankSQL(hrname); 
    }



   
}