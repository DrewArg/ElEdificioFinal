/* ----- ----- VER COMO ARMAR EL PLUS DE VIDA DE LA COMIDA ----- -----*/  
La idea es que suma 5 de vida de golpe y +4 por 4 turnos.

largo de comentarios -- ESTO NO LO PREGUNTAMOS XD

mutantes: que mutantes son?  

dropeo despues de pelea:  
ahora mismo los enemigos dropean botellas de agua llena en una probabilidad del 50%  
ver de dropear armas, comidas y vendajes con menor chance  

Para hacer esto ultimo, vamos a tener que crear las variables de suerte:  
int suerteTotal -> koala --> aumenta la suerte total  
int suerteArmas -> perro --> aumenta la chance de que dropeen armas  
int suerteSigilo -> gato --> ayuda en la huida de las peleas  
int suerteAgua -> pato --> aumenta la chance de que dropeen botellas de agua llena  
int suerteDaño -> carbra --> se suma al bonus de daño de los monsters  
int sociabilidad -> suricata --> menor chance de que los npc te traicionen.  

Traicion de npcs ( non player characters ).  
para ello tienen que haber npcs    

FUNCION QUE CREE MENSAJES CON LOS SALTOS DE LINEA Y AGREGUE UN ">" DELANTE CADA VEZ QUE ENCUENTRE UN "." AL FINAL DE UNA LINEA 
SI LLEGA A LOS 149 CARACTERES, SALTA DE LINEA PERO NO AGREGA EL ">"