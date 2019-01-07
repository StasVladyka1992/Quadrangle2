package com.vladyka.quadrangle.model.logic.wector.length;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

import java.util.ArrayList;

public interface WectorLengthCalc {
    double getWectorLength(Wector w) throws NullReferenceException;
    double getWectorLength(Dot dot1, Dot dot2) throws NullReferenceException;
    double[] getWectorLengths(ArrayList <Wector> wectorsList) throws NullReferenceException;
    double getWectorLength(double[] wectorProjection) throws NullReferenceException, NotSupportedFunctionException;

}
