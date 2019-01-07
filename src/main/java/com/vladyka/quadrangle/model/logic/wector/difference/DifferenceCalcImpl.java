package com.vladyka.quadrangle.model.logic.wector.difference;

import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;

/**
 * Created by Vladyka Stas
 * on 29.12.2018 at 20:17
 **/
public class DifferenceCalcImpl implements DifferenceCalc {
    @Override
    public double[] getDifference(Wector wector1, Wector wector2, ProjectionCalc projectionCalc) throws
            NullReferenceException, NotSupportedFunctionException {
        if (projectionCalc == null || wector1==null || wector2==null) {
            throw new NullReferenceException("One of the vectors doesn't exist or type of projection calculator wasn't set");
        }

        double[] wector1projections = projectionCalc.getProjections(wector1);
        double[] wector2projections = projectionCalc.getProjections(wector2);
        double[] wectorSumProjections = new double[wector1projections.length];

        if (wector1projections.length == wector2projections.length) {
            for (int i = 0; i < wector1projections.length; i++) {
                wectorSumProjections[i] = wector1projections[i] - wector2projections[i];
            }
        } else {
            throw new NotSupportedFunctionException("Vectors have different dimensions");
        }

        return wectorSumProjections;
    }
    }

