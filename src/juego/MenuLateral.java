package juego;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

import entorno.Entorno;

public class MenuLateral {
	
	private Image iconoBurbuja;
	private boolean mostrarIconoBurbuja;
	private long tiempoMostrarBurbuja;
	
	public MenuLateral() {
	    this.iconoBurbuja = new ImageIcon(getClass().getResource("/imagenes/BurbujaProtectora.png")).getImage();
	    this.mostrarIconoBurbuja = false;
	}
	
	public void activarIconoBurbuja() {
	    this.mostrarIconoBurbuja = true;
	    this.tiempoMostrarBurbuja = System.currentTimeMillis();
	}
	
	public void dibujar(Entorno entorno) {
        // Dibujar fondo del menú
        entorno.dibujarRectangulo(700, 300, 200, 600, 0, Color.DARK_GRAY);

        // Botón 1
        entorno.dibujarRectangulo(700, 330, 160, 40, 0, Color.GRAY);
        entorno.cambiarFont("Arial", 18, Color.WHITE);
        entorno.escribirTexto("Habilidad 1", 660, 335);

        // Botón 2
        entorno.dibujarRectangulo(700, 390, 160, 40, 0, Color.GRAY);
        entorno.cambiarFont("Arial", 18, Color.WHITE);
        entorno.escribirTexto("Habilidad 2", 660, 395);

        // Botón 3
        entorno.dibujarRectangulo(700, 450, 160, 40, 0, Color.GRAY);
        entorno.cambiarFont("Arial", 16, Color.WHITE);
        entorno.escribirTexto("Burbuja protectora", 635, 455);
        
        // Botón SALIR        
        entorno.dibujarRectangulo(740, 570, 80, 40, 0, Color.GRAY);
        entorno.cambiarFont("Arial", 18, Color.WHITE);
        entorno.escribirTexto("Salir", 720, 575);
        
        // Cuadrado de Burbuja protectora
        entorno.dibujarRectangulo(700, 150, 140, 140, 0, Color.GRAY);
        if (mostrarIconoBurbuja) {
        	entorno.dibujarImagen(iconoBurbuja, 700, 150, 0, 2);
        }
        
        
        if (mostrarIconoBurbuja) {
            if (System.currentTimeMillis() - tiempoMostrarBurbuja < 3000) { // 3 segundos
                entorno.dibujarImagen(iconoBurbuja, 700, 250, 0, 1.5); // posición y escala
            } else {
                mostrarIconoBurbuja = false;
            }
        }
        
    }
	

    public void manejarEntrada(Entorno entorno) {
        if (entorno.estaPresionada('1')) {
            System.out.println("Habilidad 1");
        }
        if (entorno.estaPresionada('2')) {
            System.out.println("Habilidad 2");
        }
        if (entorno.estaPresionada('3')) {
            System.out.println("Habilidad 3");
        }
        if (entorno.estaPresionada('n')) {
            System.out.println("Salir");
            System.exit(0);
        }
    }
}
