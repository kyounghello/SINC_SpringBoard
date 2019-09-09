package com.sinc.project.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.board.model.sql.BoardDao;
import com.sinc.project.board.model.vo.BoardVO;

@Service("boardS")
public class BoardServiceImpl implements BoardService{
	@Resource(name = "boardD")
	private BoardDao dao;

	@Override
	public List<BoardVO> listService() {
		
		return dao.listRow();
	}

	@Override
	public int registerService(BoardVO board) {
		// TODO Auto-generated method stub
		return dao.registerRow(board);
	}

	@Override
	public List<BoardVO> searchService(Map<String, String> map) {
		return dao.searchRow(map);
	}

	@Override
	public BoardVO getBoardService(BoardVO board) {
		return dao.getBoard(board);
	}

	@Override
	public void removeBoardService(BoardVO board) {
		dao.removeBoard(board);
		
	}
	
	

}
