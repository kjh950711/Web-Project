package com.kosa.model;

import java.util.ArrayList;
import com.kosa.vo.HorseInfoVO;

public interface HorseInfo {
	ArrayList<String> hNameSelect();
	void horseInfoInsert(HorseInfoVO hivo);
	void horseInfoUpdate(HorseInfoVO hvo);
	HorseInfoVO HorseInfoSelect(String hname);
	ArrayList<HorseInfoVO> horseSelect();

}
