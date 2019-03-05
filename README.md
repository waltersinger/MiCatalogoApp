# MiCatalogoApp

<p>Hay muchas personas que tienen su propio micro emprendimiento ya sea en sus hogares, en alguna institución en la que trabaja, lo mas comun y económico es subir todo sus productos (que no son demasiados) a las redes sociales como MarketPlace de facebook.
Hay algunos que adquieren un espacio en tiendas ecomerce como mercadolibre pero tiene una desventaja para estos pequeños emprendedores, la tarifa por cada venta se va tornando mas elevada.</p>
<p>
Por esto he ideado una pequeña app, con opciones reducidas, pero será de mucha utilidad para que los pequeños emprendedores puedan tener una administración "sistematizada" de sus productos y ventas.</p>
<p>Tengo planificado realizarlo para IOS en un futuro, utilizando FLUTTER porque creo que va a ser una tecnología muy utilizada en poco tiempo.</p>
<p>El backend lo realizare con MySQL y springboot para la comunicacion del mismo.</p>
<p>No sera una gran aplicación pero tendra lo necesario para que cada persona pueda cargar,eliminar,guardar y registrar sus ventas desde su casa, ya que el servidor estaría localmente.</p>
<p>Si necesitarían algo mas grande, es otro tema...
El motivo es demostrar las habilidades que poseo para desarrollar apps.</p>
<br/>
<p>Construcción de la aplicacion base. Cuando el usuario abra la app, se mostrara la siguiente UI: </p>
![alt text](https://github.com/waltersinger/MiCatalogoApp/blob/master/images/MainScreen.png)

<p>Sobre un drawer Layout ubicare los demas widgets utilizando el paradigma de MATERIAL DESIGN de google. Un Menu lateral se desplegara para mostrar opciones para un determinado usuario de la aplicacion (ADMINISTRADOR) </p>
![alt text](https://github.com/waltersinger/MiCatalogoApp/blob/master/images/MainMenu.png)
<p>En la siguiente figura muestro el entorno de trabajo, en esta ocación estoy construyendo el acceso a las APIs para obtener un listado de articulos. Cabe aclarar que utilizo el patron SINGLETON para acceder a los servicios externos con la libreria Volley </p>
![alt text](https://github.com/waltersinger/MiCatalogoApp/blob/master/images/WORKING%20WITH%20APPIS.png)
