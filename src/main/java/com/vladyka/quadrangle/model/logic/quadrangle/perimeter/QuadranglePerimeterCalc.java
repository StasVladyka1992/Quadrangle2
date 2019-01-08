package com.vladyka.quadrangle.model.logic.quadrangle.perimeter;


import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;


import java.math.BigDecimal;
import java.util.ArrayList;

public class QuadranglePerimeterCalc implements PerimeterCalc {

    @Override
    public double calcPerimeter(ArrayList<Wector> wectorsList, WectorLengthCalc wectorLengthCalc) throws NullReferenceException{
        if (wectorsList == null || wectorLengthCalc==null|| wectorsList.size()!=4) {
            throw new NullReferenceException ("Not enough data to calculate perimeter");
        }
        double perimeter = 0;
        double[] sideLengths = wectorLengthCalc.getWectorLengths(wectorsList);
        for (int i = 0; i <sideLengths.length ; i++) {
            perimeter+=sideLengths[i];
        }

        perimeter = roundPerimeter(perimeter, 3);

        return perimeter;
    }

    @Override
    public double roundPerimeter(double value, int scale) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
