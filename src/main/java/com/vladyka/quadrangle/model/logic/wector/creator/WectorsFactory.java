package com.vladyka.quadrangle.model.logic.wector.creator;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;
import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.entity.wector.Wector2d;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

import java.util.ArrayList;

public class WectorsFactory {
    public ArrayList<Wector> getWectorsList(Dot[] dots) throws NullReferenceException {
        ArrayList<Wector> wectorsList = new ArrayList<>();
        if (dots == null){
            throw new NullReferenceException("There aren't any coordinates to create vectors");
        }
        else  {
            for (int i = 1; i < dots.length; i++) {
                Wector wector = new Wector2d((Dot2d) dots[i - 1], (Dot2d) dots[i]);
                wectorsList.add(wector);
                if (i == dots.length - 1) {
                    Wector lastWector = new Wector2d((Dot2d) dots[i], (Dot2d) dots[0]);
                    wectorsList.add(lastWector);
                }
            }
         }
        return wectorsList;
    }

    public Wector getWector(Dot dot1, Dot dot2) throws NullReferenceException {
        if(dot1!=null && dot2!=null){
            return new Wector2d((Dot2d) dot1, (Dot2d) dot2);
        }
        else throw new NullReferenceException("There are not enough coordinates to create vectors");
    }

}
