package Domain;

import org.junit.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;

class GradeTest {

    @Mock
    Grade grade;

    @Before
    public void testCreateGradeObject(){

    }

    @Test
    public void testGetGrade(){

        grade.getGrade();
    }

}