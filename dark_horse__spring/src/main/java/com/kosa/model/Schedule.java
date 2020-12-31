package com.kosa.model;

import java.util.ArrayList;

import com.kosa.vo.NewsVO;
import com.kosa.vo.ScheduleInfoListVO;
import com.kosa.vo.ScheduleInfoVO;
import com.kosa.vo.ScheduleListVO;

public interface Schedule {
	ArrayList<String> hNameSelect();
	
	// 공통 info select option 리스트 출력
	ArrayList<ScheduleInfoVO> infoOptionSelect(String place);
	
	// 출전리스트 출력 (game_date, game_round, game_place)
	ArrayList<ScheduleInfoListVO> gameListSelect(ScheduleInfoVO sivo);
	
	// 전체 출전리스트 출력
	public ArrayList<ScheduleInfoListVO> gameListSelect();

	// db insert할때
	// 스케줄 공통부분
	void scheduleInfoInsert(ScheduleInfoVO sivo);
	
	// 날짜별 경주마 리스트
	void scheduleListInsert(ScheduleListVO slvo);
	
	// 뉴스 가져오기
	ArrayList<NewsVO> getNews();
	//int photoUpdate(String hrname);
}
