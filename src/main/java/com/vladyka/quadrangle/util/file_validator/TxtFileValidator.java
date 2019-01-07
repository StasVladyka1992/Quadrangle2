package com.vladyka.quadrangle.util.file_validator;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vladyka Stas
 * on 26.12.2018 at 22:36
 **/
public class TxtFileValidator implements FileValidator {
    @Override
    public boolean validate(String fileName) {
        if (fileName == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\.txt$");
        Matcher matcher = pattern.matcher(fileName);
        File file = new File(fileName);
        if (file.exists() && matcher.find()) {
            return true;
        }
        return false;
    }
}
