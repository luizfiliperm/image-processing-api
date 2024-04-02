package com.lf.image.processing.services.impl;

import com.lf.image.processing.entities.Image;
import com.lf.image.processing.entities.YIQ;
import com.lf.image.processing.services.YiqService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class YiqServiceImpl implements YiqService {

    @Override
    public void increaseY(Image image, double value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(getYValue(yiq.getY(), value), yiq.getI(), yiq.getQ());
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    @Override
    public void multiplyY(Image image, double value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(yiq.getY() * value, yiq.getI(), yiq.getQ());
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    @Override
    public void increaseI(Image image, double value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(yiq.getY(), getIValue(yiq.getI(), value), yiq.getQ());
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    @Override
    public void increaseQ(Image image, double value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(yiq.getY(), yiq.getI(), getQValue(yiq.getQ(), value));
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    @Override
    public void invertY(Image image) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(255 - yiq.getY(), yiq.getI(), yiq.getQ());
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    private Double getYValue(Double y, double value){
        return y + value;
    }

    private Double getIValue(Double i, double value){
        return i + value;
    }

    private Double getQValue(Double q, double value){
        return q + value;
    }
}
