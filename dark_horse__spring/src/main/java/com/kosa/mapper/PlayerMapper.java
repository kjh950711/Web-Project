package com.kosa.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosa.vo.PlayerVO;

@Mapper
@Repository
public interface PlayerMapper {
	
	ArrayList<String> pySelectSQL();
	ArrayList<PlayerVO> pyOrderSelectSQL();
	PlayerVO pyNameSQL(String pname);
	void pyInsertSQL(PlayerVO pvo);
}
