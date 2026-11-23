# DP-2026-Grupo1-Calculadora — Calculadora Modular Extensible con Historial

Proyecto Final del curso **Diseño de Patrones (100000SI47)** — Universidad Tecnológica del Perú (UTP), Periodo 2026 – Ciclo 2 Agosto.

## Integrantes del Grupo

| Apellidos y Nombres | Código UTP | Usuario GitHub | Rol |
| :--- | :--- | :--- | :--- |
| Mendoza Prado, James Lowys | U23316325 | LowysMP | Arquitectura y Modelo SOLID |
| Santiago Lequernaqué Infante | U23323689 | santiagolq | Desarrollo Factory Method |
| Mogollon Moran Reyner Alonso | U24306796 | reynermogollonmoran117-ops! | Desarrollo Patrón Adapter |
| Vilela Aguilera Xavier Steve | U24267585 | Vilelaaguilera-beep | Documentación UML y Pruebas |

---

## Descripción del Problema que Resuelve

En una aplicación de cálculo que requiere crecer con nuevas operaciones matemáticas (binarias de 2 operandos y unarias de 1 operando) y mantener un registro auditado de resultados, programar toda la lógica dentro de una sola clase con condicionales `if/else` o `switch` acopla la creación de objetos, duplica código de entrada/salida y dificulta el mantenimiento.

Este sistema resuelve el problema separando responsabilidades mediante principios **SOLID** y aplicando dos patrones de diseño **GoF**: **Factory Method** (para centralizar la instanciación de operaciones) y **Adapter** (para unificar operaciones de un solo número con las operaciones estándar de dos números).

---

## Patrones de Diseño Aplicados (GoF)

| Patrón | Tipo | Problema que resuelve | Clases participantes |
| :--- | :--- | :--- | :--- |
| **Factory Method** | Creacional | Centraliza la creación de operaciones evitando que `Main` instancie directamente clases concretas (`new Suma()`, `new Resta()`, etc.). | `Operacion` *(Product)*, `Suma`, `Resta`, `Multiplicacion`, `Division` *(ConcreteProducts)*, `OperacionFactory` *(Creator)* |
| **Adapter** | Estructural | Permite adaptar la interfaz incompatible `OperacionUnNumero` (1 operando, como `RaizCuadrada`) al contrato `Operacion` (2 operandos). | `Operacion` *(Target)*, `OperacionUnNumero` / `RaizCuadrada` *(Adaptee)*, `AdaptadorOperacionUnaria` *(Adapter)* |

### Ficha Técnica de los Patrones
1. **Factory Method (Creacional):**
   * **Ventajas:** Elimina el acoplamiento entre el cliente (`Main`) y las clases concretas; facilita agregar nuevas operaciones (ej. `Potencia`) creando una clase y registrándola en la fábrica.
   * **Desventajas:** Incrementa ligeramente la cantidad de clases del proyecto.
2. **Adapter (Estructural):**
   * **Ventajas:** Permite reutilizar operaciones unarias existentes (`RaizCuadrada`) sin modificar su interfaz ni duplicar métodos de ejecución en `Calculadora`.
   * **Desventajas:** Añade una capa intermedia de delegación por cada familia incompatible adaptada.

### Comparación Antes vs. Después de los Patrones
* **Sin Patrones:** `Main` contenía múltiples `case` con `new Suma()`, `new Resta()`, etc., y `Calculadora` necesitaba dos métodos separados (`calcular` para 2 números y `calcularUnNumero` para 1 número).
* **Con Factory Method + Adapter:** `Main` solo solicita `OperacionFactory.crearOperacion(opcion)` y `Calculadora` ejecuta cualquier operación mediante un único método polimórfico `calcular(Operacion op, double a, double b)`.

---

## Diagrama de Clases UML

![Diagrama de Clases UML](docs/diagrama-clases.png)

---

## Instrucciones para Compilar y Ejecutar

### Desde Visual Studio Code
1. Abrir la carpeta raíz `DP-2026-Grupo1-Calculadora` en VS Code.
2. Abrir `src/Main.java` y hacer clic en **Run**.

### Desde Terminal
```bash
javac -d bin src/modelo/*.java src/patrones/factory/*.java src/patrones/adapter/*.java src/Main.java
java -cp bin Main
```
