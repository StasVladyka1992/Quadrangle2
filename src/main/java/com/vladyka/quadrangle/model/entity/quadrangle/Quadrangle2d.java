package com.vladyka.quadrangle.model.entity.quadrangle;

import com.vladyka.quadrangle.model.entity.wector.Wector;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

import java.util.ArrayList;
import java.util.Arrays;

public class Quadrangle2d implements QuadrangleFigure {
    private ArrayList<Wector> wectorsList;

    public Quadrangle2d(ArrayList<Wector> wectorsList) {
        this.wectorsList = wectorsList;
    }

    public Quadrangle2d() {
    }

    @Override
    public ArrayList<Wector> getWectorList() {
        return wectorsList;
    }

    public void setWectorsList(ArrayList<Wector> wectorsList) {
        this.wectorsList = wectorsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadrangle2d that = (Quadrangle2d) o;

        return wectorsList.equals(that.wectorsList);
    }

    @Override
    public int hashCode() {
        return wectorsList.hashCode();
    }

    @Override
    public String toString() {
        return "Quadrangle2d{" +
                "wectorsList=" + Arrays.toString(wectorsList.toArray()) +
                '}';
    }
}
