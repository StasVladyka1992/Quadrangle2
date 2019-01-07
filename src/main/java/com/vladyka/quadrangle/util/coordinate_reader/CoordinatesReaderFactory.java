package com.vladyka.quadrangle.util.coordinate_reader;


import com.vladyka.quadrangle.model.exception.FileReadingException;
import com.vladyka.quadrangle.model.exception.NotSupportedFunctionException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.util.file_validator.FileValidator;

public class CoordinatesReaderFactory {
    public CoordinatesReader getCoordinatesReader (String fileName, FileValidator fileValidator) throws
            FileReadingException, NullReferenceException {
        if (fileName==null|| fileValidator == null){
            throw new NullReferenceException("No file name or file validator");
        }

        if (fileValidator.validate(fileName)){
            return  new FileCoordinatesReader(fileName);
        }
        else throw new FileReadingException("File doesn't exist");
    }
}
