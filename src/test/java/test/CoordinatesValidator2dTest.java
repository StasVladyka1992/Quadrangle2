package test;

import com.vladyka.quadrangle.util.coordinate_validator.CoordinatesValidator;
import com.vladyka.quadrangle.util.coordinate_validator.CoordinatesValidator2d;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Vladyka Stas
 * on 01.01.2019 at 22:07
 **/
public class CoordinatesValidator2dTest {
    @DataProvider (name="validCoordinates")
    public Object [][] getCoordinates(){
      return new Object[][]{
              {"1.0 1.0 2.04141 3.0141 4.0 4.0 37667.0 2.0"},
              {"-1.222 1.0 2.45235 330.4414 141.11 -113.40 99.0 10.1"},
              {"-2.0 -13055.66 -1.0 -1.0 -20.2 -20.5 -1.5 -66666.66666"}
      };
    }
    @DataProvider (name="invalidCoordinates")
    public Object [][] getInvalidCoordinates(){
        return new Object[][]{
                {"111111.111111 1.0 2.0 1.0 3.0 4.0 8.9 9.0"},
                {"111,34 1.0 2.0 1.0 3.0 4.0 8.9 9.0"},
                {"1.0 2.0 1.0 3.0 4.0 8.9 9.0"},
                {"1.0 2.0 1.0 3.0 4.0 8.9 9.0 8.5 9.0"},
                {"1.0 2.0 1.0 3.0 4.0 8.9 9ad.0 7.0"},
                {null}
        };
    }
    @Test (dataProvider = "validCoordinates")
    public void testValidateValidCoordinates(String coordinates) throws Exception {
        CoordinatesValidator coordinatesValidator = new CoordinatesValidator2d();
        Assert.assertTrue(coordinatesValidator.validateCoordinates(coordinates));
    }
    @Test (dataProvider = "invalidCoordinates")
    public void testInvalidCoordinates (String coordinates) throws Exception{
        CoordinatesValidator coordinatesValidator = new CoordinatesValidator2d();
        Assert.assertFalse(coordinatesValidator.validateCoordinates(coordinates));
    }

}