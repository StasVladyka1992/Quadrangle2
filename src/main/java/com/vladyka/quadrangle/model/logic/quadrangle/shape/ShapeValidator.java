package com.vladyka.quadrangle.model.logic.quadrangle.shape;


import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;


import java.util.ArrayList;

public interface ShapeValidator {
    boolean isQuadrangle(Dot[] dots);

    boolean isParallelogram(QuadrangleFigure quadrangleFigure) throws NotSupportedFunctionException;

    boolean isRhombus(QuadrangleFigure quadrangleFigure) throws NotSupportedFunctionException;

    boolean isTrapezium(QuadrangleFigure quadrangleFigure) throws NotSupportedFunctionException ;

    boolean isSquare(QuadrangleFigure quadrangleFigure) throws NotSupportedFunctionException;


}
