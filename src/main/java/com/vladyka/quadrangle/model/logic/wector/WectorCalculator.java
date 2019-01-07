package com.vladyka.quadrangle.model.logic.wector;

import com.vladyka.quadrangle.model.logic.wector.difference.DifferenceCalc;
import com.vladyka.quadrangle.model.logic.wector.length.WectorLengthCalc;
import com.vladyka.quadrangle.model.logic.wector.projection.ProjectionCalc;
import com.vladyka.quadrangle.model.logic.wector.sum.SumCalc;

public class WectorCalculator {
    private SumCalc sumCalc;
    private ProjectionCalc projectionCalc;
    private WectorLengthCalc wectorLengthCalc;
    private DifferenceCalc differenceCalc;

    public WectorCalculator(SumCalc sumCalc, ProjectionCalc projectionCalc, WectorLengthCalc wectorLengthCalc,
                            DifferenceCalc differenceCalc) {
        this.sumCalc = sumCalc;
        this.projectionCalc = projectionCalc;
        this.wectorLengthCalc = wectorLengthCalc;
        this.differenceCalc = differenceCalc;
    }

    public SumCalc getSumCalc() {
        return sumCalc;
    }

    public void setSumCalc(SumCalc sumCalc) {
        this.sumCalc = sumCalc;
    }

    public ProjectionCalc getProjectionCalc() {
        return projectionCalc;
    }

    public void setProjectionCalc(ProjectionCalc projectionCalc) {
        this.projectionCalc = projectionCalc;
    }

    public WectorLengthCalc getWectorLengthCalc() {
        return wectorLengthCalc;
    }

    public void setWectorLengthCalc(WectorLengthCalc wectorLengthCalc) {
        this.wectorLengthCalc = wectorLengthCalc;
    }

    public DifferenceCalc getDifferenceCalc() {
        return differenceCalc;
    }

    public void setDifferenceCalc(DifferenceCalc differenceCalc) {
        this.differenceCalc = differenceCalc;
    }
}
