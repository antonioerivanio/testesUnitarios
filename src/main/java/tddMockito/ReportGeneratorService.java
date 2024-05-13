package tddMockito;

import java.util.Date;

public class ReportGeneratorService {
    private ReportGenerator2 reportGenerator;

    /**
     * Generate report.
     * @param startDate start date
     * @param endDate end date
     * @param content report content
     */
    public void generateReport(Date startDate, Date endDate, byte[] content) {
        ReportEntity report = new ReportEntity();
        report.setContent(content);
        report.setStartDate(startDate);
        report.setEndDate(endDate);
        //reportGenerator.generateReport(report);
    }

}
