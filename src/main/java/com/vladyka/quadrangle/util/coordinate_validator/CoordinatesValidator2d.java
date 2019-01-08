package com.vladyka.quadrangle.util.coordinate_validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesValidator2d implements CoordinatesValidator {
    private static final String PATTERN = "(^(-?[0-9]{1,5}\\.[0-9]{1,5} ))((-?[0-9]{1,5}\\.[0-9]{1,5} )){6}((-?[0-9]{1,5}\\.[0-9]{1,5}+)$)";

    @Override
    public boolean validateCoordinates(String uncheckedCoordinates) {

        if (uncheckedCoordinates==null) {
            return false;
        }
        else {
            Pattern pat = Pattern.compile(PATTERN);
            Matcher matcher = pat.matcher(uncheckedCoordinates);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

}
