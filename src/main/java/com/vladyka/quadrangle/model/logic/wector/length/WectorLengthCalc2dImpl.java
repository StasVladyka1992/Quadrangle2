package com.vladyka.quadrangle.model.logic.wector.length;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

import java.util.ArrayList;

public class WectorLengthCalc2dImpl implements WectorLengthCalc {
    @Override
    public double getWectorLength(Wector wector) throws NullReferenceException {
        if (wector == null) {
            throw new NullReferenceException("Vector doesn't exist");
        }
        Dot[] dots = wector.getDots();
        //calculation through Pythagoras' theorem
        return Math.sqrt(
                Math.pow(((Dot2d) (dots[1])).getX() - ((Dot2d) (dots[0])).getX(), 2) +
                        Math.pow(((Dot2d) (dots[1])).getY() - ((Dot2d) (dots[0])).getY(), 2));
    }

    public double getWectorLength(Dot dot1, Dot dot2) throws NullReferenceException {
        if (dot1 == null || dot2 == null) {
            throw new NullReferenceException("There is not enough dots to create vector and find it length");
        }
        return Math.sqrt(
                Math.pow(((Dot2d) (dot2)).getX() - ((Dot2d) (dot1)).getX(), 2) +
                        Math.pow(((Dot2d) (dot2)).getY() - ((Dot2d) (dot1)).getY(), 2));
    }

    @Override
    public double[] getWectorLengths(ArrayList<Wector> wectorsList) throws NullReferenceException {
        if (wectorsList == null) {
            throw new NullReferenceException("There are no vectors to find length");
        }

        double[] wectorLengths = new double[wectorsList.size()];
        for (int i = 0; i < wectorsList.size(); i++) {
            wectorLengths[i] = getWectorLength(wectorsList.get(i));
        }
        return wectorLengths;
    }

    @Override
    public double getWectorLength(double[] wectorProjection) throws NullReferenceException, NotSupportedFunctionException {
        if (wectorProjection == null) {
            throw new NullReferenceException("There no vectors to find length");
        } else if (wectorProjection.length == 0) {
            throw new NotSupportedFunctionException("There no vectors to find length");
        }
        return Math.sqrt(
                Math.pow(wectorProjection[0], 2) +
                        Math.pow(wectorProjection[1], 2));
    }
}
