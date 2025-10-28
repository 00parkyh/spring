package com.ssg.homework_board.service;

import com.ssg.homework_board.dao.PostDAO;
import com.ssg.homework_board.dao.PostDAOImpl;
import com.ssg.homework_board.domain.PostVO;
import com.ssg.homework_board.dto.PostDTO;
import com.ssg.homework_board.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class PostService {
    // 싱글톤 패턴 적용
    private static final PostService INSTANCE = new PostService();
    private final PostDAO dao;
    private ModelMapper modelMapper;

    public PostService() {
        this.dao = new PostDAOImpl();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public static PostService getInstance() {
        return INSTANCE;
    }

    public List<PostDTO> getList() {
        List<PostVO> volist = dao.findAll();
        log.info("voList-------------");
        log.info(volist);

        List<PostDTO> dtoList = volist.stream().map(
                vo -> modelMapper.map(vo,PostDTO.class)).collect(Collectors.toList());

        return dtoList;
    };

    public PostDTO getDetail(long id) {return null;};                  // 조회수 증가 포함

    public long write(PostDTO post) throws IllegalArgumentException {
        if (post.getTitle() == null ) {
            throw new IllegalArgumentException("제목을 작성해주세요.");
        } else if (post.getTitle().trim().length() < 2 || post.getTitle().trim().length() > 200) {
            throw new IllegalArgumentException("제목의 길이는 2~200자 사이입니다.");
        } else if (post.getWriter() == null) {
            throw new IllegalArgumentException("작성자를 작성해주세요.");
        }else if (post.getWriter().trim().length() <=1 || post.getWriter().trim().length() > 50) {
            throw new IllegalArgumentException("작성자 길이는 1~50자 사이입니다.");
        } else if (post.getContent() == null) {
            throw new IllegalArgumentException("내용을 작성해주세요.");
        } else if (post.getContent().trim().length() < 5 ) {
            throw new IllegalArgumentException("내용의 길이는 5자 이상입니다.");
        } else if (post.getPassphrase() == null) {
            throw new IllegalArgumentException("비밀번호는 필수 입니다.");
        } else if (post.getPassphrase().trim().length() < 4 || post.getPassphrase().trim().length() > 20) {
            throw new IllegalArgumentException("비밀번호는 4 ~ 20 사이입니다.");
        }

        PostVO vo = modelMapper.map(post, PostVO.class);
        return dao.save(vo);
    };                    // 검증 + 저장
    public void edit(PostDTO post, String passphrase) {

    };  // 비번검증 + 수정
    public void remove(long id, String passphrase) {

    };     // 비번검증 + 삭제
}