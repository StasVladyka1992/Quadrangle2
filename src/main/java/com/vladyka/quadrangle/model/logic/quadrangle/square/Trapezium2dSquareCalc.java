package com.vladyka.quadrangle.model.logic.quadrangle.square;

import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.ShapeValidator;
import com.vladyka.quadrangle.model.logic.wector.WectorCalculator;
import com.vladyka.quadrangle.model.logic.wector.WectorValidator;
import com.vladyka.quadrangle.model.logic.wector.collinearity.CollinearityValidator;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Trapezium2dSquareCalc implements SquareCalc {

    @Override
    public double getSquare(QuadrangleFigure quadrangleFigure, ShapeValidator shapeValidator,
                            WectorCalculator wectorCalculator, WectorValidator wectorValidator) throws
            NotSupportedFunctionException, NullReferenceException {

        if (quadrangleFigure ==null || shapeValidator == null || wectorCalculator==null || wectorValidator==null ){
            throw  new NullReferenceException("Can't count square of trapezium with such set of parameters. Some parameters don't exist");
        }

        double square;
        ProjectionCalc projectionCalc = wectorCalculator.getProjectionCalc();
        ArrayList<Wector> wectorsList = quadrangleFigure.getWectorList();
        WectorLengthCalc wectorLengthCalc = wectorCalculator.getWectorLengthCalc();
        CollinearityValidator collinearityValidator = wectorValidator.getCollinearityValidator();

        if (shapeValidator.isTrapezium(quadrangleFigure)) {
            if (collinearityValidator.isCollinear(wectorsList.get(0), wectorsList.get(2), projectionCalc)) {
                // (a+b)/2*h
                double[] heightProjections = projectionCalc.getProjections(wectorsList.get(1));
                square = heightProjections[0] * (wectorLengthCalc.getWectorLength(wectorsList.get(0)) +
                        wectorLengthCalc.getWectorLength(wectorsList.get(2))) / 2;
            } else {
                double[] heightProjections = projectionCalc.getProjections(wectorsList.get(0));
                square = heightProjections[1] * (wectorLengthCalc.getWectorLength(wectorsList.get(1)) +
                        wectorLengthCalc.getWectorLength(wectorsList.get(3))) / 2;
            }
        } else {
            throw new NotSupportedFunctionException("Figure isn't 2d trapezium");
        }
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

