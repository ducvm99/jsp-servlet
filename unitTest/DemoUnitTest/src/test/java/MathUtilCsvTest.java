import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilCsvTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void test(int a, int b, int result) {
        MathUtil mathUtil = new MathUtil();
        assertEquals(mathUtil.sum(a, b), result);
    }
}
