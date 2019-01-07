package com.vladyka.quadrangle.model.logic.wector.projection;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

public class ProjectionCalc2dImpl implements ProjectionCalc {

    @Override
    public double[] getProjections(Wector wector) throws NullReferenceException {
        if (wector==null) {
            throw new NullReferenceException("There are no vectors to find their projections");
        }
            double[] projections = new double[2];
            Dot[] dots = wector.getDots();
            projections[0] = Math.abs(((Dot2d) (dots[1])).getX() - ((Dot2d) (dots[0])).getX()); //на Ox;
            projections[1] = Math.abs(((Dot2d) (dots[1])).getY() - ((Dot2d) (dots[0])).getY()); //на Oy;

        return projections;
    }

    @Override
    public double[] getProjections(Dot dot1, Dot dot2) throws NullReferenceException{
        if (dot1==null || dot2==null) {
            throw  new NullReferenceException("There is no vector to find it's projections");
        }
        double[] projections = new double[2];
        projections[0] = Math.abs(((Dot2d) (dot2)).getX() - ((Dot2d) (dot1)).getX()); //on Ox;
        projections[1] = Math.abs(((Dot2d) (dot2)).getY() - ((Dot2d) (dot1)).getY()); //on Oy;
    return projections;}
}
