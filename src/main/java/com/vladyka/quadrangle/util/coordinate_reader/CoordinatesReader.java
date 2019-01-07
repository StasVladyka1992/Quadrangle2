package com.vladyka.quadrangle.util.coordinate_reader;

import com.vladyka.quadrangle.model.exception.FileReadingException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.util.coordinate_validator.CoordinatesValidator;

public interface CoordinatesReader  {
    String getCoordinatesFromSource(CoordinatesValidator coordinatesValidator) throws FileReadingException,
            NullReferenceException;
}
