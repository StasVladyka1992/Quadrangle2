package com.vladyka.quadrangle.util.coordinate_reader;

import com.vladyka.quadrangle.model.exception.FileReadingException;
import com.vladyka.quadrangle.model.exception.NullReferenceException;
import com.vladyka.quadrangle.util.coordinate_validator.CoordinatesValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCoordinatesReader implements CoordinatesReader {
    private String fileName;

    public FileCoordinatesReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getCoordinatesFromSource(CoordinatesValidator coordinatesValidator) throws FileReadingException,
            NullReferenceException{
        String checkedCoordinates=null;
        if (coordinatesValidator == null){
            throw new NullReferenceException("No suitable coordinates validator is available");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String coordinates = br.readLine();
                if (coordinatesValidator.validateCoordinates(coordinates)) {
                    return coordinates;
                }
            }
        } catch (IOException ex) {
            throw new FileReadingException("Error during reading data from file", ex);
        }

        return checkedCoordinates;
    }

}

