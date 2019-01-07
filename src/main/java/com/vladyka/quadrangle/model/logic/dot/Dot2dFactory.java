package com.vladyka.quadrangle.model.logic.dot;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NoCoordinatesFoundException;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.util.coordinate_validator.CoordinatesValidator;
import com.vladyka.quadrangle.util.coordinate_validator.CoordinatesValidator2d;
import javafx.scene.effect.DropShadowBuilder;

import java.util.ArrayList;

/**
 * Created by Vladyka Stas
 * on 26.12.2018 at 23:47
 **/
public class Dot2dFactory {
    public Dot[] getDots(String unsplittedCoordinates) throws
            NullReferenceException{
        if (unsplittedCoordinates == null) {
            throw new NullReferenceException("There aren't any coordinates to create dots");
        }
        else {
            String[] coordinates = unsplittedCoordinates.split(" ");
            Dot2d[] dotsArray = new Dot2d[4];
            for (int i = 1; i < coordinates.length; i = i + 2) {
                dotsArray[i / 2] = new Dot2d();
                dotsArray[i / 2].setX(Double.parseDouble(coordinates[i - 1]));
                dotsArray[i / 2].setY(Double.parseDouble(coordinates[i]));
            }
            return dotsArray;
        }
    }
}
