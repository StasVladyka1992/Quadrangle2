package test;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.quadrangle.Quadrangle2d;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.entity.wector.Wector2d;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.Shape2dValidatorImpl;
import com.vladyka.quadrangle.model.logic.wector.WectorCalculator;
import com.vladyka.quadrangle.model.logic.wector.WectorValidator;
import com.vladyka.quadrangle.model.logic.wector.collinearity.CollinearityValidator2dImpl;
import com.vladyka.quadrangle.model.logic.wector.difference.DifferenceCalcImpl;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc2dImpl;
import com.vladyka.quadrangle.model.logic.wector.orthogonality.OrthogonalityValidator2dImpl;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc2dImpl;
import com.vladyka.quadrangle.model.logic.wector.sum.SumCalcImlp;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by Vladyka Stas
 * on 29.12.2018 at 15:27
 **/
public class Shape2dValidatorImplTest {
    public static WectorCalculator wectorCalculator = new WectorCalculator(new SumCalcImlp(), new ProjectionCalc2dImpl(),
            new WectorLengthCalc2dImpl(), new DifferenceCalcImpl());
    public static WectorValidator wectorValidator = new WectorValidator(new CollinearityValidator2dImpl(),
            new OrthogonalityValidator2dImpl());
    public static Shape2dValidatorImpl shape2dValidator = new Shape2dValidatorImpl(wectorValidator, wectorCalculator);
    public static ArrayList<Wector> rhombus = new ArrayList<>();
    public static ArrayList<Wector> parallelogram = new ArrayList<>();
    public static ArrayList<Wector> square = new ArrayList<>();
    public static ArrayList<Wector> trapezium = new ArrayList<>();
    public static ArrayList<Wector> rectangle = new ArrayList<>();
    public static ArrayList<Wector> rectangleTrapezium = new ArrayList<>();

    static {
            //rhombus
            rhombus.add(new Wector2d(new Dot2d(1,1), new Dot2d(2,3)));
            rhombus.add(new Wector2d(new Dot2d(2,3), new Dot2d(4,4)));
            rhombus.add(new Wector2d(new Dot2d(4,4), new Dot2d(3,2)));
            rhombus.add(new Wector2d(new Dot2d(3,2), new Dot2d(1,1)));

        //parallelogram, not rhombus
        parallelogram.add(new Wector2d(new Dot2d(1,1), new Dot2d(2,3)));
        parallelogram.add(new Wector2d(new Dot2d(2,3), new Dot2d(5,3)));
        parallelogram.add(new Wector2d(new Dot2d(5,3), new Dot2d(4,1)));
        parallelogram.add(new Wector2d(new Dot2d(4,1), new Dot2d(1,1)));

        //square
        square.add(new Wector2d(new Dot2d(1,1), new Dot2d(1,3)));
        square.add(new Wector2d(new Dot2d(1,3), new Dot2d(3,3)));
        square.add(new Wector2d(new Dot2d(3,3), new Dot2d(3,1)));
        square.add(new Wector2d(new Dot2d(3,1), new Dot2d(1,1)));

        //trapezium
        trapezium.add(new Wector2d(new Dot2d(1,1), new Dot2d(2,3)));
        trapezium.add(new Wector2d(new Dot2d(2,3), new Dot2d(4,3)));
        trapezium.add(new Wector2d(new Dot2d(4,3), new Dot2d(6,1)));
        trapezium.add(new Wector2d(new Dot2d(6,1), new Dot2d(1,1)));

        //rectangle trapezium
        rectangleTrapezium.add(new Wector2d(new Dot2d(1,1), new Dot2d(1,3)));
        rectangleTrapezium.add(new Wector2d(new Dot2d(1,3), new Dot2d(4,3)));
        rectangleTrapezium.add(new Wector2d(new Dot2d(4,3), new Dot2d(6,1)));
        rectangleTrapezium.add(new Wector2d(new Dot2d(6,1), new Dot2d(1,1)));

        //rectangle
        rectangle.add(new Wector2d(new Dot2d(1,1), new Dot2d(1,3)));
        rectangle.add(new Wector2d(new Dot2d(1,3), new Dot2d(6,3)));
        rectangle.add(new Wector2d(new Dot2d(6,3), new Dot2d(6,1)));
        rectangle.add(new Wector2d(new Dot2d(6,1), new Dot2d(1,1)));
    }

    @DataProvider(name = "dotsOnLine")
    public Object[][] createData1() {
        return new Object[][]{
                {new Dot2d(1, 1), new Dot2d(2, 2), new Dot2d(3, 3)}
        };
    }
    @DataProvider(name = "dotsNotOnLine")
    public Object[][] createData2() {
        return new Object[][]{
                {new Dot2d(1, 1), new Dot2d(2, 1), new Dot2d(3, 3)}
        };
    }

    @Test(dataProvider = "dotsOnLine")
    public void testIsThreeDotsOnLineValidDots(Dot[] dots) throws Exception {
        Assert.assertTrue(shape2dValidator.isThreeDotsOnLine(dots[0], dots[1], dots[2]));
    }
    @Test(dataProvider = "dotsNotOnLine")
    public void testIsThreeDotsOnLineInvalidDots(Dot[] dots) throws Exception {
        Assert.assertFalse(shape2dValidator.isThreeDotsOnLine(dots[0], dots[1], dots[2]));
    }

