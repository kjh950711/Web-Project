package com.kosa.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosa.vo.ScheduleInfoListVO;
import com.kosa.vo.ScheduleInfoVO;
import com.kosa.vo.ScheduleListVO;

@Mapper
@Repository
public interface ScheduleMapper {
	ArrayList<String> hNameSelectSQL();
	ArrayList<ScheduleInfoVO> infoOptionSelectSQL(String gamePlace);
	ArrayList<ScheduleInfoListVO> gameListSelectSQL(ScheduleInfoVO sivo);
	ArrayList<ScheduleInfoListVO> gameListSelectAllSQL();
	void scheduleInfoInsertSQL(ScheduleInfoVO sivo);
	void scheduleListInsertSQL(ScheduleListVO slvo);
}
