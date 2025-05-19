package juego;

import entorno.Entorno;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Obstaculo {
    private double x, y;
    private Image imagen;
    private int ancho, alto;

    public Obstaculo(double x, double y) {
        this.x = x;
        this.y = y;
        this.ancho = 64;
        this.alto = 64;
        this.imagen = new ImageIcon(getClass().getResource("/imagenes/RocaObs.png")).getImage();
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(imagen, x, y, 0);
    }

    
    public double getX() { return x; }
    public double getY() { return y; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; } 
    
}