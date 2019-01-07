package com.vladyka.quadrangle.model.logic.wector.difference;

import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;

/**
 * Created by Vladyka Stas
 * on 29.12.2018 at 20:19
 **/
public interface DifferenceCalc  {
    double[] getDifference(Wector wector1, Wector wector2, ProjectionCalc projectionCalc) throws NullReferenceException,
            NotSupportedFunctionException;
}
