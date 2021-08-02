import java.util.Random;
import javax.swing.JOptionPane;

public class App {

    /* ----- ----- STATS JUGADOR ----- ----- */
    public static int vida = 0;
    public static int sed = 1;
    public static int dañoJugador = 2;
    public static int dañoMaximoArma = 3;
    public static int bonusVendaje = 4;
    public static int bonusComida = 5;
    public static int bonusMonster = 6;
    public static int monsters = 7;
    public static int vendajes = 8;
    public static int comidas = 9;
    public static int llavesComunes = 10;
    public static int suerte = 11;
    public static int bonusSuerte = 12;
    public static int botellasLlenas = 13;
    public static int botellasVacias = 14;
    public static int bonusAgua = 15;
    public static int dropeoAgua = 16;
    public static int armaPrincipal = 17;
    public static int armaSecundaria = 18;
    public static int bonusComidaTurnos = 19;
    public static int suerteArmas = 20;
    public static int suerteSigilo = 21;
    public static int suerteGeneral = 22;
    public static int suerteAgua = 23;
    public static int suerteDaño = 24;

    /* ----- ----- ADICIONALES ----- ----- */

    public static final int error = 0;
    public static final int info = 1;
    public static final int alerta = 2;
    public static final int pregunta = 3;
    public static final String saltoLinea = "\n";
    public static String mensaje = "";

    /* ----- ----- PELEA ----- ----- */

    public static int rondas = 0;

    public static String enemigo = "";
    public static int vidaEnemigo = 0;
    public static int dañoEnemigo = 0;
    public static int dañoRebote = 0;

    public static String arma = "";
    public static String armaEnemigo = "";
    public static int dañoMaximoEnemigo = 0;

