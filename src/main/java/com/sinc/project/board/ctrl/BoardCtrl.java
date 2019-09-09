package com.sinc.project.board.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.service.BoardService;

@Controller
@RequestMapping("/board")
@SessionAttributes({"loginUser"})
public class BoardCtrl {
//	/board/listPage.sinc
	
	@Resource(name="boardS")
	private BoardService service;
	
	@RequestMapping(value="/listPage.sinc", method=RequestMethod.GET)
	public String list(Model model) {
//		매개변수로 ModelMap으로도 사용할 수 있음.
		System.out.println("board ctrl");
		List<BoardVO> list = service.listService();
		model.addAttribute("list", list);
		return "/board/listPage";
	}

	@RequestMapping(value="/register.sinc", method=RequestMethod.GET)
	public void register() {

	}
	
	@RequestMapping(value="/registerBoard.sinc", method=RequestMethod.POST)
	public String register(BoardVO board) {
		int resultFlag = service.registerService(board);
		if(resultFlag != 0) {
			return "redirect:/board/listPage.sinc";
		}
		return null;
	}
	
	@ResponseBody //ajax 통신을 위한 annotation string / void / modelandview 가 아닌 다른 형태의 리턴타입을 보낼떄 이 annotation 써야함
	@RequestMapping(value="/search.sinc", method=RequestMethod.POST)
	public List<BoardVO> Search(String type, String keyword, HashMap<String,String> map) {
		System.out.println(type + "   ,    " + keyword);
		map.put("type", type);
		map.put("keyword",keyword);
		return service.searchService(map);
//		return null;
	}
	
	//보드 하나 누르면 해당 페이지 불러오기
	@RequestMapping(value="/readPage.sinc", method=RequestMethod.GET)
	public String getItBoard(BoardVO board, Model model) {
		System.out.println("readPage");
		BoardVO result = service.getBoardService(board);
		model.addAttribute("board", result);
		return "/board/readPage";
	}
	
	//remove하면 페이지 삭제하기
	@RequestMapping(value="/removePage.sinc", method=RequestMethod.GET)
	public String remove(BoardVO board) {
		System.out.println("board remove");
		service.removeBoardService(board);
		return "redirect:/board/listPage.sinc";
	}
	
	//board 내용 수정하는 페이지 로드
	@RequestMapping(value="/modifyPage.sinc", method=RequestMethod.GET)
	public String modify(BoardVO board) {
		System.out.println("board modify");
//		service.modifyBoardService(board);
		return "/board/modify";
	}
	
	
	
	
}
