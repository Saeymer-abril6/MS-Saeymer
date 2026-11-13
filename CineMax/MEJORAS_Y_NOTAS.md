# Mejoras aplicadas a CineMax

- Se añadió selección visual de asientos al agregar entradas: verde disponible, azul seleccionado y rojo ocupado.
- Los códigos de asientos se guardan en `venta_detalle.asientos` y aparecen en el detalle de la venta.
- Se añadió una migración idempotente `ALTER TABLE ... ADD COLUMN IF NOT EXISTS` para bases existentes.
- El login (`login.fxml`, `LoginController`, usuarios y claves semilla) no fue modificado.

## Consideraciones
- El selector muestra una distribución inicial de 40 asientos (5 filas x 8 columnas). Ajustar el número de asientos al aforo real de cada sala es el siguiente ajuste recomendado.
- La consulta de ocupados se basa en ventas registradas. Para evitar dobles reservas simultáneas en equipos conectados, debe añadirse una tabla de reservas con restricción única por función y asiento y transacción de bloqueo.
- Se añadió consulta de DNI mediante proveedor RENIEC externo (Decolecta) usando token por variable de entorno `CINEMAX_RENIEC_TOKEN`; no se incrusta ninguna clave en el proyecto. Se completa el nombre y se recomienda verificarlo antes de guardar. Sin token, el registro manual sigue disponible. No es una conexión directa con RENIEC oficial: requiere cuenta/credenciales del proveedor y revisar sus condiciones de uso.

## Validación
El entorno de trabajo no dispone de Maven, por lo que no fue posible ejecutar `mvn package` aquí. Abrir el proyecto con JDK 21 y ejecutar `mvn clean package` para validar dependencias y compilación.
