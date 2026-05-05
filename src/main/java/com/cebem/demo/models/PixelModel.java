package com.cebem.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PixelModel {
    private int x;
    private int y;
    private String color;

    //Uso lombok y no necesito getters/setters/constructor/toString/etc.
}
