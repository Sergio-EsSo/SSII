package com.cebem.demo.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.demo.models.PixelModel;
import com.cebem.demo.services.PixelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PixelController {
    private final PixelService pixelService;

    @GetMapping("/api/v1/pixels")
    ArrayList<PixelModel> getAllPixels(){
        return pixelService.getAllPixels();
    }

    @PostMapping("/pixels")
    PixelModel savePixel(@RequestBody PixelModel pixel){
        return pixelService.savePixel(pixel);
    }
}