    public static void main(String[] args) {

        /* ----- ----- ESTADO ----- ----- */

        int[] stats = { vida, sed, dañoJugador, dañoMaximoArma, bonusVendaje, bonusComida, bonusMonster, monsters,
                vendajes, comidas, llavesComunes, suerte, bonusSuerte, botellasLlenas, botellasVacias, bonusAgua,
                dropeoAgua, armaPrincipal, armaSecundaria, bonusComidaTurnos, suerteArmas, suerteSigilo, suerteGeneral,
                suerteAgua, suerteDaño };

        /* ----- ----- JUGADOR ----- ----- */
        stats[vida] = 100; // maximo de vida
        stats[sed] = 80; // sed inicial
        stats[dañoJugador] = 0;

        /* ----- ----- SUERTE ----- ----- */
        stats[suerte] = 0;
        stats[dropeoAgua] = 0;
        stats[suerteArmas] = 0;
        stats[suerteSigilo] = 0;
        stats[suerteGeneral] = 0;
        stats[suerteAgua] = 0;
        stats[suerteDaño] = 0;

        /* ----- ----- ARMAS ----- ----- */
        stats[dañoMaximoArma] = 0;

        /* ----- ----- BONUSES ----- ----- */
        stats[bonusAgua] = 10;
        stats[bonusSuerte] = 0;
        stats[bonusVendaje] = 7; // +7 de vida
        stats[bonusComida] = 5; // +5 de vida y 4 rondas +2
        stats[bonusComidaTurnos] = 2; // suma 2 durante 4 rondas
        stats[bonusMonster] = 10; // aumenta el minimo del arma actual en 10 puntos por la pelea que se usa

        /* ----- ----- CONTADORES ----- ----- */

        stats[monsters] = 0; // agarras uno en la puerta de la izquierda
        stats[vendajes] = 0; // agarras uno en la puerta de la izquierda
        stats[comidas] = 1; // no se explica porque no aparece - deberiamos explicarlo cuando aparezca
        stats[llavesComunes] = 0; // agarras una llave comun en la puerda de la izquierda -- se rompe despues de
                                  // usarla
        stats[botellasLlenas] = 0;
        stats[botellasVacias] = 0;

        /* ----- ----- ARMAS ----- ----- */

        stats[armaPrincipal] = 0;
        stats[armaSecundaria] = 0;

        /* ----- ----- ARMA PRINCIPAL ----- ----- */
        // 0 --> ningnuna
        // 1 --> cuchillo de cocina
        // 2 --> martillo
        // 3 --> palo de escoba

        /* ----- ----- ARMA SECUNDARIA ----- ----- */
        // 0 --> puños

        mensaje = "Antes de comenzar tu aventura ten en cuenta que hay algunos factores que irán determinando el estado de tu personaje, no dejes que la Vida llegue a 0 (cero)  o morirás. Cuando tu sed llegue a 100 (cien) morirás de sed.";
        devuelveElMensaje(mensaje, "El Edificio - Introducción", info);

        mensaje = "Las decisiones que tomes definirán tu camino, comenzarás con decisiones fáciles y luego serán más complicadas a medida que te vayas acostumbrando.";
        devuelveElMensaje(mensaje, "El Edificio - Introducción", info);

        JOptionPane.showMessageDialog(null, "> Vida = " + stats[vida] + "\n> Sed = " + stats[sed], "Tu estado inicial",
                JOptionPane.INFORMATION_MESSAGE);

        stats = capitulo01(stats);

        mensaje = "Felicitaciones, haz finalizado el Capítulo 01!! Estamos trabajando en los próximos, gracias por tu paciencia.";
        devuelveElMensaje(mensaje, "Fin Capítulo 01", info);

        statsJugador(stats);
        mochilaJugador(stats);

        if (stats[armaPrincipal] == 0) {
            JOptionPane.showMessageDialog(null,
                    "> Arma Principal = " + "no tienes arma principal" + "\n> Arma Secundaria = " + "puños",
                    "Tus armas", JOptionPane.INFORMATION_MESSAGE);
        } else if (stats[armaPrincipal] == 1) {
            JOptionPane.showMessageDialog(null,
                    "> Arma Principal = " + "cuchillo de cocina" + "\n> Arma Secundaria = " + "puños", "Tus armas",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (stats[armaPrincipal] == 2) {
            JOptionPane.showMessageDialog(null, "> Arma Principal = " + "martillo" + "\n> Arma Secundaria = " + "puños",
                    "Tus armas", JOptionPane.INFORMATION_MESSAGE);
        } else if (stats[armaPrincipal] == 3) {
            JOptionPane.showMessageDialog(null,
                    "> Arma Principal = " + "palo de escoba" + "\n> Arma Secundaria = " + "puños", "Tus armas",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static int[] capitulo01(int[] stats) {

        mensaje = "Son las 2 de la madrugada, estás sediento en un pasillo lúgubre. A lo lejos oyes un tintineo metálico. Tomas tu cantimplora, la abres sobre tu boca y esperas a que esa última gota de agua moje tus labios resecos. La saboreas sabiendo que no podrás tomar más hasta conseguir una nueva fuente de agua potable y finalmente la tragas. ";
        devuelveElMensaje(mensaje, "El Edificio - Capítulo 01", info);

        stats[sed] = stats[sed] - 1;

        statsJugador(stats);

        mensaje = "Estruendo proveniente de los pisos inferiores, te sobresaltas, trastabillas, y por poco caes por la escalera que tienes a tu derecha. Logras recuperarte pero tu cantimplora que tenías en la mano cae varios escalones abajo generando un ruido que resuena en todo el edificio.";
        devuelveElMensaje(mensaje, "El Edificio - Capítulo 01", alerta);

        mensaje = "El tintineo frena";
        String[] opciones = { "Tomas tu cantimplora", "La dejas allí" };

        int opcionElegida = devuelveLaOpcionElegida(mensaje, "¿Qué harás?", opciones, pregunta);

        if (opcionElegida == 0) {
            /* ----- ----- TOMAS TU CANTIMPLORA ----- ----- */
            String[] opcionElegida0 = { "Izquierda", "Derecha", "Habitación con luz" };

            mensaje = "Bajas la escalera haciendo el menor ruido posible, tomas tu cantimplora, la amarras a tu pantalón y continúas bajando hasta el piso inferior. Llegas a un nuevo pasillo. Optas por avanzar pisando suave para no hacer mucho ruido. Detrás de ti oyes unos pasos subir rápidamente las escaleras por lo que te ves obligado a acelerar tu paso. ";
            devuelveElMensaje(mensaje, "Tomas tu Cantimplora", info);

            mensaje = "Notas que unos metros adelante hay 3 puertas, una a cada lado del pasillo y una última al fondo del mismo. La del fondo está apenas abierta y de allí se escapa un haz de luz frío que llega hasta la puerta de la izquierda. Sigues avanzando y cuando estás por llegar a las dos puertas laterales, suena una alarma proveniente de la habitación con luz. Estás inmóvil.";
            int tresPuertas = devuelveLaOpcionElegida(mensaje, "¿Qué haces?", opcionElegida0, pregunta);

            if (tresPuertas == 0) {

                /* ----- ----- PUERTA DE LA IZQUIERDA ----- ----- */

                String[] objetosArmario1 = { "Monster", "Vendaje", "Una llave común" };

                mensaje = "Giras el picaporte y notas que la puerta está abierta, no hay luz pero aún así ingresas cerrando la puerta detrás tuyo. Los pasos que escuchabas subir por la escalera parecieran haber seguido de largo. Tanteas las paredes con tus manos y encuentras un interruptor de luz. Lo presionas y una tenue luz se prende.";
                devuelveElMensaje(mensaje, "Puerta de la Izquierda", info);

                mensaje = "Estás en un armario de limpieza. Ves tres objetos a tu alrededor pero solamente puedes llevar dos.";
                int objetoArmario1 = devuelveLaOpcionElegida(mensaje, "¿Qué haces?", objetosArmario1, pregunta);

                if (objetoArmario1 == 0) {
                    stats[monsters]++;
                    String[] objetosArmario2 = { "Vendaje", "Una llave común" };

                    mensaje = "Recuerda que deberás dejar un objeto atrás.";
                    int objetoArmario2 = devuelveLaOpcionElegida(mensaje, "¿Cuál escoges ahora?", objetosArmario2,
                            pregunta);

                    if (objetoArmario2 == 0) {
                        stats[vendajes]++;
                    } else if (objetoArmario2 == 1) {
                        stats[llavesComunes]++;
                    }

                } else if (objetoArmario1 == 1) {
                    stats[vendajes]++;
                    String[] objetosArmario2 = { "Monster", "Una llave común" };

                    mensaje = "Recuerda que deberás dejar un objeto atrás.";
                    int objetoArmario2 = devuelveLaOpcionElegida(mensaje, "¿Cuál escoges ahora?", objetosArmario2,
                            pregunta);
                    if (objetoArmario2 == 0) {
                        stats[monsters]++;
                    } else if (objetoArmario2 == 1) {
                        stats[llavesComunes]++;
                    }

                } else if (objetoArmario1 == 2) {
                    stats[llavesComunes]++;
                    String[] objetosArmario2 = { "Monster", "Vendaje" };

                    mensaje = "Recuerda que deberás dejar un objeto atrás.";
                    int objetoArmario2 = devuelveLaOpcionElegida(mensaje, "¿Cuál escoges ahora?", objetosArmario2,
                            pregunta);
                    if (objetoArmario2 == 0) {
                        stats[monsters]++;
                    } else if (objetoArmario2 == 1) {
                        stats[vendajes]++;
                    }
                }
                mochilaJugador(stats);

            } else if (tresPuertas == 1) {
                /* ----- ----- PUERTA DE LA DERECHA ----- ----- */

                mensaje = "Giras el picaporte, tiras con fuerza para abrir la puerta pero esta no se mueve. Está cerrada. Los pasos que suben por la escalera están muy cerca. Te das vuelta desesperado y vas a probar la puerta de la izquierda, giras el picaporte y se abre.";
                devuelveElMensaje(mensaje, "Puerta de la Derecha", alerta);

                statsJugador(stats);
                mochilaJugador(stats);

                stats = pelea(stats);

                statsJugador(stats);
                mochilaJugador(stats);

                if (stats[armaPrincipal] == 0) {
                    JOptionPane.showMessageDialog(null,
                            "> Arma Principal = " + "no tienes arma principal" + "\n> Arma Secundaria = " + "puños",
                            "Tus armas", JOptionPane.INFORMATION_MESSAGE);
                } else if (stats[armaPrincipal] == 1) {
                    JOptionPane.showMessageDialog(null,
                            "> Arma Principal = " + "cuchillo de cocina" + "\n> Arma Secundaria = " + "puños",
                            "Tus armas", JOptionPane.INFORMATION_MESSAGE);
                } else if (stats[armaPrincipal] == 2) {
                    JOptionPane.showMessageDialog(null,
                            "> Arma Principal = " + "martillo" + "\n> Arma Secundaria = " + "puños", "Tus armas",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (stats[armaPrincipal] == 3) {
                    JOptionPane.showMessageDialog(null,
                            "> Arma Principal = " + "palo de escoba" + "\n> Arma Secundaria = " + "puños", "Tus armas",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

            else if (tresPuertas == 2) {

                /* ----- ----- HABITACION CON LUZ ----- ----- */

                stats = cuartoConLuz(stats);
                statsJugador(stats);
            }

        } else if (opcionElegida == 1) {
            /* ----- ----- DEJAS TU CANTIMPLORA ALLÍ ----- ----- */

            String[] pasilloSinCantimplora = { "Empujas la puerta fuertemente",
                    "Corres hacia atrás y subes al piso superior" };

            mensaje = "Para tus adentros sientes que has cometido un error gravísimo, no tienes tiempo para agarrar la cantimplora, seguro más adelante encontrarás otra, sientes ganas de salir de ese lugar. Miras a tus alrededores rápidamente, no sabes qué hacer. ";
            devuelveElMensaje(mensaje, "Dejas tu cantimplora", info);

            mensaje = "Oyes varios pasos subir rápidamente las escaleras por lo que comienzas a caminar desesperadamente hacia delante, hacia la oscuridad del pasillo. Hay tan poca luz que tienes que usar tus manos para guiarte. Te encuentras una puerta, pero parece estar trabada del otro lado porque no puedes abrirla. Quizás si la empujas fuertemente puedes llegar a abrirla o tal vez lo mejor sea volver rápidamente hacia atrás y subir al piso superior.";

            int puertaPesada = devuelveLaOpcionElegida(mensaje, "La puerta", pasilloSinCantimplora, pregunta);

            if (puertaPesada == 0) {
                /* ----- ----- EMPUJAS LA PUERTA FUERTEMENTE ----- ----- */
            } else if (puertaPesada == 1) {
                /* ----- ----- CORRES HACIA ATRÁS Y SUBES AL PISO SUPERIOR ----- ----- */
            }
        }
        return stats;
    }

    public static int[] pelea(int[] stats) {

        Random random = new Random();

        /* ----- ----- COMIDAS ----- ----- */

        boolean flagComidas = false;

        /* ------------------------- */
        /* ARRAYS ENEMIGOS */
        /* ------------------------- */
        String enemigos[] = { "un chico del delivery", "una anciana", "un leñador", "una nerd",
                "uno de los programadores de este juego", "una doctora", "un tipo en un disfraz de empanada",
                "una pop star", "un coplayer", "una chica militar", "un payaso" };
        String armasEnemigos[] = { "un látigo", "un palo de amasar", "un martillo", "una katana", "una cámara de fotos",
                "un cuchillo", "una motosierra", "una ballesta", "un bazuka" };

        int[] statsEnemigo = elegirEnemigo(enemigos, armasEnemigos);

        enemigo = enemigos[statsEnemigo[0]];
        vidaEnemigo = statsEnemigo[1];
        armaEnemigo = armasEnemigos[statsEnemigo[2]];
        dañoMaximoEnemigo = statsEnemigo[3];
        dañoRebote = statsEnemigo[4];

        String eleccion[] = { "Pelear", "Huir" };
        int contacto = JOptionPane.showOptionDialog(null,
                "\n Ingresas en la habitación lo más rápido que puedes y cuando estás cerrando la puerta detrás "
                        + "\n tuyo notas que esta no se mueve, te volteas y ves a " + enemigo + " con " + armaEnemigo,
                "Primer combate", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, eleccion, eleccion[0]);

        JOptionPane.showMessageDialog(null,
                "Ten en cuenta que:" + "\nSi superas las 10 rondas de combate, morirás de cansancio."
                        + "\nLuego de cada ronda de combate ganarás 1 punto de sed.",
                "Aclaraciones", JOptionPane.INFORMATION_MESSAGE);

        if (contacto == 0) {
            /* ----- ----- PELEAR ----- ----- */
            JOptionPane.showMessageDialog(null, "\t> Tu enemigo es " + enemigo + " con " + armaEnemigo
                    + "\n\t>Tiene un daño máximo de: " + dañoMaximoEnemigo + "\n\t> Vida: " + vidaEnemigo);

            statsJugador(stats);
            mochilaJugador(stats);

            if (stats[armaPrincipal] == 0) {
                stats[dañoMaximoArma] = 5;
                arma = "puños";
                JOptionPane.showMessageDialog(null,
                        "> Arma Principal = " + "no tienes arma principal" + "\n> Arma Secundaria = " + "puños",
                        "Tus armas", JOptionPane.INFORMATION_MESSAGE);
            } else if (stats[armaPrincipal] == 1) {
                stats[dañoMaximoArma] = 30;
                arma = "cuchillo de cocina";
                JOptionPane.showMessageDialog(null,
                        "> Arma Principal = " + "cuchillo de cocina" + "\n> Arma Secundaria = " + "puños", "Tus armas",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (stats[armaPrincipal] == 2) {
                stats[dañoMaximoArma] = 40;
                arma = "martillo";
                JOptionPane.showMessageDialog(null,
                        "> Arma Principal = " + "martillo" + "\n> Arma Secundaria = " + "puños", "Tus armas",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (stats[armaPrincipal] == 3) {
                stats[dañoMaximoArma] = 20;
                arma = "palo de escoba";
                JOptionPane.showMessageDialog(null,
                        "> Arma Principal = " + "palo de escoba" + "\n> Arma Secundaria = " + "puños", "Tus armas",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            stats[dañoJugador] = random.nextInt(stats[dañoMaximoArma]) + stats[bonusMonster];
            dañoEnemigo = random.nextInt(dañoMaximoEnemigo);

            stats[vida] = stats[vida] - dañoEnemigo;
            vidaEnemigo = vidaEnemigo - stats[dañoJugador];
            System.out.println("ronda: " + rondas);
            rondas++;
            mensajeRonda(stats);

            int rondasComidas = 0;

            boolean flagFinTurno = false;

            while (rondas <= 10) {
                System.out.println("ronda1: " + rondas);
                while (stats[vida] > 0 && vidaEnemigo > 0 && stats[sed] < 100 && flagFinTurno == false) {

                    /* ----- ----- INICIO PELEA Y CICLO WHILE ----- ----- */

                    int accion;
                    int accionBonus;

                    /* ----- ----- DECISION ----- ----- */
                    String accionJugador[] = { "Atacar", "Revisar la mochila" };

                    accion = JOptionPane.showOptionDialog(null, "> ¿Qué deseas hacer?", "Acción",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, accionJugador,
                            accionJugador[0]);

                    if (accion == 0) {
                        /* ----- ----- ATACAR ----- ----- */
                        stats[dañoJugador] = random.nextInt(stats[dañoMaximoArma]) + stats[bonusMonster];
                        dañoEnemigo = random.nextInt(dañoMaximoEnemigo);

                        stats[vida] = stats[vida] - dañoEnemigo;
                        vidaEnemigo = vidaEnemigo - stats[dañoJugador] - dañoRebote;
                        flagFinTurno = true;

                    } else if (accion == 1) {
                        /* ----- ----- REVISAR LA MOCHILA ----- ----- */

                        String bonus[] = { "Vendaje", "Comida", "Daño", "Mejor Peleo" };

                        accionBonus = JOptionPane.showOptionDialog(null, "¿Qué bonus desea tomar de tu mochila?",
                                "Bonus", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, bonus,
                                bonus[0]);

                        if (accionBonus == 0) {
                            /* ----- ----- VENDAJE ----- ----- */

                            if (stats[vendajes] > 0) {
                                stats[vida] = stats[vida] + stats[bonusVendaje];
                                stats[vendajes]--;

                                mensaje = ">Te haz curado " + stats[bonusVendaje] + " puntos de vida." + saltoLinea
                                        + ">Te quedan: " + stats[vendajes] + " vendajes.";

                                devuelveElMensaje(mensaje, "Vendajes", alerta);
                                statsJugador(stats);

                                dañoEnemigo = random.nextInt(dañoMaximoEnemigo);
                                stats[vida] = stats[vida] - dañoEnemigo;
                                stats[dañoJugador] = 0;
                                vidaEnemigo = vidaEnemigo - stats[dañoJugador] - dañoRebote;

                                flagFinTurno = true;

                            } else {
                                mensaje = ">No te quedan más vendajes";
                                devuelveElMensaje(mensaje, "Vendajes", alerta);

                            }

                        } else if (accionBonus == 1) {
                            /* ----- ----- COMIDAS ----- ----- */
                            if (stats[comidas] > 0) {
                                stats[comidas]--;
                                flagComidas = true;

                                stats[vida] = stats[vida] + stats[bonusComidaTurnos];

                                mensaje = ">Haz sumado " + stats[bonusComidaTurnos] + " puntos de vida." + saltoLinea
                                        + ">Te quedan: " + stats[comidas] + " comidas.";
                                devuelveElMensaje(mensaje, "Comidas", alerta);
                                statsJugador(stats);

                                rondasComidas++;

                                dañoEnemigo = random.nextInt(dañoMaximoEnemigo);
                                stats[vida] = stats[vida] - dañoEnemigo;
                                stats[dañoJugador] = 0;
                                vidaEnemigo = vidaEnemigo - stats[dañoJugador] - dañoRebote;

                                flagFinTurno = true;

                            } else {

                                mensaje = ">No te quedan más comidas";
                                devuelveElMensaje(mensaje, "Comidas", alerta);

                            }

                        } else if (accionBonus == 2) {
                            /* ----- ----- MONSTERS ----- ----- */

                            if (stats[monsters] > 0) {
                                stats[monsters]--;

                                mensaje = ">Haz sumado " + stats[bonusMonster] + " puntos de daño." + saltoLinea
                                        + ">Te quedan: " + stats[monsters] + "monsters.";
                                devuelveElMensaje(mensaje, "Monsters", alerta);

                                mensaje = ">Tu nuevo daño mínimo es de: " + stats[bonusMonster] + " por esta pelea.";
                                devuelveElMensaje(mensaje, "Monsters", info);

                                dañoEnemigo = random.nextInt(dañoMaximoEnemigo);
                                stats[vida] = stats[vida] - dañoEnemigo;
                                stats[dañoJugador] = 0;
                                vidaEnemigo = vidaEnemigo - stats[dañoJugador] - dañoRebote;

                                flagFinTurno = true;

                            } else {
                                mensaje = ">No te quedan más monsters";
                                devuelveElMensaje(mensaje, "Monsters", alerta);
                            }

                        } else if (accionBonus == 3) {
                            /* ----- ----- MEJOR PELEO ----- ----- */
                            stats[dañoJugador] = random.nextInt(stats[dañoMaximoArma]) + stats[bonusMonster];
                            dañoEnemigo = random.nextInt(dañoMaximoEnemigo);
                            vidaEnemigo = vidaEnemigo - stats[dañoJugador] - dañoRebote;
                            stats[vida] = stats[vida] - dañoEnemigo;

                            flagFinTurno = true;

                        }
                    }

                    if (flagComidas == true && rondasComidas < 3) {
                        stats[vida] = stats[vida] + stats[bonusComidaTurnos];
                        mensaje = ">Gracias al efecto de la comida que haz consumido, haz sumado: "
                                + stats[bonusComidaTurnos] + " puntos de vida más esta ronda." + saltoLinea
                                + ">Seguirás sumando vida por " + (3 - rondasComidas) + " rondas de pelea más.";
                        devuelveElMensaje(mensaje, "Comidas", info);
                        statsJugador(stats);

                        rondasComidas++;

                    } else {
                        if (rondasComidas == 3) {
                            flagComidas = false;
                        }
                    }

                }

                stats[sed]++;
                rondas++;
                mensajeRonda(stats);

                flagFinTurno = false;
            } /* ----- ----- FIN DEL WHILE LOOP ----- ----- */

            /* ----- ----- FUERON MAS DE 10 RONDAS ----- ----- */
            if (rondas > 10)

            {
                JOptionPane.showMessageDialog(null,
                        "Estás tan cansado por estas " + rondas + " rondas de pelea que no puedes luchar. Game Over. ",
                        "Game Over", JOptionPane.ERROR_MESSAGE);

            } else if (stats[sed] >= 100) {
                JOptionPane.showMessageDialog(null,
                        "Esta pelea te ha agotado tanto que haz muerto de sed." + "\nGame Over.", "Game Over",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                /* ----- ----- EL JUGADOR GANA LA PELEA ----- ----- */
                if (stats[vida] > 0 && vidaEnemigo <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Felicitaciones, has matado a " + enemigo + " en " + rondas + " rondas.",
                            "Ganaste la pelea", JOptionPane.INFORMATION_MESSAGE);
                    /* ----- ----- DROPEO DE AGUA ----- ----- */

                    stats[dropeoAgua] = random.nextInt(9) + 1;

                    if (stats[dropeoAgua] >= 5) {
                        stats[botellasLlenas]++;

                        JOptionPane.showMessageDialog(null, enemigo + " ha tirado 1 botella de agua llena.");
                        mochilaJugador(stats);

                    }
                } /* ----- ----- PIERDE LA PELEA - SIN VIDA ----- ----- */
                else if (stats[vida] <= 0 && vidaEnemigo > 0) {
                    JOptionPane.showMessageDialog(null, "Has muerto en " + rondas + " rondas. Game Over.", "Game Over",
                            JOptionPane.ERROR_MESSAGE);
                } /* ----- ----- MUEREN LOS 2 ----- ----- */
                else if (stats[vida] <= 0 && vidaEnemigo <= 0) {
                    JOptionPane.showMessageDialog(null, "Has matado a " + enemigo + " en " + rondas + " rondas "
                            + "pero también has muerto. Game Over. ", "Game Over", JOptionPane.ERROR_MESSAGE);

                }
            }

            return stats;
        } /* ----- ----- FIN DEL IF PRINCIPAL - PELEA ----- ----- */

        else if (contacto == 1)

        {

            /* ----- ----- HUIR ----- ----- */
            stats[suerte] = stats[bonusSuerte] + random.nextInt(99) + 1;

            if (stats[suerte] > 50) {
                JOptionPane.showMessageDialog(null, " Has podido escapar con suerte. ");
            } else {

                JOptionPane.showMessageDialog(null,
                        " Tu enemigo te atrapó al intentar escapar. \n\t> Estás muerto. Game Over.", "Game Over.",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return stats;

    }

    /* ----- ----- ESTADOS JUGADOR ----- ----- */

    public static void mensajeRonda(int[] stats) {
        JOptionPane.showMessageDialog(null,
                "Ronda: " + rondas + saltoLinea + saltoLinea + ">El ataque de " + enemigo + " con " + armaEnemigo
                        + " es de: " + dañoEnemigo + saltoLinea + ">Tu vida restante es de: " + stats[vida] + saltoLinea
                        + saltoLinea + ">Tu bonus de daño es de: " + stats[bonusMonster] + saltoLinea
                        + ">Tu ataque total con " + arma + " es de: " + stats[dañoJugador] + saltoLinea
                        + ">La vida restante de " + enemigo + " es de: " + vidaEnemigo);
    }

    public static void statsJugador(int[] stats) {
        JOptionPane.showMessageDialog(null, "> Vida = " + stats[vida] + saltoLinea + "> Sed = " + stats[sed],
                "Tu estado actual", alerta);
    }

    public static void mochilaJugador(int[] stats) {
        JOptionPane.showMessageDialog(null,
                "> Monsters = " + stats[monsters] + saltoLinea + "> Vendajes = " + stats[vendajes] + saltoLinea
                        + "> Comidas = " + stats[comidas] + saltoLinea + "> Llaves Comunes = " + stats[llavesComunes]
                        + saltoLinea + "> Botellas Llenas = " + stats[botellasLlenas] + saltoLinea
                        + "> Botellas Vacias = " + stats[botellasVacias],
                "Tu mochila", info);
    }

    /* ----- ----- HABITACIONES ALEATORIAS ----- ----- */

    public static int[] cuartoConLuz(int[] stats) {
        Random random = new Random();

        int randomCuartoTrampa;
        int randomPosiblePremio;
        int largoPosiblePremio;
        int largoCuartoTrampa;

        String[] cuartoTrampa = { "Biombo", "Ahorcado", "Caminos", "Pelea" };

        String[] posiblePremio = { "Botella de agua", "Chebuzan de milanga", "Martillo", "Capa de harry" };

        largoCuartoTrampa = cuartoTrampa.length;
        largoPosiblePremio = posiblePremio.length;

        randomCuartoTrampa = random.nextInt(largoCuartoTrampa); // del 0 al maximo del array
        randomPosiblePremio = random.nextInt(largoPosiblePremio); // del 0 al maximo del array

        // System.out.println(cuartoTrampa[juegos(cuartoTrampa, 0)]);
        System.out.println(" ");
        System.out.println("largo de cuartoTrampa: " + cuartoTrampa.length);
        System.out.println("random de cuartoTrampa: " + randomCuartoTrampa);
        System.out.println("--------------------------------------------------------");
        System.out.println("largo de posiblePremio: " + posiblePremio.length);
        System.out.println("random de posiblePremio: " + randomPosiblePremio);
        System.out.println(" ");

        if (randomCuartoTrampa == 0) {
            /* ----- ----- biombo ----- ----- */
            stats = biombo(stats);
        } else if (randomCuartoTrampa == 1) {
            /* ----- ----- ahorcado ----- ----- */
            JOptionPane.showMessageDialog(null, "Entraste al ahorcado. Perdiste 50 puntos de vida.", "Codeandose",
                    JOptionPane.INFORMATION_MESSAGE);
            stats[vida] = 50;
        } else if (randomCuartoTrampa == 2) {
            /* ----- ----- caminos ----- ----- */
            stats = caminosDiferentes(stats);
        } else if (randomCuartoTrampa == 3) {
            /* ----- ----- pelea ----- ----- */
            stats = pelea(stats);
        }
        // System.out.println(posiblePremio[cofre(posiblePremio, 0)]);

        return stats;
    }

    public static int[] caminosDiferentes(int[] stats) {

        // tenes que elegir el camino correcto sin saber las opciones,
        // Ver opciones de pistas
        // ver tema de niveles --> hablar con charly

        Random random = new Random();

        int dañoTrampas = 0;
        int counter = 0;

        int randomInt1, randomInt2, randomInt3;
        String randomString1, randomString2, randomString3;

        boolean caminoCompleto = false;

        randomInt1 = random.nextInt(3) + 1;
        randomInt2 = random.nextInt(3) + 1;
        randomInt3 = random.nextInt(3) + 1;

        /*
         * ----- ----- toma el valor del randomInt y lo convierte a una string -----
         */
        randomString1 = String.valueOf(randomInt1);
        randomString2 = String.valueOf(randomInt2);
        randomString3 = String.valueOf(randomInt3);

        /*
         * sino tiene un string dentro del array, las opciones Integer no funcionan
         * dentro del Optiondialog --> necesitaria un objeto
         */

        // Object[] elecciones = {randomInt1,randomInt2,randomInt3};

        System.out.println("camino correcto: A" + randomString1 + ", B" + randomString2 + " y C" + randomString3);

        while (stats[vida] > 0 && caminoCompleto != true && counter < 3) {
            JOptionPane.showMessageDialog(null, "> Vida = " + stats[vida] + "\n> Sed = " + stats[sed],
                    "Tu estado actual", JOptionPane.INFORMATION_MESSAGE);

            /* ------------------------- */
            /* FILA A */
            /* ------------------------- */
            if (counter == 0) {
                System.out.println("primer pregunta");
                String[] eleccionA = { "1", "2", "3" };
                int opcionElegidaA = JOptionPane.showOptionDialog(null, "Escoge que camino seguir", "Título",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionA, eleccionA[0]);

                dañoTrampas = 35;
                counter++;

                if (opcionElegidaA == 0) {
                    /* ----- ----- ELEGI LA OPCION 1 ----- ----- */
                    if (randomString1.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre unos pinches que te han quitado: " + dañoTrampas + " puntos de vida.",
                                "No era el inicio seguro", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;

                    }

                } else if (opcionElegidaA == 1) {
                    /* ----- ----- ELEGI LA OPCION 2 ----- ----- */
                    if (randomString1.equals("2")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre unos pinches que te han quitado: " + dañoTrampas + " puntos de vida.",
                                "No era el inicio seguro", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;
                    }
                } else if (opcionElegidaA == 2) {
                    /* ----- ----- ELEGI LA OPCION 3 ----- ----- */
                    if (randomString1.equals("3")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre unos pinches que te han quitado: " + dañoTrampas + " puntos de vida.",
                                "No era el inicio seguro", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;

                    }
                }

                /* ------------------------- */
                /* FILA B */
                /* ------------------------- */
            } else if (counter == 1) {
                System.out.println("segunda pregunta");
                String[] eleccionB = { "1", "2", "3" };
                int opcionElegidaB = JOptionPane.showOptionDialog(null, "Escoge que camino seguir", "Título",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionB, eleccionB[0]);

                dañoTrampas = 65;
                counter++;

                if (opcionElegidaB == 0) {
                    /* ----- ----- ELEGI LA OPCION 1 ----- ----- */
                    if (randomString2.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (randomString2.equals("2")) {
                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre una plataforma llena de serpietes que te han picado por: " + dañoTrampas
                                        + " puntos de daño.",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;

                    } else if (randomString2.equals("3")) {
                        stats[vida] = 0;
                        JOptionPane.showMessageDialog(null,
                                "Al caer sobre la plataforma patinas dado que estaba recubierta de aceite y caes al vacío. ",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                    }

                } else if (opcionElegidaB == 1) {
                    /* ----- ----- ELEGI LA OPCION 2 ----- ----- */
                    if (randomString2.equals("2")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (randomString2.equals("3")) {
                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre una plataforma llena de serpietes que te han picado por: " + dañoTrampas
                                        + " puntos de daño.",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;
                    } else if (randomString2.equals("1")) {
                        stats[vida] = 0;
                        JOptionPane.showMessageDialog(null,
                                "Al caer sobre la plataforma patinas dado que estaba recubierta de aceite y caes al vacío. ",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                    }

                } else if (opcionElegidaB == 2) {
                    /* ----- ----- ELEGI LA OPCION 3 ----- ----- */
                    if (randomString2.equals("3")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (randomString2.equals("1")) {

                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre una plataforma llena de serpietes que te han picado por: " + dañoTrampas
                                        + " puntos de daño.",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;
                    } else if (randomString2.equals("2")) {
                        stats[vida] = 0;
                        JOptionPane.showMessageDialog(null,
                                "Al caer sobre la plataforma patinas dado que estaba recubierta de aceite y caes al vacío. ",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                    }
                }

                /* ------------------------- */
                /* FILA C */
                /* ------------------------- */
            } else if (counter == 2) {
                System.out.println("tercer pregunta");
                String[] eleccionC = { "1", "2", "3" };
                int opcionElegidaC = JOptionPane.showOptionDialog(null, "Escoge que camino seguir", "Título",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionC, eleccionC[0]);
                caminoCompleto = true;
                dañoTrampas = 85;
                counter++;

                if (opcionElegidaC == 0) {
                    /* ----- ----- ELEGI LA OPCION 1 ----- ----- */
                    if (randomString3.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre una plataforma llena de serpietes y pinchos que te han quitado: "
                                        + dañoTrampas + " puntos de vida.",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;

                    }

                } else if (opcionElegidaC == 1) {
                    /* ----- ----- ELEGI LA OPCION 2 ----- ----- */
                    if (randomString3.equals("2")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre una plataforma llena de serpietes y pinchos que te han quitado: "
                                        + dañoTrampas + " puntos de vida.",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;
                    }
                } else if (opcionElegidaC == 2) {
                    /* ----- ----- ELEGI LA OPCION 3 ----- ----- */
                    if (randomString3.equals("3")) {
                        JOptionPane.showMessageDialog(null, "Elegiste bien la plataforma", "Zafaste",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {

                        JOptionPane.showMessageDialog(null,
                                "Saltaste sobre una plataforma llena de serpietes y pinchos que te han quitado: "
                                        + dañoTrampas + " puntos de vida.",
                                "No era el mejor camino este", JOptionPane.WARNING_MESSAGE);
                        stats[vida] = stats[vida] - dañoTrampas;
                    }
                }
            }
        }

        if (stats[vida] <= 0) {
            System.out.println("counter: " + counter);
            JOptionPane.showMessageDialog(null, "Has muerto", "Game Over", JOptionPane.INFORMATION_MESSAGE);

        } else if (stats[vida] > 0 && caminoCompleto == true) {
            System.out.println("counter: " + counter);
            JOptionPane.showMessageDialog(null, "Felicitaciones, has pasado la prueba.", "Zafaste",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("counter: " + counter);
            JOptionPane.showMessageDialog(null, "No se como llegaste acá", "Imposible",
                    JOptionPane.INFORMATION_MESSAGE);

        }

        return stats;
    }

    public static int[] biombo(int[] stats) {

        JOptionPane.showMessageDialog(null,
                "Te apresuras a avanzar haciendo el menor ruido posible porque oyes los pasos cada vez más cerca. "
                        + "\n Llegas a la puerta entornada, te arrimas un poco para pispear dentro y parece que no hay nadie. "
                        + "\n Empujas la puerta, ingresas y la entornas como estaba antes detrás tuyo.",
                "Habitación con luz", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "Ya dentro miras donde has ingresado. En el centro de la habitación ves un escritorio y una silla. "
                        + "\n Sobre el escritorio hay una máquina de escribir con una hoja y un pequeño monitor de vigilancia "
                        + "\n que ilumina todo el conjunto con una luz fría.");

        String[] maquinaEscribir = { "Te sientas", "Buscas como salir de allí" };

        int opcionMaquinaEscribir = JOptionPane.showOptionDialog(null,
                "Te acercas al escritorio para ver la pantalla y te apoyas sobre el respaldo de la silla con una mano. "
                        + "\n La imagen del televisor se cambia a ruido blanco e inmediatamente después la imagen se torna negra "
                        + "\n y ves cómo se va escribiendo el siguiente mensaje en la pantalla:",
                "¿Qué haces?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, maquinaEscribir,
                maquinaEscribir[0]);

        if (opcionMaquinaEscribir == 0) {
            /* ----- ----- TE SIENTAS EN EL ESCRITORIO ----- ----- */
            JOptionPane.showMessageDialog(null,
                    "Intentas arrastrar la silla hacia atrás y notas que no es tan fácil, hay una cierta resistencia que la frena. "
                            + "\n Tomas la silla con la otra mano y la arrastras lo más fuerte que puedes con ambas manos. La silla se mueve "
                            + "\n rápidamente y se frena sola.",
                    "Te sientas", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,
                    "Te sientas en la silla e inmediatamente esta se mueve hacia adelante apretándonte contra el escritorio y "
                            + "\n dejándote inmóvil. Delante de tí, en la pantalla, el mensaje anterior se borra y se escribe la siguiente palabra:"
                            + "\n 'Escoge'",
                    "Te sientas", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null,
                    "Notas que la hoja en la máquina de escribir tiene una serie de letras escritas hacia abajo. Una letra por renglón:"
                            + "\n N" + "\n Ñ" + "\n Q" + "\n R" + "\n T" + "\n W",
                    "Te sientas", JOptionPane.INFORMATION_MESSAGE);

            String[] opcionesLetras = { "X", "Y" };
            JOptionPane.showOptionDialog(null,
                    "La imagen del televisor cambia a ruido blanco y luego la pantalla se divide en dos recuadros mostrando una imagen "
                            + "\n estática en cada uno. En la esquina superior izquierda de cada recuadro ves una letra de color verde."
                            + "\n La imagen de la izquierda - letra “X” - muestra un río."
                            + "\n La imagen de la derecha - letra “Y” -  muestra una nube.",
                    "Escoge", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesLetras,
                    opcionesLetras[0]);
        } else if (opcionMaquinaEscribir == 1) {
            /* ----- ----- FALTA DECISION - BUSCAS COMO SALIR DE ALLI ----- ----- */
        }

        return stats;
    }

    /* ----- ----- POSIBLE PREMIO ----- ----- */

    public static int cofre(String[] premio, int posicionPremio) {
        Random random = new Random();

        posicionPremio = random.nextInt(premio.length);

        if (posicionPremio == 0) {
            return posicionPremio;
        } else if (posicionPremio == 1) {
            return posicionPremio;
        } else if (posicionPremio == 2) {
            return posicionPremio;
        } else {
            return posicionPremio;
        }
    }

    /* ----- ----- ENEMIGOS Y ARMAS ----- ----- */

    public static int[] elegirEnemigo(String[] enemigos, String[] armaEnemigos) {
        Random random = new Random();

        int vidaEnemigo = 0;
        int posicionEnemigoSeleccionado = 0;
        int posicionArmaEnemigo = 0;
        int dañoMaximoArmaEnemigo = 0;
        int dañoRebote = 0;

        posicionEnemigoSeleccionado = random.nextInt(enemigos.length);
        int[] armaSeleccionada;

        int[] statsEnemigo = { posicionEnemigoSeleccionado, vidaEnemigo, posicionArmaEnemigo, dañoMaximoArmaEnemigo,
                dañoRebote };

        switch (posicionEnemigoSeleccionado) {
            case 0: // delivery
                statsEnemigo[1] = random.nextInt(100) + 50;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 1: // anciana
                statsEnemigo[1] = random.nextInt(200) + 50;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];
                break;
            case 2: // leñador
                statsEnemigo[1] = random.nextInt(300) + 100;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 3:// nerd
                statsEnemigo[1] = random.nextInt(250) + 50;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 4:// programadores
                statsEnemigo[1] = random.nextInt(400) + 100;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 5:// doctora
                statsEnemigo[1] = random.nextInt(150) + 50;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 6:// empanada
                statsEnemigo[1] = random.nextInt(150) + 25;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 7:// pop star
                statsEnemigo[1] = random.nextInt(300) + 25;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 8:// cosplayer
                statsEnemigo[1] = random.nextInt(400) + 50;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 9:// chica militar
                statsEnemigo[1] = random.nextInt(500) + 75;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

            case 10:// payaso
                statsEnemigo[1] = random.nextInt(650) + 100;
                armaSeleccionada = elegirArmaEnemigo(armaEnemigos);
                statsEnemigo[2] = armaSeleccionada[0];
                statsEnemigo[3] = armaSeleccionada[1];
                statsEnemigo[4] = armaSeleccionada[2];

                break;

        }

        return statsEnemigo;

    }

    public static int[] elegirArmaEnemigo(String[] armaEnemigos) {
        Random random = new Random();
        int dañoMaximoArma = 0;

        int posicionArmaSeleccionada = 0;
        posicionArmaSeleccionada = random.nextInt(armaEnemigos.length);

        int dañoRebote = 0;

        int[] statsArma = { posicionArmaSeleccionada, dañoMaximoArma, dañoRebote };

        switch (posicionArmaSeleccionada) {
            case 0: // látigo
                statsArma[1] = random.nextInt(30);

                break;

            case 1: // palo de amasar
                statsArma[1] = random.nextInt(15) + 0;

                break;
            case 2: // martillo
                statsArma[1] = random.nextInt(60);

                break;

            case 3:// katana
                statsArma[1] = random.nextInt(65) + 15;

                break;

            case 4:// cámara
                statsArma[1] = random.nextInt(10);

                break;

            case 5:// cuchillo
                statsArma[1] = random.nextInt(70);

                break;

            case 6:// motosierra
                statsArma[1] = random.nextInt(125) + 25;

                break;

            case 7:// ballesta
                statsArma[1] = random.nextInt(50);

                break;

            case 8:// bazuka
                statsArma[1] = random.nextInt(200) + 15;
                statsArma[2] = random.nextInt(200);
                while (statsArma[2] > statsArma[1]) {
                    statsArma[2] = random.nextInt(200);
                }

                break;

        }

        return statsArma;

    }

    /* ----- ----- MENSAJES ----- ----- */

    /* ----- ----- MAX/MIN CANTIDAD DE CARACTERES X LINEA ----- ----- */
    public static int caracteresMinimosPrimerRenglon = 0;
    public static int caracteresMaximosPrimerRenglon = 160;

    public static String mensajeFormateado(String mensaje) {

        double largoMensaje;
        double cantidadRenglonesDouble;
        double cantidadRenglonesToInt;

        largoMensaje = mensaje.length();

        cantidadRenglonesDouble = largoMensaje / caracteresMaximosPrimerRenglon;

        cantidadRenglonesToInt = Math.round(cantidadRenglonesDouble);

        if (cantidadRenglonesToInt > 1) {
            mensaje = mensajeMultiplesLineasToInt(mensaje, cantidadRenglonesDouble);
        }
        return mensaje;
    }

    public static String mensajeMultiplesLineasToInt(String mensaje, double cantidadRenglones) {
        String ultimoCaracterPrimeraLinea = mensaje.substring(caracteresMaximosPrimerRenglon - 1,
                caracteresMaximosPrimerRenglon);
        int largoMaximoPrimerRenglonDistintoEspacio = 0;

        for (int i = 0; i < 100; i++) {

            if (!ultimoCaracterPrimeraLinea.equals(" ")) {
                largoMaximoPrimerRenglonDistintoEspacio = caracteresMaximosPrimerRenglon + i;

                ultimoCaracterPrimeraLinea = mensaje.substring(largoMaximoPrimerRenglonDistintoEspacio - 1,
                        largoMaximoPrimerRenglonDistintoEspacio);

            }

        }
        String mensajeFormateado = "";
        int ultimoCaracter = mensaje.length();
        if (largoMaximoPrimerRenglonDistintoEspacio > 1) {
            mensajeFormateado = mensaje.substring(caracteresMinimosPrimerRenglon,
                    largoMaximoPrimerRenglonDistintoEspacio);
        } else {
            mensajeFormateado = mensaje.substring(caracteresMinimosPrimerRenglon, caracteresMaximosPrimerRenglon);
        }

        for (int i = 0; i <= cantidadRenglones + 1; i++) {

            int minimoSiguienteRenglon = 0;
            int maximoSiguienteRenglon = 0;

            if (i > 1 && i <= cantidadRenglones) {

                maximoSiguienteRenglon = caracteresMaximosPrimerRenglon * i;
                minimoSiguienteRenglon = minimoSiguienteRenglon + caracteresMaximosPrimerRenglon * (i - 1);

                String ultimoCaracterSiguienteLinea = mensaje.substring(maximoSiguienteRenglon - 1,
                        maximoSiguienteRenglon);

                for (int j = 0; j < 50; j++) {
                    if (!ultimoCaracterSiguienteLinea.equals(" ")) {
                        maximoSiguienteRenglon++;

                        ultimoCaracterSiguienteLinea = mensaje.substring(maximoSiguienteRenglon - 1,
                                maximoSiguienteRenglon);
                    }

                }

                String anteUltimoCaracterEsPunto = mensaje.substring(maximoSiguienteRenglon - 2,
                        maximoSiguienteRenglon - 1);

                if (anteUltimoCaracterEsPunto.equals(".")) {

                    String primerCaracterEsPunto = mensaje.substring(0 + caracteresMaximosPrimerRenglon * i,
                            1 + caracteresMaximosPrimerRenglon * i);

                    primerCaracterEsPunto = primerCaracterEsPunto.replace(".", " ");

                    mensajeFormateado = mensajeFormateado + saltoLinea
                            + mensaje.substring(minimoSiguienteRenglon, maximoSiguienteRenglon);
                } else {

                    mensajeFormateado = mensajeFormateado + saltoLinea
                            + mensaje.substring(minimoSiguienteRenglon, maximoSiguienteRenglon);
                }

            } else if (i > cantidadRenglones) {

                maximoSiguienteRenglon = caracteresMaximosPrimerRenglon * i;
                minimoSiguienteRenglon = minimoSiguienteRenglon + caracteresMaximosPrimerRenglon * (i - 1);

                String ultimoCaracterAnteultimaLinea = mensaje.substring(minimoSiguienteRenglon - 1,
                        minimoSiguienteRenglon);

                for (int j = 0; j < 50; j++) {
                    if (!ultimoCaracterAnteultimaLinea.equals(" ")) {
                        minimoSiguienteRenglon++;

                        ultimoCaracterAnteultimaLinea = mensaje.substring(minimoSiguienteRenglon - 1,
                                minimoSiguienteRenglon);
                    }

                }

                int caracteresSobrantes = ultimoCaracter - minimoSiguienteRenglon;

                if (caracteresSobrantes > 0) {

                    mensajeFormateado = mensajeFormateado + saltoLinea
                            + mensaje.substring(minimoSiguienteRenglon, ultimoCaracter);

                } else {

                    mensajeFormateado = mensajeFormateado + saltoLinea
                            + mensaje.substring(minimoSiguienteRenglon, ultimoCaracter);

                }

            }

        }

        return mensajeFormateado;
    }

    public static int devuelveLaOpcionElegida(String mensaje, String titulo, String[] arrayOpciones, int pregunta) {

        int opcionElegida = JOptionPane.showOptionDialog(null, mensajeFormateado(mensaje), titulo,
                JOptionPane.DEFAULT_OPTION, pregunta, null, arrayOpciones, arrayOpciones[0]);

        return opcionElegida;
    }

    public static void devuelveElMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensajeFormateado(mensaje), titulo, tipoMensaje);
    }

}
