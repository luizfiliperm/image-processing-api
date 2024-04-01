package com.lf.image.processing.services.impl;

import com.lf.image.processing.entities.Image;
import com.lf.image.processing.entities.YIQ;
import com.lf.image.processing.services.YiqService;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class YiqServiceImpl implements YiqService {

    @Override
    public void increaseY(Image image, int value) {

        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(getYValue(yiq.getY(), value), yiq.getI(), yiq.getQ());
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    @Override
    public void increaseI(Image image, int value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(yiq.getY(), getIValue(yiq.getI(), value), yiq.getQ());
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    @Override
    public void increaseQ(Image image, int value) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                YIQ yiq = new YIQ(new Color(image.getBufferedImage().getRGB(i,j)));
                YIQ newYiq = new YIQ(yiq.getY(), yiq.getI(), getQValue(yiq.getQ(), value));
                image.getBufferedImage().setRGB(i,j, newYiq.convertToRGB());
            }
        }
    }

    private Double getYValue(Double y, int value){
        if(y + value < 0)
            return 0.0;
        if(y + value > 1)
            return 1.0;
        return y + value;
    }

    private Double getIValue(Double i, int value){
        if(i + value < -0.5957)
            return -0.5957;
        if(i + value > 0.5957)
            return 0.5957;
        return i + value;
    }

    private Double getQValue(Double q, int value){
        if(q + value < -0.5226)
            return -0.5226;
        if(q + value > 0.5226)
            return 0.5226;
        return q + value;
    }
}
