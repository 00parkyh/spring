package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor    //생성자 주입 방식
public class SampleService {

    @Autowired
    @Qualifier("event")
    private SampleDAO sampleDAO;
}
//스프링 컨테이너를 사용하는 이유 : 객체 를 대신 관리해주기 때문이다.
// 클래스를 빈 (Bean)으로 만드는 이유는 이거 객체로 만들어서 컨테이너에 보관해줘! 라고 요청하는것과 같다.
// bean 파일로 만들기 위해서는 @Component 사용해도 되고 @Service 를 사용해도 된다.
//@Autowired 는 스프링 컨테이너에게 "이 변수에 알맞은 빈(Bean)을 찾아서 자동으로 연결(주입)해 주세요."라고 요청하는 어노테이션입니다.
//@Autowired 가 성공적으로 동작하려면 두 대상이 모두 빈(Bean)이어야 합니다.
