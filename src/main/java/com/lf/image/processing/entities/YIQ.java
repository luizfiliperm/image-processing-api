package com.lf.image.processing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YIQ {

    private Double y;

    private Double i;

    private Double q;


    public YIQ(Color color){
        this.y = 0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue();
        this.i = 0.596 * color.getRed() - 0.274 * color.getGreen() - 0.322 * color.getBlue();
        this.q = 0.211 * color.getRed() - 0.523 * color.getGreen() + 0.312 * color.getBlue();
    }

    public int convertToRGB(){
        int red = getBandValue((int)(this.y + 0.956 * this.i + 0.621 * this.q));
        int green = getBandValue((int)(this.y - 0.272 * this.i - 0.647 * this.q));
        int blue = getBandValue((int)(this.y - 1.106 * this.i + 1.703 * this.q));

        return new Color(red, green, blue).getRGB();
    }

    private int getBandValue(int band){
        if(band < 0)
            return 0;
        if(band > 255)
            return 255;
        return band;
    }
}
