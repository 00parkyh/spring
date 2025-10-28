package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@Log4j2
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class FoodTest {

    @Autowired
    private Restaurant restaurant;

    @Test
    public void TestRestaurant() {
        log.info(restaurant);
        Assertions.assertNotNull(restaurant);
        //Assertions 는 JUnit 같은 테스트 프레임웤크에서 사용하는 검증 도구 입니다.
        //내 코드가 예상대로 동작하는지 확인하는 심판 입니다.

    }
}
