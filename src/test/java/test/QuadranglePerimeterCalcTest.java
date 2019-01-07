package test;

import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.quadrangle.Quadrangle2d;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.entity.wector.Wector2d;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.perimeter.PerimeterCalc;
import com.vladyka.quadrangle.model.logic.quadrangle.perimeter.QuadranglePerimeterCalc;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc2dImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by Vladyka Stas
 * on 31.12.2018 at 2:15
 **/
public class QuadranglePerimeterCalcTest {
    private static ArrayList<Wector> rectangle = new ArrayList<>();

    static {
        rectangle.add(new Wector2d(new Dot2d(1,1), new Dot2d(1,3)));
        rectangle.add(new Wector2d(new Dot2d(1,3), new Dot2d(6,3)));
        rectangle.add(new Wector2d(new Dot2d(6,3), new Dot2d(6,1)));
        rectangle.add(new Wector2d(new Dot2d(6,1), new Dot2d(1,1)));
    }

    @Test
    public void testCalcPerimeterValidCoordinates() throws Exception {
        PerimeterCalc perimeterCalc = new QuadranglePerimeterCalc();
        WectorLengthCalc wectorLengthCalc = new WectorLengthCalc2dImpl();
        Assert.assertEquals(14.0,perimeterCalc.calcPerimeter(rectangle, wectorLengthCalc));
    }

    @Test (expectedExceptions = NullReferenceException.class)
    public void testCalcPerimeterNoCoordinates() throws Exception{
        PerimeterCalc perimeterCalc = new QuadranglePerimeterCalc();
        WectorLengthCalc wectorLengthCalc = new WectorLengthCalc2dImpl();
        perimeterCalc.calcPerimeter(null, wectorLengthCalc);
    }
    @Test (expectedExceptions = NullReferenceException.class)
    public void testCalcPerimeterNoWectorLengthCalc() throws Exception{
        PerimeterCalc perimeterCalc = new QuadranglePerimeterCalc();
        WectorLengthCalc wectorLengthCalc = new WectorLengthCalc2dImpl();
        perimeterCalc.calcPerimeter(rectangle, null);
    }
}