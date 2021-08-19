# cryptoBet

CRYPTO BETS


Desarrollar la aplicación CRYPTO BETS un juego en línea, donde dos o más jugadores pueden participar desde su Navegador (browser), 
cada jugador puede realizar una apuesta en cada ronda.  Y la apuesta consiste en realizar una estimación de cuál será el precio de Bitcoin 
cuando termine la ronda.  El ganador de la ronda es el jugador que realice la estimación más cercana al precio de Bitcoin al momento de finalizar la ronda.
Cada ronda tiene una duración de un minuto.
Al inicio de cada ronda la página muestra el precio actual de Bitcoin, y habilita un formulario con dos campos, el nombre del jugador y su apuesta.    

La pantalla principal de CRYPTO BETS muestra en tiempo real el número de apuestas en la ronda actual.
Después que el usuario realice la apuesta, el backend enviará asíncronamente una notificación al usuario con la confirmación de la recepción de la apuesta.  (más adelante una descripción de los diferentes tipos de notificación) 
Cinco segundos antes que termine la ronda, la página deberá bloquear el formulario de apuestas para no enviar mas apuestas.
El backend también validará que no se reciban apuestas cuando falten 5 o menos segundos antes que acabe la ronda.
Al finalizar el tiempo de la ronda, el backend obtendrá el precio actual de Bitcoin, y con ese valor realizará una comparación con todas 
las apuestas de la ronda, y seleccionará al ganador.
El backend enviará una notificación al usuario ganador.  (En caso de existir mas de un ganador, es decir dos o mas jugadores hicieron 
la misma apuesta y el precio del bitcoin al final de la ronda es igual al de la apuesta, entonces se enviarán notificaciones a todos los ganadores)
La página de cada jugador se actualiza en tiempo real y muestra al ganador y su apuesta.  
