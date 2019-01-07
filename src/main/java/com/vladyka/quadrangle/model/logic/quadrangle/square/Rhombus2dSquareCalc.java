package com.vladyka.quadrangle.model.logic.quadrangle.square;

import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.ShapeValidator;
import com.vladyka.quadrangle.model.logic.wector.WectorCalculator;
import com.vladyka.quadrangle.model.logic.wector.WectorValidator;
import com.vladyka.quadrangle.model.logic.wector.difference.DifferenceCalc;
import com.vladyka.quadrangle.model.logic.wector.difference.DifferenceCalcImpl;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;
import com.vladyka.quadrangle.model.logic.wector.sum.SumCalc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Rhombus2dSquareCalc implements SquareCalc {
    private static final Logger logger = LogManager.getLogger(Rhombus2dSquareCalc.class);

    @Override
    public double getSquare(QuadrangleFigure quadrangleFigure, ShapeValidator shapeValidator,
                            WectorCalculator wectorCalculator, WectorValidator wectorValidator) throws NotSupportedFunctionException, NullReferenceException {
        //Площадь ромба равна половине произведений диагонали
        if (quadrangleFigure ==null || shapeValidator == null || wectorCalculator==null || wectorValidator==null ){
            throw  new NullReferenceException("Can't count square of rhombus with such set of parameters. Some parameters don't exist");
        }

        double square;
        ProjectionCalc projectionCalc = wectorCalculator.getProjectionCalc();
        SumCalc sumCalc = wectorCalculator.getSumCalc();
        ArrayList<Wector> wectorsList = quadrangleFigure.getWectorList();
        WectorLengthCalc wectorLengthCalc = wectorCalculator.getWectorLengthCalc();
        DifferenceCalc differenceCalc = new DifferenceCalcImpl();
        if (shapeValidator.isRhombus(quadrangleFigure)) {
            double[] diagonal1 = sumCalc.getSum(wectorsList.get(0), wectorsList.get(1), projectionCalc);
            double[] diagonal2 = differenceCalc.getDifference(wectorsList.get(1), wectorsList.get(2), projectionCalc);

            square = (wectorLengthCalc.getWectorLength(diagonal1) * wectorLengthCalc.getWectorLength(diagonal2)) / 2;

        } else {
            throw new NotSupportedFunctionException("Figure isn't 2d rhombus");
        }
        logger.info("Calculation rhombus square is done");
        square = roundSquare(square, 3);
        return square;
    }

    @Override
    public double roundSquare(double value, int scale) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
