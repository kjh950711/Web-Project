package com.kosa.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosa.vo.HorseChartVO;
import com.kosa.vo.HorseScoreVO;

@Mapper
@Repository
public interface HorseScoreMapper {
	HorseScoreVO HorseScoreSelectSQL(String hrno);
	HorseScoreVO HorseScoreSelect_rankSQL(String hrno);
	ArrayList<HorseChartVO> HorseScoreSelect_monrankSQL(String hrno);
	void HorseScoreInsertSQL(HorseScoreVO hsvo);
	Double chartavgrankSQL(String hrname);
}
