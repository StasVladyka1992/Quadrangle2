package com.vladyka.quadrangle.model.logic.quadrangle.square;

import com.vladyka.quadrangle.model.entity.quadrangle.*;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.ShapeValidator;


public class SquareCalcFactory {

    public SquareCalc getSquareCalculator(QuadrangleFigure quadrangleFigure, ShapeValidator shapeValidator) throws
            NotSupportedFunctionException {
        if (shapeValidator.isTrapezium(quadrangleFigure)) {
            return new Trapezium2dSquareCalc();
        } else if (shapeValidator.isSquare(quadrangleFigure)) {
            return new Square2dSquareCalc();
        } else if (shapeValidator.isRhombus(quadrangleFigure)) {
            return new Rhombus2dSquareCalc();
        } else
            throw new NotSupportedFunctionException("Figure doesn't belong to trapezium2dsquare2d, rhombus2d or square2d");
    }
}
