package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinc.project.board.model.vo.BoardVO;
@Repository("boardD")
public class BoardDaoImpl implements BoardDao{


	@Autowired
	private SqlSession session;

	@Override
	public List<BoardVO> listRow() {
		
		return session.selectList("com.sinc.board.list");
	}

	@Override
	public int registerRow(BoardVO board) {
		return session.insert("com.sinc.board.registerBoard", board);
	}

	@Override
	public List<BoardVO> searchRow(Map<String, String> map) {
		
		return session.selectList("com.sinc.board.searchAjax", map);
	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		
		return session.selectOne("com.sinc.board.selectBoard", board);
	}

	@Override
	public void removeBoard(BoardVO board) {
		session.delete("com.sinc.board.removeBoard", board);
	}

}
