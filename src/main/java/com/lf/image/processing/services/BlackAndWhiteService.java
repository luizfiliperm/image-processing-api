package com.lf.image.processing.services;

import com.lf.image.processing.entities.Image;

public interface BlackAndWhiteService {

    void redBased(Image image);

    void greenBased(Image image);

    void blueBased(Image image);

    void averageBased(Image image);

    void binaryImage(Image image, int value);
}
