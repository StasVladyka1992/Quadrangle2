package com.vladyka.quadrangle.model.logic.quadrangle.perimeter;


import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;

import java.util.ArrayList;

public interface PerimeterCalc{
    double calcPerimeter(ArrayList<Wector> wectorsList, WectorLengthCalc wectorLengthCalc) throws NullReferenceException;
    double roundPerimeter (double value, int scale);
}
