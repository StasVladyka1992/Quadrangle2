package com.vladyka.quadrangle.model.logic.quadrangle.square;

import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.ShapeValidator;
import com.vladyka.quadrangle.model.logic.wector.WectorCalculator;
import com.vladyka.quadrangle.model.logic.wector.WectorValidator;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Square2dSquareCalc implements SquareCalc {
    private static final Logger logger = LogManager.getLogger(Square2dSquareCalc.class);

    @Override

    public double getSquare(QuadrangleFigure quadrangleFigure, ShapeValidator shapeValidator,
                            WectorCalculator wectorCalculator, WectorValidator wectorValidator) throws NotSupportedFunctionException,
            NullReferenceException {

        if (quadrangleFigure == null || shapeValidator == null || wectorCalculator == null || wectorValidator == null) {
            throw new NullReferenceException("Can't count square of square with such set of parameters. Some parameters don't exist");
        }

        double square;
        ArrayList<Wector> wectorsList = quadrangleFigure.getWectorList();
        WectorLengthCalc wectorLengthCalc = wectorCalculator.getWectorLengthCalc();

        if (shapeValidator.isSquare(quadrangleFigure)) {
            double wectorLength = wectorLengthCalc.getWectorLength(wectorsList.get(0));
            square = Math.pow(wectorLength, 2);
        } else {
            throw new NotSupportedFunctionException("Figure isn't 2d square");
        }

        logger.info("Calculation square square is done");
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
