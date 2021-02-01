package com.kimmjen.spring_follow;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimmjen.spring_follow.domain.BoardDTO;
import com.kimmjen.spring_follow.mapper.BoardMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

@SpringBootTest
public class MapperTests {

    @Autowired
    private BoardMapper boardMapper;

    // @Test // 데이터 넣기
    // public void testOfInsert() {

    // BoardDTO params = new BoardDTO();

    // params.setTitle("1번 게시글 제목");
    // params.setContent("1번 게시글 내용");
    // params.setWriter("테스터");

    // int result = boardMapper.insertBoard(params);
    // System.out.println("결과는 " + result + "입니다.");
    // }

    @Test // 데이터 추가하기
    public void testMultipleInsert() {
        for (int i = 2; i <= 50; i++) {
            BoardDTO params = new BoardDTO();
            params.setTitle(i + "번 게시글 제목");
            params.setContent(i + "번 게시글 내용");
            params.setWriter(i + "번 게시글 작성자");
            boardMapper.insertBoard(params);
        }
    }

    @Test // 데이터 조회하기
    public void testOfSelectDetail() {
        BoardDTO board = boardMapper.selectBoardDetail((long) 1);
        try {
            String boardJson = new ObjectMapper().writeValueAsString(board);

            System.out.println("=========================");
            System.out.println(boardJson);
            System.out.println("=========================");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test // 데이터 수정
    public void testOfUpdate() {
        BoardDTO params = new BoardDTO();
        params.setTitle("1번 게시글 제목을 수정합니다.");
        params.setContent("1번 게시글 내용을 수정합니다.");
        params.setWriter("홍길동");
        params.setIdx((long) 1);

        int result = boardMapper.updateBoard(params);
        if (result == 1) {
            BoardDTO board = boardMapper.selectBoardDetail((long) 1);
            try {
                String boardJson = new ObjectMapper().writeValueAsString(board);

                System.out.println("=========================");
                System.out.println(boardJson);
                System.out.println("=========================");

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Test // 삭제
    public void testOfDelete() {
        int result = boardMapper.deleteBoard((long) 1);
        if (result == 1) {
            BoardDTO board = boardMapper.selectBoardDetail((long) 1);
            try {
                String boardJson = new ObjectMapper().writeValueAsString(board);

                System.out.println("=========================");
                System.out.println(boardJson);
                System.out.println("=========================");

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
	public void testSelectList() {
		int boardTotalCount = boardMapper.selectBoardTotalCount();
		if (boardTotalCount > 0) {
			List<BoardDTO> boardList = boardMapper.selectBoardList();
			if (CollectionUtils.isEmpty(boardList) == false) {
				for (BoardDTO board : boardList) {
					System.out.println("=========================");
					System.out.println(board.getTitle());
					System.out.println(board.getContent());
					System.out.println(board.getWriter());
					System.out.println("=========================");
				}
			}
		}
	}

}
