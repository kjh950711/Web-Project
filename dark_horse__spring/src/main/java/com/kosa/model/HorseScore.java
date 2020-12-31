package com.kosa.model;

import java.util.ArrayList;

import com.kosa.vo.HorseChartVO;
import com.kosa.vo.HorseScoreVO;

public interface HorseScore {
	HorseScoreVO HorseScoreSelect(String hrno);
	HorseScoreVO HorseScoreSelect_rank(String hrno);
	ArrayList<HorseChartVO> HorseScoreSelect_monrank(String hrno);
	void HorseScoreInsert(HorseScoreVO hsvo);
	Double chartavgrank(String hrname);
}
