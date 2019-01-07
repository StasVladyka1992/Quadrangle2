package com.vladyka.quadrangle.model.logic.wector.sum;

import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.entity.wector.Wector2d;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc2dImpl;

import java.util.Arrays;

public class SumCalcImlp implements SumCalc {

    public double[] getSum(Wector wector1, Wector wector2, ProjectionCalc projectionCalc) throws
            NullReferenceException, NotSupportedFunctionException {
        if (projectionCalc == null || wector1==null || wector2==null) {
            throw new NullReferenceException("One of the vectors doesn't exist or type of projection calculator wasn't set");
        }

        double[] wector1projections = projectionCalc.getProjections(wector1);
        double[] wector2projections = projectionCalc.getProjections(wector2);
        double[] wectorSumProjections = new double[wector1projections.length];

        if (wector1projections.length == wector2projections.length) {
            for (int i = 0; i < wector1projections.length; i++) {
                wectorSumProjections[i] = wector1projections[i] + wector2projections[i];
            }
        } else {
            throw new NotSupportedFunctionException("Vectors have different dimensions");
        }

        return wectorSumProjections;
    }

}

