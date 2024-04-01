package com.lf.image.processing.services;

import com.lf.image.processing.entities.Image;

public interface ColorFilterService {

    void redBand(Image image);

    void greenBand(Image image);

    void blueBand(Image image);

    void invertColors(Image image);

}
