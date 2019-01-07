package com.vladyka.quadrangle.model.logic.wector;

import com.vladyka.quadrangle.model.logic.wector.collinearity.CollinearityValidator;
import com.vladyka.quadrangle.model.logic.wector.orthogonality.OrthogonalityValidator;

public class WectorValidator {
    private CollinearityValidator collinearityValidator;
    private OrthogonalityValidator orthogonalityValidator;

    public WectorValidator(CollinearityValidator collinearityValidator,
                           OrthogonalityValidator orthogonalityValidator) {
        this.collinearityValidator = collinearityValidator;
        this.orthogonalityValidator = orthogonalityValidator;
    }

    public CollinearityValidator getCollinearityValidator() {
        return collinearityValidator;
    }

    public void setCollinearityValidator(CollinearityValidator collinearityValidator) {
        this.collinearityValidator = collinearityValidator;
    }

    public OrthogonalityValidator getOrthogonalityValidator() {
        return orthogonalityValidator;
    }

    public void setOrthogonalityValidator(OrthogonalityValidator orthogonalityValidator) {
        this.orthogonalityValidator = orthogonalityValidator;
    }
}
