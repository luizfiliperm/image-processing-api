package com.lf.image.processing.services;

import com.lf.image.processing.entities.Image;

public interface BrightnessFilterService {

    void increaseBrightness(Image image, int value);

    void multiplyBrightness(Image image, double value);

}
