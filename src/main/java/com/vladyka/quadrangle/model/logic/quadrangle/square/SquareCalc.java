package com.vladyka.quadrangle.model.logic.quadrangle.square;

import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.ShapeValidator;
import com.vladyka.quadrangle.model.logic.wector.WectorCalculator;
import com.vladyka.quadrangle.model.logic.wector.WectorValidator;

public interface SquareCalc  {
    double getSquare(QuadrangleFigure quadrangleFigure, ShapeValidator shapeValidator,
                     WectorCalculator wectorCalculator, WectorValidator wectorValidator) throws
            NotSupportedFunctionException, NullReferenceException;

    double roundSquare (double value, int scale);

}
