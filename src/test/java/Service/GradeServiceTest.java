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
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.spy;

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
    public void insertOnceTest(){
        grade.setGrade("A0");
        gradeRepository.insertGrade(grade);
        List<Grade> grades =  gradeRepository.getGrades();
        assertThat(grades.size(),is(1));
    }



}