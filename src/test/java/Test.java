import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    @ParameterizedTest
    @CsvFileSource(resources = "/bill.csv")
    void test_csv_file_source(int time, String bill) {
        assertEquals(bill, new Bill().check(time));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/bill2.csv")
    void test2_csv_file_source(int startYear, int startMouth, int startDay, int startHour, int startMinute,
                               int endYear, int endMouth, int endDay, int endHour, int endMinute,
                               boolean isConvert, String bill) {
        assertEquals(bill, new Bill().check(startYear, startMouth, startDay, startHour, startMinute,
                endYear, endMouth, endDay, endHour, endMinute, isConvert));
    }

}
