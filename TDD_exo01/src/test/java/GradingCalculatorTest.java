import org.example.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {
    private GradingCalculator calculator;

    @Test
    public void TestGradingCalculatorWhenGetGrade_95_90_TheResult_A(){
        calculator = new GradingCalculator(95,90);
        char resultAwait = 'A';

        char result = calculator.getGrade();

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestGradingCalculatorWhenGetGrade_85_90_TheResult_B(){
        calculator = new GradingCalculator(85,90);
        char resultAwait = 'B';

        char result = calculator.getGrade();

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestGradingCalculatorWhenGetGrade_65_90_TheResult_C(){
        calculator = new GradingCalculator(65,90);
        char resultAwait = 'C';

        char result = calculator.getGrade();

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestGradingCalculatorWhenGetGrade_95_65_TheResult_B(){
        calculator = new GradingCalculator(95,65);
        char resultAwait = 'B';

        char result = calculator.getGrade();

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestGradingCalculatorWhenGetGrade_95_55_TheResult_F(){
        calculator = new GradingCalculator(95,55);
        char resultAwait = 'F';

        char result = calculator.getGrade();

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestGradingCalculatorWhenGetGrade_65_55_TheResult_F(){
        calculator = new GradingCalculator(65,55);
        char resultAwait = 'F';

        char result = calculator.getGrade();

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestGradingCalculatorWhenGetGrade_50_90_TheResult_F(){
        calculator = new GradingCalculator(50,90);
        char resultAwait = 'F';

        char result = calculator.getGrade();

        Assertions.assertEquals(resultAwait, result);
    }
}