    @DataProvider(name = "validDotsForQuadrangle")
    public Object[][] getValidDots() {
        return new Object[][]{
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(1, 3), new Dot2d(3, 3), new Dot2d(3, 1)}},//square
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(2, 3), new Dot2d(4, 4), new Dot2d(3, 2)}},//rhombus
                {new Dot2d[]{new Dot2d(2, 1), new Dot2d(2, 3), new Dot2d(4, 3), new Dot2d(6, 1)}},//trapezium
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(1, 3), new Dot2d(3, 2), new Dot2d(2, 1)}}, // bulging quadrangle
                // but neither rhombus nor square, trapezium, parallelogram
                {new Dot2d[]{new Dot2d(1, 2), new Dot2d(3, 2), new Dot2d(2, 3), new Dot2d(2, 1)}}//not bulging
                // quadrangle
        };
    }
    @DataProvider(name = "invalidDotsForQuadrangle")
    public Object[][] getInvalidDots() {
        return new Object[][]{
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(2, 1), new Dot2d(2, 2), new Dot2d(3, 3)}} //not a quadrangle
        };
    }
    @Test(dataProvider = "validDotsForQuadrangle")
    public void testIsQuadrangleValidDots(Dot[] dots) throws Exception {
        Assert.assertTrue(shape2dValidator.isQuadrangle(dots));
    }
    @Test(dataProvider = "invalidDotsForQuadrangle")
    public void testIsQuadrangleInvalidDots(Dot[] dots) throws Exception {
        Assert.assertFalse(shape2dValidator.isQuadrangle(dots));
    }

    @DataProvider (name = "parallelogramShapes")
    public Object [][] getParallelogramShape(){

        return  new Object[][] {
                {new Quadrangle2d(square)},
                {new Quadrangle2d(rhombus)},
                {new Quadrangle2d(rectangle)}
        };
    }
    @DataProvider (name = "notParallelogramShapes")
    public Object [][] getNotParallelogramShape(){
        return  new Object[][] {
                {new Quadrangle2d(trapezium)}
        };
    }
    @Test (dataProvider = "parallelogramShapes")
    public void testIsValidParallelogram(QuadrangleFigure quadrangleFigure) throws Exception {
        Assert.assertTrue(shape2dValidator.isParallelogram(quadrangleFigure));
    }
    @Test (dataProvider = "notParallelogramShapes")
        public void textIsInvalidParallelogram(QuadrangleFigure quadrangleFigure) throws Exception{
        Assert.assertFalse(shape2dValidator.isParallelogram(quadrangleFigure));
    }

    @DataProvider (name = "rhombusShapes")
    public Object[] [] getRhombusShapes(){
        return  new Object[][] {
                {new Quadrangle2d(rhombus)},
                {new Quadrangle2d(square)}
        };
    }
    @DataProvider (name = "notRhombusShapes")
    public Object[] [] getNotRhombusShapes(){
        return  new Object[][] {
                {new Quadrangle2d(trapezium)},
                {new Quadrangle2d(parallelogram)},
                {new Quadrangle2d(rectangle)}
        };
    }
    @Test (dataProvider = "rhombusShapes")
    public void testIsValidRhombus(QuadrangleFigure quadrangleFigure) throws Exception {
        Assert.assertTrue(shape2dValidator.isRhombus(quadrangleFigure));
    }
    @Test (dataProvider = "notRhombusShapes")
    public void testIsInvalidRhombus(QuadrangleFigure quadrangleFigure) throws Exception {
        Assert.assertFalse(shape2dValidator.isRhombus(quadrangleFigure));
    }

    @DataProvider (name = "trapeziumShapes")
    public Object[] [] getTrapeziumShapes(){
        return new Object[][]{
                {new Quadrangle2d(trapezium)},
                {new Quadrangle2d(rectangleTrapezium)},
        };
    }
    @DataProvider (name = "notTrapeziumShapes")
    public Object[] [] getNotTrapeziumShapes(){
        return new Object[][]{
                {new Quadrangle2d(rhombus)},
                {new Quadrangle2d(rectangle)},
                {new Quadrangle2d(parallelogram)}
        };
    }
    @Test (dataProvider = "trapeziumShapes")
    public void testIsValidTrapezium(QuadrangleFigure quadrangleFigure) throws Exception {
        Assert.assertTrue(shape2dValidator.isTrapezium(quadrangleFigure));
    }
    @Test (dataProvider = "notTrapeziumShapes")
    public void testIsInvalidTrapezium(QuadrangleFigure quadrangleFigure) throws Exception {
        Assert.assertFalse(shape2dValidator.isTrapezium(quadrangleFigure));
    }


    @DataProvider (name = "squareShapes")
    public Object [] [] getSquareShapes(){
        return new Object[][]{
                {new Quadrangle2d(square)}
        };
    }
    @DataProvider (name = "notSquareShapes")
    public Object [] [] getNotSquareShapes(){
        return new Object[][]{
                {new Quadrangle2d(trapezium)},
//                {new Quadrangle2d(rectangle)},
                {new Quadrangle2d(parallelogram)},
                {new Quadrangle2d(rhombus)},
        };
    }
    @Test (dataProvider = "squareShapes")
    public void testIsValidSquare(QuadrangleFigure quadrangleFigure) throws Exception {
        Assert.assertTrue(shape2dValidator.isSquare(quadrangleFigure));
    }
    @Test (dataProvider = "notSquareShapes")
    public void testIsInvalidSquare(QuadrangleFigure quadrangleFigure) throws Exception {
        Assert.assertFalse(shape2dValidator.isSquare(quadrangleFigure));
    }





}