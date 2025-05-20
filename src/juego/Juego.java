package juego;


import java.awt.*;
import javax.swing.*;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	// Variables y métodos propios de cada grupo
    private Image fondo;
    private Personaje personaje;
    private MenuLateral menu;
    
    private Obstaculo[] rocas;
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Grupo 7 TP", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		fondo = new ImageIcon(getClass().getResource("/imagenes/FondoTierra2D.png")).getImage();
		personaje = new Personaje(300,300);
		menu = new MenuLateral();
		
		rocas = new Obstaculo[] {
			    new Obstaculo(150, 200),
			    new Obstaculo(150, 400),
			    new Obstaculo(370, 540),
			    new Obstaculo(450, 150),
			    new Obstaculo(460, 400)
			};
		
		// Inicia el juego!
		this.entorno.iniciar();
	}

	public void tick()
	{
		// Procesamiento de un instante de tiempo
		entorno.dibujarImagen(fondo, 400, 300, 0);
		
		for (Obstaculo roca : rocas) {
		    roca.dibujar(entorno);
		}
		
		if (entorno.estaPresionada('a')) {
	        personaje.moverIzquierda();
	    }
	    if (entorno.estaPresionada('d')) {
	        personaje.moverDerecha();
	    }
	    if (entorno.estaPresionada('w')) {
	        personaje.moverArriba();
	    }
	    if (entorno.estaPresionada('s')) {
	        personaje.moverAbajo();
	    }
	    
	    if (entorno.estaPresionada('3')) {
	        menu.activarIconoBurbuja();
	    }
	    
		personaje.dibujar(entorno);
		
		menu.dibujar(entorno);
		menu.manejarEntrada(entorno);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
