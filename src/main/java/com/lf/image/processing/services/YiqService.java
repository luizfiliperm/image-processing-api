package com.lf.image.processing.services;

import com.lf.image.processing.entities.Image;

public interface YiqService {

    void increaseY(Image image, double value);

    void multiplyY(Image image, double value);

    void increaseI(Image image, double value);

    void increaseQ(Image image, double value);

    void invertY(Image image);

}
