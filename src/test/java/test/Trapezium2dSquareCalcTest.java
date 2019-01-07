package test;

import com.vladyka.quadrangle.model.entity.quadrangle.Quadrangle2d;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.square.SquareCalc;
import com.vladyka.quadrangle.model.logic.quadrangle.square.Trapezium2dSquareCalc;
import org.testng.Assert;
import org.testng.annotations.Test;

import static test.Shape2dValidatorImplTest.*;
import static test.Shape2dValidatorImplTest.wectorCalculator;
import static test.Shape2dValidatorImplTest.wectorValidator;

/**
 * Created by Vladyka Stas
 * on 31.12.2018 at 3:02
 **/
public class Trapezium2dSquareCalcTest {
    @Test
    public void testGetSquareFromRectangleTrapezium() throws Exception {
        Trapezium2dSquareCalc trapezium2dSquareCalc = new Trapezium2dSquareCalc();
        QuadrangleFigure rectangleTrapeziumFigure = new Quadrangle2d(rectangleTrapezium);
        Assert.assertEquals(8.0,trapezium2dSquareCalc.getSquare(rectangleTrapeziumFigure, shape2dValidator, wectorCalculator, wectorValidator));
    }

    @Test
    public void testGetSquareFromNotRectangleTrapezium() throws Exception {
        Trapezium2dSquareCalc trapezium2dSquareCalc = new Trapezium2dSquareCalc();
        QuadrangleFigure trapeziumFigure = new Quadrangle2d(trapezium);
        Assert.assertEquals(7.0,trapezium2dSquareCalc.getSquare(trapeziumFigure, shape2dValidator, wectorCalculator, wectorValidator));
    }

    @Test (expectedExceptions = NotSupportedFunctionException.class)
    public void testGetSquareFromInvalidFigure()throws Exception{
        Trapezium2dSquareCalc trapezium2dSquareCalc = new Trapezium2dSquareCalc();
        QuadrangleFigure parallelogramFigure = new Quadrangle2d(parallelogram);
        QuadrangleFigure rectangleFigure = new Quadrangle2d(rectangle);
        Assert.assertEquals(3.0, trapezium2dSquareCalc.getSquare(parallelogramFigure, shape2dValidator, wectorCalculator, wectorValidator));
        Assert.assertEquals(3.0, trapezium2dSquareCalc.getSquare(rectangleFigure, shape2dValidator, wectorCalculator, wectorValidator));
    }

    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareFromNullFigure()throws Exception{
        Trapezium2dSquareCalc trapezium2dSquareCalc = new Trapezium2dSquareCalc();
        QuadrangleFigure parallelogramFigure = null;
        trapezium2dSquareCalc.getSquare(parallelogramFigure, shape2dValidator, wectorCalculator, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullShapeValidator()throws Exception{
        SquareCalc trapezium2dSquareCalc = new Trapezium2dSquareCalc();
        trapezium2dSquareCalc.getSquare(new Quadrangle2d(square), null, wectorCalculator, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullWectorCalculator()throws Exception{
        SquareCalc trapezium2dSquareCalc = new Trapezium2dSquareCalc();
        trapezium2dSquareCalc.getSquare(new Quadrangle2d(square), shape2dValidator, null, wectorValidator);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testGetSquareWithNullWectorValidator()throws Exception{
        SquareCalc trapezium2dSquareCalc = new Trapezium2dSquareCalc();
        trapezium2dSquareCalc.getSquare(new Quadrangle2d(square), shape2dValidator, wectorCalculator, null);
    }
}