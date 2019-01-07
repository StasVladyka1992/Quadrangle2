package com.vladyka.quadrangle.model.logic.wector.collinearity;

import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;

public interface CollinearityValidator {

    boolean isCollinear(Wector wector1, Wector wector2, ProjectionCalc projectionCalc) throws
            NullReferenceException;

}
