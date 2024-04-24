package com.lf.image.processing.services.impl;

import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.LocalOperationsService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Arrays;

@Service
public class LocalOperationsServiceImpl implements LocalOperationsService {

    @Override
    public void mean(Image image, int size) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                if(isBorder(image, j, i, size)){
                    continue;
                }
                int avg = getAvg(image, i, j,size);
                image.getBufferedImage().setRGB(i, j, new Color(avg, avg, avg).getRGB());
            }
        }
    }

    @Override
    public void median(Image image, int size) {
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                if(isBorder(image, j, i, size)){
                    continue;
                }
                int median = getMedian(image, i, j, size);
                image.getBufferedImage().setRGB(i, j, new Color(median, median, median).getRGB());
            }
        }
    }

    private static int getAvg(Image image, int i, int j, int size) {
        int[] red = getRedArray(image, i, j, size);
        return (Arrays.stream(red).sum() / (size * size));
    }

    private static int getMedian(Image image, int i, int j, int size){
        int[] red = getRedArray(image, i, j, size);
        Arrays.sort(red);
        return red[red.length / 2];
    }

    private static int[] getRedArray(Image image, int i, int j, int size) {
        int[] red = new int[size * size];
        int count = 0;
        for(int k = - getLimit(size); k <= getLimit(size); k++){
            for(int l = -getLimit(size); l <= getLimit(size); l++){
                Color color = new Color(image.getBufferedImage().getRGB(i + k, j + l));
                red[count] = color.getRed();
                count++;
            }
        }
        return red;
    }

    private static boolean isBorder(Image image, int j, int i,int size) {
        return j < size / 2
                || i < size / 2
                || i >= image.getWidth() - size / 2
                || j >= image.getHeight() - size / 2;
    }

    private static int getLimit(int size){
        return Math.floorDiv(size, 2);
    }
}
