package com.vladyka.quadrangle.model.entity.wector;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.entity.dot.Dot2d;

import java.util.Arrays;
public class Wector2d implements Wector {
    private Dot2d dot1;
    private Dot2d dot2;


    public Wector2d(Dot2d dot1, Dot2d dot2) {
        this.dot1 =dot1;
        this.dot2 =dot2;
    }

    public Wector2d() {
    }

    public Dot getDot1() {
        return dot1;
    }

    public void setDot1(Dot2d dot1) {
        this.dot1 = dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public void setDot2(Dot2d dot2) {
        this.dot2 = dot2;
    }

    @Override
    public Dot[] getDots() {
        Dot[] dots  = new Dot2d[2];
        dots[0] = dot1;
        dots[1] = dot2;
        return dots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wector2d wector2d = (Wector2d) o;

        if (!dot1.equals(wector2d.dot1)) return false;
        return dot2.equals(wector2d.dot2);
    }

    @Override
    public int hashCode() {
        int result = dot1.hashCode();
        result = 31 * result + dot2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\nWector:" + Arrays.toString(getDots()) +"\n";
    }
}
