package com.lf.image.processing.services;

import com.lf.image.processing.entities.Image;

public interface YiqService {

    void increaseY(Image image, int value);

    void increaseI(Image image, int value);

    void increaseQ(Image image, int value);

}
