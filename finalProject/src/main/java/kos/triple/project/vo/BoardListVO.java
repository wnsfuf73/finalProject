package kos.triple.project.vo;

import java.util.List;

public class BoardListVO {
	
	BoardVO board;
	List<AnswerVO> andwerList;
	
	public BoardListVO() {
	
	}
	
	public BoardListVO(BoardVO board, List<AnswerVO> andwerList) {
		super();
		this.board = board;
		this.andwerList = andwerList;
	}

	public BoardVO getBoard() {
		return board;
	}
	public void setBoard(BoardVO board) {
		this.board = board;
	}
	public List<AnswerVO> getAndwerList() {
		return andwerList;
	}
	public void setAndwerList(List<AnswerVO> andwerList) {
		this.andwerList = andwerList;
	}
	
	
}
