package com.ssg.homework_board.dao;

import com.ssg.homework_board.domain.PostVO;
import com.ssg.homework_board.util.DBUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDAOImpl implements PostDAO {

    @Override
    public List<PostVO> findAll() {
        String sql = "select * from board_post";
        List<PostVO> list = new ArrayList<>();

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PostVO post = PostVO.builder()
                        .post_id(rs.getInt("post_id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .created_at(rs.getTimestamp("created_at").toLocalDateTime())
                        .build();
                list.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean countAll() {
        return false;
    }

    @Override
    public Optional<PostVO> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long save(PostVO post) {
        String sql = "insert into board_post (title, content, writer, passphrase) VALUES (?, ?, ?, ?)";

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getWriter());
            ps.setString(4, post.getPassphrase());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public boolean update(PostVO post) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean checkPassphrase(long id, String passphrase) {
        return false;
    }
}
