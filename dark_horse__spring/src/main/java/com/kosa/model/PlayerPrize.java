package com.kosa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosa.vo.PlayerPrizeVO;

public interface PlayerPrize {
	void pyPrizeInsert(PlayerPrizeVO pvo);
	ArrayList<PlayerPrizeVO> pyPrizeSelect(String pname);
}