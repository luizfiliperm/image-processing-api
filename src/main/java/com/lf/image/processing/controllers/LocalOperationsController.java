package com.lf.image.processing.controllers;

import com.lf.image.processing.dtos.ImageDto;
import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.LocalOperationsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image/local-operations")
public class LocalOperationsController {

    private LocalOperationsService localOperationsService;

    public LocalOperationsController(LocalOperationsService localOperationsService) {
        this.localOperationsService = localOperationsService;
    }

    @GetMapping("/mean")
    public ResponseEntity<byte[]> getMeanImage(
            @RequestParam(value = "size") int size,
            @RequestBody ImageDto imageDto
    ){
        Image image = new Image(imageDto.getUrl());
        localOperationsService.mean(image, size);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/median")
    public ResponseEntity<byte[]> getMedianImage(
            @RequestParam(value = "size") int size,
            @RequestBody ImageDto imageDto
    ){
        Image image = new Image(imageDto.getUrl());
        localOperationsService.median(image, size);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }
}
