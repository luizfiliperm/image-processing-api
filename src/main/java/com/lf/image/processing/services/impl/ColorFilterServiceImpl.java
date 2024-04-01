package com.lf.image.processing.services.impl;

import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.ColorFilterService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class ColorFilterServiceImpl implements ColorFilterService {

    @Override
    public void redBand(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getRed(), 0, 0);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void greenBand(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(0, color.getGreen(), 0);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void blueBand(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(0, 0, color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void invertColors(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }
}
