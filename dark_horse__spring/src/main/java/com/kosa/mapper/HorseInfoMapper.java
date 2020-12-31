package com.kosa.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosa.vo.HorseInfoVO;

@Repository
@Mapper
public interface HorseInfoMapper {
	ArrayList<String> hNameSelectSQL();
	void horseInfoInsertSQL(HorseInfoVO hivo);
	void horseInfoUpdateSQL(HorseInfoVO hvo);
	HorseInfoVO HorseInfoSelectSQL(String hname);
	ArrayList<HorseInfoVO> horseSelectSQL();
}
