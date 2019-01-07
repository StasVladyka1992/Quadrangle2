package test;

import com.vladyka.quadrangle.model.entity.quadrangle.Quadrangle2d;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.square.Rhombus2dSquareCalc;
import org.testng.Assert;
import org.testng.annotations.Test;
import static test.Shape2dValidatorImplTest.*;

/**
 * Created by Vladyka Stas
 * on 31.12.2018 at 2:31
 **/
public class Rhombus2dSquareCalcTest {

    @Test
    public void testGetSquareFromSquare() throws Exception {
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        QuadrangleFigure squareFigure = new Quadrangle2d(square);
        Assert.assertEquals(4.0,rhombus2dSquareCalc.getSquare(squareFigure, shape2dValidator, wectorCalculator, wectorValidator));
    }

    @Test
    public void testGetSquareFromRhombusNotSquare() throws Exception {
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        QuadrangleFigure rhombusFigure = new Quadrangle2d(rhombus);
        Assert.assertEquals(3.0, rhombus2dSquareCalc.getSquare(rhombusFigure, shape2dValidator, wectorCalculator, wectorValidator));
    }

    @Test (expectedExceptions = NotSupportedFunctionException.class)
    public void testGetSquareFromInvalidFigure()throws Exception{
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        QuadrangleFigure trapeziumFigure = new Quadrangle2d(trapezium);
        rhombus2dSquareCalc.getSquare(trapeziumFigure, shape2dValidator, wectorCalculator, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareFromNullFigure()throws Exception{
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        rhombus2dSquareCalc.getSquare(null, shape2dValidator, wectorCalculator, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullShapeValidator()throws Exception{
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        rhombus2dSquareCalc.getSquare(new Quadrangle2d(rhombus), null, wectorCalculator, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullWectorCalculator()throws Exception{
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        rhombus2dSquareCalc.getSquare(new Quadrangle2d(rhombus), shape2dValidator, null, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullWectorValidator()throws Exception{
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        rhombus2dSquareCalc.getSquare(new Quadrangle2d(rhombus), shape2dValidator, wectorCalculator, null);
    }
}