package com.lf.image.processing.controllers;

import com.lf.image.processing.dtos.ImageDto;
import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.TonalityFilterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image/tonality-filter")
public class TonalityFilterController {

    private TonalityFilterService tonalityFilterService;

    public TonalityFilterController(TonalityFilterService tonalityFilterService) {
        this.tonalityFilterService = tonalityFilterService;
    }

    @GetMapping
    public ResponseEntity<byte[]> increaseTonality(
            @RequestParam(value = "band") String band,
            @RequestParam(value = "value") int value,
            @RequestBody ImageDto imageDto
            ){
        Image image = new Image(imageDto.getUrl());

        switch (band){
            case "red":
                tonalityFilterService.increaseRedTonality(image,value);
                break;
            case "green":
                tonalityFilterService.increaseGreenTonality(image,value);
                break;
            case "blue":
                tonalityFilterService.increaseBlueTonality(image,value);
                break;
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }
}
