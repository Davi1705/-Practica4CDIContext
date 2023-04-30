package com.example.cdicontexto.model;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class Carro implements Serializable {
    private String modelo;
    private String marca;
    private int anho;
    private String color;
    private double precio;
    private String estado;

}
