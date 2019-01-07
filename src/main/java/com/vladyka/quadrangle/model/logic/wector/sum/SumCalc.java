package com.vladyka.quadrangle.model.logic.wector.sum;

import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;

public interface SumCalc {
    double[] getSum(Wector wector1, Wector wector2, ProjectionCalc projectionCalc) throws NullReferenceException,
            NotSupportedFunctionException;
}
