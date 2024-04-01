package com.lf.image.processing.services.impl;

import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.BlackAndWhiteService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class BlackAndWhiteServiceImpl implements BlackAndWhiteService {

    @Override
    public void redBased(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getRed(), color.getRed(), color.getRed());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void greenBased(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getGreen(), color.getGreen(), color.getGreen());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void blueBased(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); i++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                Color newColor = new Color(color.getBlue(), color.getBlue(), color.getBlue());
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void averageBased(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));
                int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                Color newColor = new Color(average, average, average);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    @Override
    public void binaryImage(Image image, int value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                Color color = new Color(image.getBufferedImage().getRGB(i,j));

                int media = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                int binaryValue = getBinaryValue(media, value);

                Color newColor = new Color(binaryValue, binaryValue, binaryValue);
                image.getBufferedImage().setRGB(i,j, newColor.getRGB());
            }
        }
    }

    private int getBinaryValue(int media, int value) {
        if(media > value){
            return 255;
        }
        return 0;
    }
}
