package com.vladyka.quadrangle.model.logic.quadrangle.creator;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.quadrangle.Quadrangle2d;
import com.vladyka.quadrangle.model.entity.quadrangle.QuadrangleFigure;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.quadrangle.dots_extractor.DotsExtractor;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.Shape2dValidatorImpl;
import com.vladyka.quadrangle.model.logic.quadrangle.shape.ShapeValidator;

import java.util.ArrayList;

/**
 * Created by Vladyka Stas
 * on 28.12.2018 at 22:54
 **/
public class QuadrangleSimpleFactory {
    public QuadrangleFigure getQuadrangle(ArrayList<Wector> wectorsList, ShapeValidator shapeValidator) throws
            NotSupportedFunctionException, NullReferenceException {

        if (wectorsList != null && wectorsList.size() == 4 && shapeValidator != null) {
            Dot[] dots = DotsExtractor.getFigureDots(wectorsList);
            if (shapeValidator.isQuadrangle(dots)) {
                return new Quadrangle2d(wectorsList);
            }
            else throw new NotSupportedFunctionException("Can't create quadrangle");
        } else throw new NotSupportedFunctionException("Can't create quadrangle");
    }
}
