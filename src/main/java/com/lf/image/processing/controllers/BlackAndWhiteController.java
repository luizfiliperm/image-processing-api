package com.lf.image.processing.controllers;

import com.lf.image.processing.dtos.ImageDto;
import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.BlackAndWhiteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image/black-and-white")
public class BlackAndWhiteController {

    private BlackAndWhiteService blackAndWhiteService;

    public BlackAndWhiteController(BlackAndWhiteService blackAndWhiteService) {
        this.blackAndWhiteService = blackAndWhiteService;
    }

    @GetMapping
    public ResponseEntity<byte[]> getBlackAndWhiteImage(
            @RequestParam(value = "colorBased", defaultValue = "avg", required = false) String colorBased,
            @RequestBody ImageDto imageDto){
        Image image = new Image(imageDto.getUrl());

        switch (colorBased){
            case "avg":
                blackAndWhiteService.averageBased(image);
                break;
            case "red":
                blackAndWhiteService.redBased(image);
                break;
            case "blue":
                blackAndWhiteService.blueBased(image);
                break;
            case "green":
                blackAndWhiteService.greenBased(image);
                break;
        }
        
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/binary")
    public ResponseEntity<byte[]> getBinaryImage(
            @RequestParam(value = "value", defaultValue = "100", required = false) int value,
            @RequestBody ImageDto imageDto
    ){
        Image image = new Image(imageDto.getUrl());
        blackAndWhiteService.binaryImage(image, value);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }
}
