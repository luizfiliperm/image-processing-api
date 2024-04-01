package com.lf.image.processing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@NoArgsConstructor
@Data
public class Image {

    private int height;

    private int width;

    private int pixels;

    private BufferedImage bufferedImage;

    public Image(String url){
        this.bufferedImage = readBufferedImage(url);

        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.pixels = height * width;
    }

    public Image(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
    }

    private BufferedImage readBufferedImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
