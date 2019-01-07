package com.vladyka.quadrangle.model.logic.quadrangle.bulge;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BulgeQuadrangle2dValidator implements BulgeValidator {
    private  static  final  Logger logger = LogManager.getLogger(BulgeQuadrangle2dValidator.class);
    @Override
    public boolean isBulging(Dot[] dots) throws NullReferenceException{
        //(B[0]-A[0])*(C[1]-B[1])-(B[1]-A[1])*(C[0]-B[0])
        if (dots == null || dots.length!=4){
            return false;
        }
        boolean isBulging = false;
        try{
            isBulging = (getZCoordinate(dots[0], dots[1], dots[2]) < 0) &&
                    (getZCoordinate(dots[1], dots[2], dots[3]) < 0) &&
                    (getZCoordinate(dots[2], dots[3], dots[0]) < 0);

        }
        catch (NullReferenceException ex){
            logger.error(ex.getMessage());
        }

        return isBulging;
    }

    private double getZCoordinate(Dot dot0, Dot dot1, Dot dot2) throws NullReferenceException {
        if (dot0 == null || dot1 == null || dot2 == null) {
            throw new NullReferenceException("One of the dots doesn't exist");
        }

        Dot2d[] dots = new Dot2d[3];
        dots[0] = (Dot2d) dot0;
        dots[1] = (Dot2d) dot1;
        dots[2] = (Dot2d) dot2;
        //(B[0]-A[0])*(C[1]-B[1])-(B[1]-A[1])*(C[0]-B[0])
        return (dots[1].getX() - dots[0].getX()) * (dots[2].getY() - dots[1].getY()) -
                ((dots[1].getY() - dots[0].getY()) * (dots[2].getX() - dots[1].getX()));
    }
}
