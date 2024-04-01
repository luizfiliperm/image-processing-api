package com.lf.image.processing.services.impl;

import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.TonalityFilterService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class TonalityFilterServiceImpl implements TonalityFilterService {
    @Override
    public void increaseRedTonality(Image image, int value) {
        for(int i = 0; i < image.getWidth(); i++) {
            for(int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(getColorValue(color.getRed(), value), color.getGreen(), color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void increaseGreenTonality(Image image, int value) {
        for(int i = 0; i < image.getWidth(); i++) {
            for(int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getRed(), getColorValue(color.getGreen(), value), color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void increaseBlueTonality(Image image, int value) {
        for(int i = 0; i < image.getWidth(); i++) {
            for(int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getRed(), color.getGreen(), getColorValue(color.getBlue(), value));
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    private int getColorValue(int color, int value) {
        if(color + value > 255)
            return 255;
        if(color + value < 0)
            return 0;
        return color + value;
    }
}
