package com.kosa.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosa.vo.PlayerPrizeVO;

@Repository
@Mapper
public interface PlayerPrizeMapper {	
	void pyPrizeInsertSQL(PlayerPrizeVO prvo);
	ArrayList<PlayerPrizeVO> pyPrizeSelectSQL(String pname);
}
