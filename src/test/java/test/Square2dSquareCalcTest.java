package test;

import com.vladyka.quadrangle.model.entity.quadrangle.Quadrangle2d;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.square.Rhombus2dSquareCalc;
import com.vladyka.quadrangle.model.logic.quadrangle.square.Square2dSquareCalc;
import com.vladyka.quadrangle.model.logic.quadrangle.square.SquareCalc;
import org.testng.Assert;
import org.testng.annotations.Test;
import static test.Shape2dValidatorImplTest.*;
import static test.Shape2dValidatorImplTest.wectorCalculator;
import static test.Shape2dValidatorImplTest.wectorValidator;

/**
 * Created by Vladyka Stas
 * on 31.12.2018 at 3:00
 **/
public class Square2dSquareCalcTest {
    @Test
    public void testGetSquareFromValidFigure() throws Exception {
        Rhombus2dSquareCalc rhombus2dSquareCalc = new Rhombus2dSquareCalc();
        QuadrangleFigure squareFigure = new Quadrangle2d(square);
        Assert.assertEquals(4.0,rhombus2dSquareCalc.getSquare(squareFigure, shape2dValidator, wectorCalculator, wectorValidator));
    }
    @Test (expectedExceptions = NotSupportedFunctionException.class)
    public void testGetSquareFromInvalidFigure()throws Exception{
        SquareCalc  square2dSquareCalc = new Square2dSquareCalc();
        QuadrangleFigure trapeziumFigure = new Quadrangle2d(trapezium);
        Assert.assertEquals(3.0, square2dSquareCalc.getSquare(trapeziumFigure, shape2dValidator, wectorCalculator, wectorValidator));
    }

    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareFromNullFigure()throws Exception{
        SquareCalc  square2dSquareCalc = new Square2dSquareCalc();
        QuadrangleFigure trapeziumFigure = null;
        square2dSquareCalc.getSquare(trapeziumFigure, shape2dValidator, wectorCalculator, wectorValidator);
    }

    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullShapeValidator()throws Exception{
        SquareCalc  square2dSquareCalc = new Square2dSquareCalc();
        square2dSquareCalc.getSquare(new Quadrangle2d(square), null, wectorCalculator, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullWectorCalculator()throws Exception{
        SquareCalc  square2dSquareCalc = new Square2dSquareCalc();
        square2dSquareCalc.getSquare(new Quadrangle2d(square), shape2dValidator, null, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullWectorValidator()throws Exception{
        SquareCalc  square2dSquareCalc = new Square2dSquareCalc();
        square2dSquareCalc.getSquare(new Quadrangle2d(square), shape2dValidator, wectorCalculator, null);
    }


}