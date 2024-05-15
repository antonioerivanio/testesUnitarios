package tddMockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TddMockioTest {
    @InjectMocks
    private ReportGeneratorService reportGeneratorService;
    @Mock
    private ReportGenerator2 reportGenerator;

    @Captor
    private ArgumentCaptor<ReportEntity> reportCaptor;


    @Test
    public void test() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2016, 11, 25);
        Calendar endDate = Calendar.getInstance();
        endDate.set(9999, 12, 31);
        String reportContent = "Report Content";

        reportGeneratorService.generateReport(startDate.getTime(), endDate.getTime(), reportContent.getBytes());

       verify(reportGenerator).generateReport(reportCaptor.capture());
       ReportEntity report = reportCaptor.getValue();

        System.out.println("Ano "+ report.getStartDate().getYear());
        assertEquals(116, report.getStartDate().getYear());
        System.out.println("Mes "+ report.getEndDate().getMonth());
        assertEquals(0, report.getEndDate().getMonth());
        System.out.println("Date "+ report.getEndDate().getDate());
        assertEquals(31, report.getEndDate().getDate());

        assertEquals("Report Content", new String(report.getContent()));
    }

    @Test
    public void verifyInteractions() {
        Set mockSet = mock(Set.class);
        Set<String> toAdd = new HashSet<String>();
        mockSet.addAll(toAdd);
        mockSet.clear();
        verify(mockSet).addAll(toAdd);
        verify(mockSet).clear();
    }

    @Test
    public void stubMethodCalls() {
        Set mockSet = mock(Set.class);
        when(mockSet.size()).thenReturn(10);
        assertEquals(10, mockSet.size());
    }

    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = spy(list);
        try {
            when(spy.get(0)).thenReturn("foo");
        } catch(IndexOutOfBoundsException e) {
// Expected
        }
        doReturn("foo").when(spy).get(0);
    }

}
