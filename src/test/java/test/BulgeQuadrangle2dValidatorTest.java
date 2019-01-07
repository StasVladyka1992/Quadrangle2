package test;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.logic.quadrangle.bulge.BulgeQuadrangle2dValidator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Vladyka Stas
 * on 19.12.2018 at 1:47
 **/
public class BulgeQuadrangle2dValidatorTest {

    private static BulgeQuadrangle2dValidator bulgeQuadrangle2dValidator = new BulgeQuadrangle2dValidator();


    @DataProvider(name = "validCoordinates")
    public Object[][] createData1() {
        return new Object[][]{
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(1, 3), new Dot2d(3, 3), new Dot2d(3, 1)}},//square
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(2, 3), new Dot2d(4, 4), new Dot2d(3, 2)}},//rhombus
                {new Dot2d[]{new Dot2d(2, 1), new Dot2d(2, 3), new Dot2d(4, 3), new Dot2d(6, 1)}},//trapezium
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(1, 3), new Dot2d(3, 2), new Dot2d(2, 1)}}//quadrangle
                //(not rhombus, not parallelogram, not trapezium, not square)
        };
    }

    @DataProvider(name = "invalidCoordinates")
    public Object[][] createData2() {
        return new Object[][]{
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(2, 3), new Dot2d(3, 3), new Dot2d(1, 7)}},
                {new Dot2d[]{new Dot2d(1, 1), new Dot2d(2, 3), new Dot2d(3, 3), new Dot2d(4, 6)}},
                {new Dot2d[]{new Dot2d(1, 2), new Dot2d(3, 2), new Dot2d(2, 3), new Dot2d(2, 1)}},
                {null}
        };
    }

    @Test(dataProvider = "validCoordinates")
    public void testIsBulgingValidCoordinates(Dot [] dots) throws Exception {
        Assert.assertTrue(bulgeQuadrangle2dValidator.isBulging(dots));
    }

    @Test(dataProvider = "invalidCoordinates")
    public void testIsBulgingUnvalidCoordinates (Dot [] dots) throws Exception {
        Assert.assertFalse(bulgeQuadrangle2dValidator.isBulging(dots));
    }






}

