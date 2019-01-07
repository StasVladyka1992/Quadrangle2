package com.vladyka.quadrangle.model.logic.quadrangle.dots_extractor;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

import java.util.ArrayList;


/**
 * Created by Vladyka Stas
 * on 28.12.2018 at 19:46
 **/
public class DotsExtractor {
    public static Dot[] getFigureDots (ArrayList<Wector> wectors){

        ArrayList<Dot> techList = new ArrayList<>();
        for (int i = 0; i <wectors.size() ; i++) {
            Dot [] wectorDots = wectors.get(i).getDots();
            for (int j = 0; j <wectorDots.length ; j++) {
                if (!techList.contains(wectorDots[j])){
                    techList.add(wectorDots[j]);
                }
            }
        }
        Object [] objects = techList.toArray();
        Dot [] dots = new Dot[objects.length];
        for (int i = 0; i <objects.length; i++) {
            dots[i]=(Dot2d)objects[i];
        }
    return dots;
    }
}
