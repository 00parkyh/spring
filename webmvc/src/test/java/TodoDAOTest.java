import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTest {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testTime2() throws Exception {
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVo vo = TodoVo.builder()
                .title("Sample2 Title2 todo...")
                .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(vo);
    }
    @Test
    public void testselectAll() throws Exception {
        List<TodoVo> list = todoDAO.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() throws Exception {
        TodoVo vo = todoDAO.selectOne(2L);
        System.out.println(vo);
    }

    @Test
    public void testDelete() throws Exception {
        todoDAO.deleteOne(2L);
    }

    @Test
    public void testUpdate() throws Exception {
        TodoVo vo = TodoVo.builder()
                .tno(1L)
                .title("update title")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        todoDAO.updateOne(vo);
    }
}
