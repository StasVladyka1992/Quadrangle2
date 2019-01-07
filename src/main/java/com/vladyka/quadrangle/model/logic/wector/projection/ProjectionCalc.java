package com.vladyka.quadrangle.model.logic.wector.projection;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

public interface ProjectionCalc {
    double[] getProjections(Wector w) throws NullReferenceException;
    double[] getProjections(Dot dot1, Dot dot2) throws NullReferenceException;
}
