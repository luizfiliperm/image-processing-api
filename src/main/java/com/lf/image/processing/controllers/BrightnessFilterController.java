package com.lf.image.processing.controllers;

import com.lf.image.processing.dtos.ImageDto;
import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.BrightnessFilterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image/brightness-filter")
public class BrightnessFilterController {

    private BrightnessFilterService brightnessFilterService;

    public BrightnessFilterController(BrightnessFilterService brightnessFilterService) {
        this.brightnessFilterService = brightnessFilterService;
    }

    @GetMapping("/increase")
    public ResponseEntity<byte[]> increaseBrightness(
            @RequestParam(value = "value") int value,
            @RequestBody ImageDto imageDto
            ) {
        Image image = new Image(imageDto.getUrl());

        brightnessFilterService.increaseBrightness(image, value);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/multiply")
    public ResponseEntity<byte[]> multiplyBrightness(
            @RequestParam(value = "value") double value,
            @RequestBody ImageDto imageDto
    ) {
        Image image = new Image(imageDto.getUrl());

        brightnessFilterService.multiplyBrightness(image, value);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

}
