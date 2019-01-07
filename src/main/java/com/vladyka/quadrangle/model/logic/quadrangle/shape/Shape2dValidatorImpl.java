package com.vladyka.quadrangle.model.logic.quadrangle.shape;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.quadrangle.Quadrangle2d;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.logic.quadrangle.dots_extractor.DotsExtractor;
import com.vladyka.quadrangle.model.logic.wector.WectorCalculator;
import com.vladyka.quadrangle.model.logic.wector.WectorValidator;
import com.vladyka.quadrangle.model.logic.wector.collinearity.CollinearityValidator;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;
import com.vladyka.quadrangle.model.logic.wector.orthogonality.OrthogonalityValidator;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Shape2dValidatorImpl implements ShapeValidator {

    private static final Logger logger = LogManager.getLogger(Shape2dValidatorImpl.class);

    private WectorValidator wectorValidator;
    private WectorCalculator wectorCalculator;


    public Shape2dValidatorImpl(WectorValidator wectorValidator, WectorCalculator wectorCalculator) {
        this.wectorValidator = wectorValidator;
        this.wectorCalculator = wectorCalculator;
    }

    public boolean isThreeDotsOnLine(Dot dot1, Dot dot2, Dot dot3) {

        // return (x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 *

        if (dot1 == null || dot2 == null || dot3 == null) {
            return false;
        }

        return (((Dot2d) dot3).getX() * (((Dot2d) dot2).getY() - ((Dot2d) dot1).getY()) -
                ((Dot2d) dot3).getY() * (((Dot2d) dot2).getX() - ((Dot2d) dot1).getX()) ==
                ((Dot2d) dot1).getX() * ((Dot2d) dot2).getY() - ((Dot2d) dot2).getX() * ((Dot2d) dot1).getY());
    }

    @Override
    public boolean isQuadrangle(Dot[] dots) {
        if (dots.length != 4) {
            return false;
        }
        boolean res1,
                res2,
                res3,
                res4;

        res1 = !isThreeDotsOnLine(dots[0], dots[1], dots[2]); // p1,p2 to p3
        res2 = !isThreeDotsOnLine(dots[0], dots[1], dots[3]); // p1,p2 to p4
        res3 = !isThreeDotsOnLine(dots[1], dots[2], dots[3]); //p2,p3 to p4
        res4 = !isThreeDotsOnLine(dots[0], dots[2], dots[3]); //p1,p3 to p4

        boolean isQuadrangle = res1 && res2 && res3 && res4;
        return isQuadrangle;
    }

    @Override
    public boolean isParallelogram(QuadrangleFigure quadrangleFigure)  {
        ProjectionCalc projectionCalc = wectorCalculator.getProjectionCalc();
        ArrayList<Wector> wectorsList;
        Dot[] dots;
        boolean isParallelogram = false;
        if (quadrangleFigure == null) {
            return isParallelogram;
        } else if (quadrangleFigure instanceof Quadrangle2d) {
            wectorsList = quadrangleFigure.getWectorList();
            dots = DotsExtractor.getFigureDots(wectorsList);

            //  Opposite sides are parallel and equal + is quadrangle
            try {
                isParallelogram = wectorValidator.getCollinearityValidator().isCollinear(wectorsList.get(2), wectorsList.get(0), projectionCalc) &&
                        wectorValidator.getCollinearityValidator().isCollinear(wectorsList.get(1), wectorsList.get(3), projectionCalc) &&
                        isQuadrangle(dots);
            } catch (NullReferenceException e) {
                logger.error(e);
                System.out.println(e.getMessage());
            }
        }

        return isParallelogram;
    }

    @Override
    public boolean isRhombus(QuadrangleFigure quadrangleFigure)  {
        boolean isRhombus= false;
        if (quadrangleFigure == null) {
            return isRhombus;
        }
        // rhombus is parallelogram with equals sides
        ArrayList<Wector> wectorsList;
        if (quadrangleFigure instanceof Quadrangle2d) {
            wectorsList = quadrangleFigure.getWectorList();
        } else return isRhombus;

        double[] sidesLength;
        try {
            sidesLength = wectorCalculator.getWectorLengthCalc().getWectorLengths(wectorsList);
        } catch (NullReferenceException e) {
            logger.error(e);
            System.out.println(e.getMessage());
            return isRhombus;
        }
        isRhombus = isParallelogram(quadrangleFigure) &&
                sidesLength[0] == sidesLength[1] && sidesLength[1] == sidesLength[2];
        logger.info("<isRhombus> is done");
        return isRhombus;
    }

    @Override
    public boolean isTrapezium(QuadrangleFigure quadrangleFigure) {

        CollinearityValidator collinearityValidator = wectorValidator.getCollinearityValidator();
        ProjectionCalc projectionCalc = wectorCalculator.getProjectionCalc();
        ArrayList<Wector> wectorsList;
        Dot[] dots;
        boolean isTrapezium = false;

        if (quadrangleFigure == null) {
            return isTrapezium;
        }
        else if (quadrangleFigure instanceof Quadrangle2d) {
            wectorsList = quadrangleFigure.getWectorList();
            dots = DotsExtractor.getFigureDots(wectorsList);
        } else
            return isTrapezium;

        try {
            isTrapezium = (collinearityValidator.isCollinear(wectorsList.get(0), wectorsList.get(2), projectionCalc) &&
                    !collinearityValidator.isCollinear(wectorsList.get(1), wectorsList.get(3), projectionCalc) && isQuadrangle(dots)) ||
                    (!collinearityValidator.isCollinear(wectorsList.get(0), wectorsList.get(2), projectionCalc) &&
                            collinearityValidator.isCollinear(wectorsList.get(1), wectorsList.get(3), projectionCalc) && isQuadrangle(dots));
        } catch (NullReferenceException e) {
            logger.error(e);
            System.out.println(e.getMessage());
            return isTrapezium;
        }
        logger.info("<isTrapezium> is done");
        return isTrapezium;
    }

    @Override
    public boolean isSquare(QuadrangleFigure quadrangleFigure) throws NotSupportedFunctionException {
        OrthogonalityValidator orthogonalityValidator = wectorValidator.getOrthogonalityValidator();
        ProjectionCalc projectionCalc = wectorCalculator.getProjectionCalc();
        WectorLengthCalc wectorLengthCalc = wectorCalculator.getWectorLengthCalc();

        ArrayList<Wector> wectorsList;
        boolean isSquare = false;

        if (quadrangleFigure == null) {
            return isSquare;
        }
        else if (quadrangleFigure instanceof Quadrangle2d) {
            wectorsList = quadrangleFigure.getWectorList();
        } else
            return isSquare;
        try {
            isSquare = isParallelogram(quadrangleFigure) &&
                    orthogonalityValidator.isOrthogonal(wectorsList.get(0), wectorsList.get(1), projectionCalc) &&
                    (wectorLengthCalc.getWectorLength(wectorsList.get(0)) == wectorLengthCalc.getWectorLength(wectorsList.get(1)));
        } catch (NullReferenceException e) {
            logger.error(e);
            System.out.println(e.getMessage());
            return isSquare;
        }
        logger.info("<isSquare> is done");
        return isSquare;
    }
}
