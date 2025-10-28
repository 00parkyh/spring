package com.ssg.membertest.Repository;

import com.ssg.membertest.DTO.Member;
import com.ssg.membertest.VO.MemberVO;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final JdbcTemplate jdbcTemplate; //jdbc 연결 -20251028에 새로 추가 기존 코드랑 다름

    @Autowired
    private final DataSource dataSource;

    @Override
    public void insertMember(MemberVO vo) throws Exception {
        String sql = "insert into member2 values(?,?,?)";
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vo.getMid());
        preparedStatement.setString(2, vo.getPwd());
        preparedStatement.setString(3, vo.getMname());
        preparedStatement.executeUpdate();

    }

    @Override
    public List<MemberVO> selectAllMember() throws Exception {
        String sql = "select * from member2 ";
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        List<MemberVO> list = new ArrayList<>();
        while (resultSet.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .mid(resultSet.getString("mid"))
                    .pwd(resultSet.getString("pwd"))
                    .mname(resultSet.getString("mname"))
                    .build();
            list.add(memberVO);
        }
        return list;
    }

    private static final RowMapper<MemberVO> MEMBER_ROW_MAPPER = new RowMapper<MemberVO>() {

        @Override
        public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            MemberVO member = new MemberVO();
            member.setMid(rs.getString("mid"));
            member.setPwd(rs.getString("pwd"));
            member.setMname(rs.getString("mname"));
            return member;
        }
    };

    @Override
    public int insert(MemberVO member) {
        String sql = "insert into member2 values(?,?,?)";

        return jdbcTemplate.update(sql, member.getMid(), member.getPwd(), member.getMname());
    }

    @Override
    public List<MemberVO> findAll() {
        String sql = "select * from member2 ";

        return jdbcTemplate.query(sql, MEMBER_ROW_MAPPER);
    }


}
