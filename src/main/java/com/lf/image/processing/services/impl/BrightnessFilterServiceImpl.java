package com.lf.image.processing.services.impl;

import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.BrightnessFilterService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class BrightnessFilterServiceImpl implements BrightnessFilterService {

    @Override
    public void increaseBrightness(Image image, int value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(getAdditiveColorValue(color.getRed(), value), getAdditiveColorValue(color.getGreen(), value), getAdditiveColorValue(color.getBlue(), value));
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void multiplyBrightness(Image image, double value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(getMultiplicativeColorValue(color.getRed(), value), getMultiplicativeColorValue(color.getGreen(), value), getMultiplicativeColorValue(color.getBlue(), value));
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    private int getAdditiveColorValue(int color, int value) {
        if(color + value > 255)
            return 255;
        if(color + value < 0)
            return 0;
        return color + value;
    }

    private int getMultiplicativeColorValue(int color, double value) {
        if(color * value > 255)
            return 255;
        if(color * value < 0)
            return 0;
        return (int) (color * value);
    }
}
