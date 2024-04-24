package com.lf.image.processing.services;

import com.lf.image.processing.entities.Image;

public interface LocalOperationsService {

    void mean(Image image, int size);

    void median(Image image, int size);
}
