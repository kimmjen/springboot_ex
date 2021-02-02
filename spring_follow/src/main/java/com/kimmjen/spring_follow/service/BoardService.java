package com.kimmjen.spring_follow.service;

import java.util.List;

import com.kimmjen.spring_follow.domain.BoardDTO;

public interface BoardService {

    public boolean registerBoard(BoardDTO params);

	public BoardDTO getBoardDetail(Long idx);

	public boolean deleteBoard(Long idx);

	public List<BoardDTO> getBoardList();
    
}
