package com.lf.image.processing.services;

import com.lf.image.processing.entities.Image;

public interface TonalityFilterService {

    void increaseRedTonality(Image image, int value);

    void increaseGreenTonality(Image image, int value);

    void increaseBlueTonality(Image image, int value);
}
