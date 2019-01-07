package com.vladyka.quadrangle.model.logic.wector.orthogonality;

import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;

public class OrthogonalityValidator2dImpl implements OrthogonalityValidator {
    @Override
    public boolean isOrthogonal(Wector wector1, Wector wector2, ProjectionCalc projectionCalc) throws
            NullReferenceException {
        if (wector1 == null || wector2 == null || projectionCalc == null) {
            return false;
        }
        //Заданные векторы будут ортогональны тогда и только тогда, когда их скалярное произведение
        // будет равняться нулю.
        double[] wector1Projections = projectionCalc.getProjections(wector1);
        double[] wector2Projections = projectionCalc.getProjections(wector2);

        double scalarSum = 0;
        for (int i = 0; i < wector1Projections.length; i++) {
            scalarSum += wector1Projections[i] * wector2Projections[i];
        }

        if (scalarSum == 0) {
            return true;
        }
        return false;
    }
}
