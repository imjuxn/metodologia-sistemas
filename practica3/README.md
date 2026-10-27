# Practico 3 - Agenda de turnos

Proyecto Java pequeno para practicar controles de calidad.

## Que hace

- Reserva un horario para un paciente.
- Impide dos reservas en el mismo horario.
- Permite cancelar un turno solo al paciente que lo reservo.
- Rechaza nombres vacios.

## Ejecutar las pruebas

Se necesita JDK 17 o superior. Desde la carpeta `practica3`, en PowerShell:

```powershell
.\mvnw.cmd test
```

El Maven Wrapper descarga automaticamente la version indicada en
`.mvn/wrapper/maven-wrapper.properties` la primera vez que se ejecuta.

## Revisar formato y estilo

```powershell
.\mvnw.cmd spotless:check
.\mvnw.cmd checkstyle:check
.\mvnw.cmd test
```

Si el formato falla, ejecutar `.\mvnw.cmd spotless:apply` y revisar los cambios.

La configuracion del hook, el analisis estatico y las evidencias del informe final se agregaran en pasos posteriores.
