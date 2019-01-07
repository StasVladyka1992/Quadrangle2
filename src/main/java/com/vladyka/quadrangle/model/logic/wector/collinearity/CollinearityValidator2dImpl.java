package com.vladyka.quadrangle.model.logic.wector.collinearity;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;

public class CollinearityValidator2dImpl implements CollinearityValidator {

    @Override
    public boolean isCollinear(Wector wector1, Wector wector2, ProjectionCalc projectionCalc)throws
            NullReferenceException {
        if (wector1 == null || wector2 == null || projectionCalc == null) {
            return false;
        }
        double[] wector1Projection = projectionCalc.getProjections(wector1);
        double[] wector2Projection = projectionCalc.getProjections(wector2);
        return wector1Projection[0] * wector2Projection[1]
                == wector1Projection[1] * wector2Projection[0];
    }
}


