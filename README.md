# IOET
Desarrollo de ejercicio planteado

ENFOQUE Y SOLUCIÓN.
El objetivo del ejercicio se centra en que a paritr de una archivo .txt se obtenga cuantas veces coincidieron en la oficina los empleados en pares. El archivo .txt con el que se trabaja contiene los horarios de asistencia de los empleados.
Para conseguir el objetivo del ejercicio se sigue la siguiente metodologia:
      1.- Lectura del archivo de horarios de asistencia.
      2.- Ordenamiento de datos.
      3.- Interpretación, manipulación y comparación de datos.
      4.- Presentación de resultados.
La solución del ejercicio se desarrolla haciendo uso de estructuras y variables como: ArrayLists, Maps, Strings, Integers, auxiliares, globales, clases y funciones con y sin retorno. Para dar la solución se sigue los siguientes pasos:
      1.- Lectura de archivo.
      2.- Se obtiene el ArrayList de empleados y horarios laborales.
      3.- Se obtiene las combinaciones posibles de los empleados.
      4.- Se obtiene el horario de entrada y salida del dia x de todos los empleados.
      5.- Se obtiene los encuentros de los empleados en el dia x en función a las combinaciones.
      6.- Se suma los encuentros de todos los dias de los empleados.
      7.- Se presenta los resultados.
*OJO: El paso 4 y 5 se repite 7 veces(una por cada dia).


ARQUITECTURA.
La solución al ejercicio es desarrollada con una arquitectura en capas, siendo estas:
        1.- Capa de Aplicación.
        2.- Capa de Lógica.
        3.- Capa de Datos.
 De esta manera se logra conseguir que la capa de aplicación no interactue directamente con la capa de datos sino lo hago por medio de la capa de lógica, lo cual genera una seguridad mayor a la que si la capa de aplicación interactuará directamente con la capa de datos.
 
INSTRUCCIONES DE EJECUCIÓN.
Primero para que el programa pueda funcionar el archivo .txt debe de tener en cada fila la siguiente estructura:
$Nombre_empleado$=MO$HORARIO_LUNES$,TU$HORARIO_MARTES$,WE$HORARIO_MIERCOLES$,TH$HORARIO_JUEVES$,FR$HORARIO_VIERNES$,SA$HORARIO_SABADO$,SU$HORARIO_DOMINGO$
Donde $HORARIO_LUNES$, $HORARIO_MARTES$, $HORARIO_MIERCOLES$, $HORARIO_JUEVES$, $HORARIO_VIERNES$, $HORARIO_SABADO$, $HORARIO_DOMINGO$ deben tener el siguiente formato:
hingreso:minutosingreso-horasalida:minutossalida
Como ejemplo se presenta la siguiente linea:
RENE=MO10:00-12:00,TU10:00-12:00,WE03:50-04:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00

Por temas demostrativos dentro del archivo subido, en la carpeta src se encuentra dos archivos .txt que pueden ser usados para comprobar funcionamiento del programa.

Para ejecutar el programa se lo debe de hacer desde el archivo App.java que encuentra en la ruta EJERCICIO/src/ui/App.JAVA, una vez que se ejecute el programa solicita que se ingrese el PATH o la ubicación del archivo .txt, una vez ingresada se da enter y el programa procesa el archivo y presenta los resultados.



