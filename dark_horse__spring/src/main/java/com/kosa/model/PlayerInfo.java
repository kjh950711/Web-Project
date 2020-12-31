//기능: 기수 프로필 구조 인터페이스

package com.kosa.model;

import java.util.ArrayList;

import com.kosa.vo.PlayerVO;

public interface PlayerInfo {
	ArrayList<String> pySelect();
	ArrayList<PlayerVO> pyOrderSelect();
	PlayerVO pyName(String pname);
	void pyInsert(PlayerVO pvo);		
}
