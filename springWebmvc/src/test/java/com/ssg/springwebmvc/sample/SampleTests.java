package com.ssg.springwebmvc.sample;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class) // Junit 버전에서 spring-test 이용하기 위한 설정 어노테이션
// 스프링의 설정 정보를 로딩하기 위한
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class SampleTests {
    @Autowired // 스프링에서 사용하는 의존성 주입 어노테이션
    private SampleService sampleService;
    @Autowired
    private DataSource dataSource;
    // 만일 지정된 빈이 존대한다면 이곳에 주입해 주기를 원해요~

    @Test
    public void testSampleService(){
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void TestDataSource() throws Exception{
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);

        connection.close();
    }
}
