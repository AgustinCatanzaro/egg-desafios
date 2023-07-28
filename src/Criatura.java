import java.util.Random;

//En este ejercicio, creamos una clase base llamada Criatura,
//que representa una criatura genérica con un nombre, salud y poder de ataque.

//Luego, creamos una subclase CriaturaMagica, que hereda de Criatura y tiene un atributo adicional de poderMagico.
//Las criaturas mágicas pueden atacar físicamente o lanzar hechizos mágicos, consumiendo su poder mágico en cada hechizo.

// En el método main, creamos dos criaturas: un goblin y un mago oscuro.
//  Luego, simulamos una batalla en la que las criaturas se atacan entre sí, mostrando el estado de salud después de cada ataque.
//  Puedes ajustar los valores de salud, ataque y poder mágico para crear diferentes combinaciones y hacer el juego más interesante.

// Recuerda que este es solo un ejemplo sencillo y que puedes ampliar y mejorar el juego según tus preferencias y habilidades.

// ¡Diviértete programando!


//Clase base: Criatura

class Criatura {
    protected String nombre;
    protected int salud;
    protected int ataque;

    public Criatura(String nombre, int salud, int ataque){
        this.nombre = nombre;
        this.salud  = salud;
        this.ataque = ataque;

    }

    public void recibirAtaque(int dano){
        salud -= dano;
            if (salud <=0){
                salud =0; 
            }
    }

    public void atacar(Criatura enemigo) {
        //Generamos un valor aleatorio entre 1 y el ataque del personaje.
        Random random = new Random();
        int ataqueAleatorio = random.nextInt(ataque - 1) + 1;

        System.out.println(nombre + " ataca a " + enemigo.nombre + " por " + ataqueAleatorio + " puntos de daños. ");
        enemigo.recibirAtaque(ataqueAleatorio);
    }

    public void mostrarEstado() {
        System.out.println(nombre + " - salud: " + salud);
    }

}

//Subclase: Criatura Magica
class CriaturaMagica extends Criatura {
    //Asignamos el poder Magico donde se generara el poder entre el poder total y su mitad es decir si el ataque es 20 el ataque podra ser entre 10 y 20
    private int poderMagico;

    public CriaturaMagica(String nombre, int salud, int ataque, int poderMagico) {
        super(nombre, salud, ataque);
        this.poderMagico = poderMagico;
    }

    @Override
    public void atacar(Criatura enemigo) {

        if (poderMagico > 0) {
            Random random = new Random();
            int ataqueAleatorio = random.nextInt(poderMagico/2) + poderMagico/2;

            System.out.println(nombre + " Lanza un hechizo a " + enemigo.nombre + " por " + ataqueAleatorio + " puntos de daño magico.");
            enemigo.recibirAtaque(ataqueAleatorio); 
            poderMagico -= 5; //Consumimos parte del poder magico en cada ataque
        }
        else{
            System.out.println(nombre + " No tiene suficiente poder magico para lanzar un hechizo. ¡Ataca Fisicamente!");
            super.atacar(enemigo); // Atacamos fisicamente si no hay poder magico sufiente
        }
    }
}
//Batallon 
class BatallaDeCriaturasMagicas {
    public static void main(String[] args) {

        Criatura criatura1 = new Criatura( "Goblin", 50,  15);
        CriaturaMagica criatura2 = new CriaturaMagica("Mago Oscuro", 40, 5, 25);

        System.out.println("¡Comienza la Batalla!");

        while (criatura1.salud != 0 && criatura2.salud != 0) {
            System.out.println("-----------");
            criatura1.mostrarEstado();
            criatura2.mostrarEstado();
            System.out.println("-----------");
            criatura1.atacar(criatura2);
            criatura2.atacar(criatura1);
            System.out.println("-----------");
        }
        System.out.println("¡Fin del combate!");

        criatura1.mostrarEstado();
        criatura2.mostrarEstado();

        if(criatura1.salud == 0 && criatura2.salud == 0 ){
            System.out.println("EMPATE");
        } else if (criatura1.salud > 0){
            System.out.println("El ganador es: " +criatura1.nombre);
        }else {
            System.out.println("El ganador es: " +criatura2.nombre);
        }

    }

}