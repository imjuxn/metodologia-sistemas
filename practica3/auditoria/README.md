# Auditoria estatica - Practico 3, punto 2

`src/main/java/TurnoManager.java` reproduce el ejemplo de codigo legado usado
previamente en una actividad de refactorizacion. Es un proyecto de auditoria
separado: no forma parte de la agenda que
debe pasar el hook de calidad.

## Resultados medidos

Desde `practica3`:

```powershell
.\mvnw.cmd -f auditoria\pom.xml checkstyle:check
```

Checkstyle 14.3.0 reporto complejidad ciclomatica 8 en `procesar` (linea 8),
frente al limite 7 fijado para este ejercicio. El fallo del build de auditoria
es esperado: senala el problema en el codigo original.

La inspeccion del fuente muestra una duplicacion concreta: las ramas `OSDE`
y `SWISS` imprimen exactamente `Paciente premium`. Esta observacion es manual;
no se presenta como un porcentaje medido por un detector de clones.

Se reviso el `pom.xml` de la agenda con:

```powershell
.\mvnw.cmd org.codehaus.mojo:versions-maven-plugin:2.22.0:display-dependency-updates -DprocessPlugins=false
```

El 28/10/2026 Maven informo que `org.junit.jupiter:junit-jupiter` tenia una
actualizacion `5.14.1 -> 6.1.3`. Una version antigua no demuestra por si misma
una vulnerabilidad. El cambio de version mayor requiere ejecutar las pruebas
y revisar posibles cambios de API antes de integrarlo. Se actualizo la agenda
a JUnit `6.1.3`: formato y estilo pasaron, y las 4 pruebas terminaron sin fallos.
Una segunda ejecucion de Maven Versions no encontro dependencias directas mas
nuevas. Esto no equivale a un escaneo de vulnerabilidades.

## Puntos criticos y estrategia

1. Crear pruebas para seguros `OSDE`, `SWISS`, `PUBLICA`, otros y nulos; edad
   invalida y turno urgente, antes de modificar el comportamiento.
2. Aplicar validaciones tempranas para reducir anidamiento y evitar
   `NullPointerException` al invocar `obraSocial.equals(...)` con valor nulo.
3. Unificar la clasificacion de obras sociales en un metodo o conjunto de
   valores, eliminando la rama duplicada de paciente premium.
4. Reemplazar el texto concatenado por un objeto `Turno` con campos tipados;
   simplificar `urgente == true` y el recorrido de la lista.
5. Repetir la medicion de complejidad y ejecutar pruebas de regresion. Revisar
   dependencias con Maven Versions y una herramienta de vulnerabilidades antes
   de aprobar cambios. El chequeo de versiones no sustituye un analisis de
   seguridad de componentes.
