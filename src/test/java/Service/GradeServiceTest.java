package Service;

import Domain.Grade;
import Repository.GradeRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Spy
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Mock
    Grade grade;

    @Test
    public void setGradeTest(){
        grade.setGrade("A0");
        verify(grade,times(1)).setGrade(anyString());

    }

    @Test
    public void getGradeTest(){

        assertThat(gradeRepository.getGrades(), instanceOf(List.class));
    }

    @Test
    public void insertOnceTest(){
        grade.setGrade("A0");
        gradeRepository.insertGrade(grade);
        List<Grade> grades =  gradeRepository.getGrades();
        assertThat(grades.size(),is(1));
    }

    @Test
    public void upperCaseTest() {
        Grade grade = new Grade("a+", null, 0);
        assertTrue(Character.isUpperCase(grade.getGrade().charAt(0)));
    }

    @Test
    public void setCreditTest(){
        Grade grade1 = spy(Grade.class);
        grade1.setCredit(3);
        assertTrue(grade1.getCredit()>=0);
    }

    @Test
    public void calculateCurrentGPA(){

        gradeRepository.insertGrade(new Grade("A+", "sub1", 3));
        gradeRepository.insertGrade(new Grade("A+", "sub2", 3));
        assertThat(gradeService.calculateGPA(), is(4.5));
    }

}