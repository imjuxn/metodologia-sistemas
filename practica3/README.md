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

## Activar el control antes de cada commit

Desde cualquier carpeta de este repositorio, ejecutar una sola vez:

```powershell
git config core.hooksPath .githooks
```

El hook `pre-commit` ejecuta las tres verificaciones anteriores en orden.
Si alguna falla, Git no crea el commit. El hook solo se activa en la copia
local donde se configura; los demas colaboradores deben activarlo tambien.

El ejemplo y los resultados de auditoria estatica estan en `auditoria/README.md`.
Las evidencias del informe final se agregaran en el paso siguiente.

## Medir cobertura

Desde `practica3`, ejecutar:

```powershell
.\mvnw.cmd clean verify
```

El reporte HTML se genera en `target/site/jacoco/index.html` y el XML en
`target/site/jacoco/jacoco.xml`. La carpeta `target` se regenera y no se sube
al repositorio.
