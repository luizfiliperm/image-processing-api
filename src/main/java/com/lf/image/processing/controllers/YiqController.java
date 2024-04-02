package com.lf.image.processing.controllers;

import com.lf.image.processing.dtos.ImageDto;
import com.lf.image.processing.entities.Image;
import com.lf.image.processing.services.YiqService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("image/yiq")
public class YiqController {

    private YiqService yiqService;

    public YiqController(YiqService yiqService) {
        this.yiqService = yiqService;
    }

    @GetMapping("/increase-y")
    public ResponseEntity<byte[]> increaseY(
            @RequestParam(value = "value") double value,
            @RequestBody ImageDto imageDto
            ) {

        Image image = new Image(imageDto.getUrl());

        yiqService.increaseY(image, value);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/multiply-y")
    public ResponseEntity<byte[]> multiplyY(
            @RequestParam(value = "value") double value,
            @RequestBody ImageDto imageDto
    ) {

        Image image = new Image(imageDto.getUrl());

        yiqService.multiplyY(image, value);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/increase-i")
    public ResponseEntity<byte[]> increaseI(
            @RequestParam(value = "value") double value,
            @RequestBody ImageDto imageDto
    ) {

        Image image = new Image(imageDto.getUrl());

        yiqService.increaseI(image, value);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/increase-q")
    public ResponseEntity<byte[]> increaseQ(
            @RequestParam(value = "value") double value,
            @RequestBody ImageDto imageDto
    ) {

        Image image = new Image(imageDto.getUrl());

        yiqService.increaseQ(image, value);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }

    @GetMapping("/invert-y")
    public ResponseEntity<byte[]> invertY(
            @RequestBody ImageDto imageDto
    ) {

        Image image = new Image(imageDto.getUrl());

        yiqService.invertY(image);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.convertToByte());
    }
}
