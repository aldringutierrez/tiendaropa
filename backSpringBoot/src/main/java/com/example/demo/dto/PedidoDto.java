package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDto {
  String nombre;
  String tipide;
  double numide;
  String fechora;
  String direccion;
  List<Item> items = new ArrayList<Item>();

  public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipide() {
		return tipide;
	}
	public void setTipide(String tipide) {
		this.tipide = tipide;
	}
	public double getNumide() {
		return numide;
	}
	public void setNumide(double numide) {
		this.numide = numide;
	}
	public String getFechora() {
		return fechora;
	}
	public void setFechora(String fechora) {
		this.fechora = fechora;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

  
  
}
