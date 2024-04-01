package com.lf.image.processing.controllers;

import com.lf.image.processing.dtos.ImageDto;
import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.ColorFilterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image/color-filter")
public class ColorFilterController {

    private ColorFilterService colorFilterService;

    public ColorFilterController(ColorFilterService colorFilterService) {
        this.colorFilterService = colorFilterService;
    }

    @GetMapping("/red-band")
    public ResponseEntity<byte[]> getRedBand(
            @RequestBody ImageDto imageDto
            ){
        Image image = new Image(imageDto.getUrl());

        colorFilterService.redBand(image);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/green-band")
    public ResponseEntity<byte[]> getGreenBand(
            @RequestBody ImageDto imageDto
            ){
        Image image = new Image(imageDto.getUrl());

        colorFilterService.greenBand(image);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/blue-band")
    public ResponseEntity<byte[]> getBlueBand(
            @RequestBody ImageDto imageDto
            ){
        Image image = new Image(imageDto.getUrl());

        colorFilterService.blueBand(image);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/invert-colors")
    public ResponseEntity<byte[]> invertColors(
            @RequestBody ImageDto imageDto
            ){
        Image image = new Image(imageDto.getUrl());

        colorFilterService.invertColors(image);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }
}
