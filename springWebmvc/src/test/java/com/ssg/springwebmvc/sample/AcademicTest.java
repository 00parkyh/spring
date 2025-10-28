package com.ssg.springwebmvc.sample;


import com.ssg.springwebmvc.prof.ClassRoom;
import com.ssg.springwebmvc.prof.Professor;
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

public class AcademicTest {

    @Autowired
    private ClassRoom classRoom;

    @Test
    public void TestAcademic() {
        log.info(classRoom);
        Assertions.assertNotNull(classRoom);
    }

}
