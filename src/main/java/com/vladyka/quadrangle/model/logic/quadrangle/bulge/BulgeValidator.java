package com.vladyka.quadrangle.model.logic.quadrangle.bulge;

import com.vladyka.quadrangle.model.entity.dot.Dot;
import com.vladyka.quadrangle.model.exception.NullReferenceException;

public interface BulgeValidator  {
    boolean isBulging (Dot[] dots) throws NullReferenceException;
}
