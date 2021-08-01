package agregados;

import java.util.Random;

public class Animales {

    public static int vida = 100;

    public static void main(String[] args) {
        int vida = 200;
        Random random = new Random();

        String[] animales = { "Perro", "Gato", "Koala", "Pato", "Cabra", "Suricata" };

        int randomAnimal;
        int largoArrayAnimales;

        largoArrayAnimales = animales.length;
        System.out.println("Largo animales: " + largoArrayAnimales);

        randomAnimal = random.nextInt(largoArrayAnimales); // de 0 al largo del array
        System.out.println("Random animales: " + randomAnimal);

        // int vida = 0;
        int hambre = 0;
        // int alimentoAnimal = 0; --> ver si agregar alimentoAnimal como objeto

        int dañoAnimal = 0;
        int habilidadEspecial = 0;

        int[] statsAnimal = { vida, hambre, dañoAnimal, habilidadEspecial };

        statsAnimal[3] = random.nextInt(10);

        if (randomAnimal == 0) {
            /* ----- ----- perro ----- ----- */
            System.out.println("perro");
            statsAnimal[0] = random.nextInt(50) + 30;
            statsAnimal[1] = random.nextInt(90);
            statsAnimal[2] = random.nextInt(35);

        } else if (randomAnimal == 1) {
            /* ----- ----- gato ----- ----- */
            System.out.println("gato");
            statsAnimal[0] = random.nextInt(170) + 30;
            statsAnimal[1] = random.nextInt(90);
            statsAnimal[2] = random.nextInt(25);

        } else if (randomAnimal == 2) {
            /* ----- ----- koala ----- ----- */
            System.out.println("koala");
            statsAnimal[0] = random.nextInt(270) + 30;
            statsAnimal[1] = random.nextInt(90);
            statsAnimal[2] = random.nextInt(1);

        } else if (randomAnimal == 3) {
            /* ----- ----- pato ----- ----- */
            System.out.println("pato");
            statsAnimal[0] = random.nextInt(20) + 30;
            statsAnimal[1] = random.nextInt(90);
            statsAnimal[2] = random.nextInt(15);

        } else if (randomAnimal == 4) {
            /* ----- ----- cabra ----- ----- */
            System.out.println("cabra");
            statsAnimal[0] = random.nextInt(120) + 30;
            statsAnimal[1] = random.nextInt(90);
            statsAnimal[2] = random.nextInt(55);

        } else if (randomAnimal == 5) {
            System.out.println("suricata");
            /* ----- ----- suricata ----- ----- */
            statsAnimal[0] = random.nextInt(20) + 30;
            statsAnimal[1] = random.nextInt(90);
            statsAnimal[2] = random.nextInt(5);

        }

        if (statsAnimal[3] <= 5) {
            System.out.println("sin habilidad " + statsAnimal[3]);
        } else {
            System.out.println("Tiene habilidad especial " + statsAnimal[3]);
        }
        for (int i = 0; i < statsAnimal.length - 1; i++) {
            System.out.println(statsAnimal[i]);
        }

        System.out.println(vida + "vida dentro");
        System.out.println(Animales.vida + "vida fuera");
    } // fin funcion

}
/* ----- ----- habilidades especiales ----- ----- */
// perro --> encontrar armas mas facil -->int suerteArmas;
// gato --> bonus de sigilo (sirve para huir) --> int suerteSigilo;
// koala --> bonus de suerte. --> int suerteTotal;
// pato --> encontrar agua mas facil --> int suerteAgua;
// cabra --> bonus de daño. --> int suerteDaño;
// suricata --> bonus de sociabilidad. -->int sociabilidad;
// (los aliados humanos tienen menos probabilidades de traincionarte)
