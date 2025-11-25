# Conversor de Monedas – Challenge Alura Latam

Este proyecto es un **Conversor de Monedas en Java** que consulta una API de tasas de cambio para convertir valores entre distintas divisas en tiempo real.  
Forma parte del **Challenge del curso de Java – Alura Latam + Oracle One**.

---

## 🚀 Funcionalidad

- Obtiene tasas de cambio desde una API externa.
- Convierte montos entre distintas monedas.
- Menú interactivo y simple para el usuario.
- Validación de datos ingresados.
- Resultados claros en consola.

---

## 🛠 Tecnologías utilizadas

- **Java 17+**
- **Gson 2.13.2** (parseo JSON)
- **Java HTTPClient** para llamadas a la API
- **Git / GitHub**

---

## 🌐 API utilizada

Podés usar una API gratuita como:

- **Exchangerate API**: https://www.exchangerate-api.com  
- **ExchangeRate.host** (gratuita)

El programa toma la respuesta en formato JSON y extrae el valor de conversión entre dos monedas.

---

## 📦 Estructura del proyecto
```bash
src/
├── Principal.java -> Punto de entrada del programa
├── Menu.java -> Menú interactivo
└── ConversorMoneda.java -> Lógica de conversión y consumo de API
```
### 1. Clonar el repositorio
```bash
git clone https://github.com/tuusuario/ConversorDeMonedasChallenge.git
```
### 2. Compilar
javac -cp gson-2.13.2.jar src/*.java

### 4. Ejecutar

En Linux/Mac:

java -cp gson-2.13.2.jar:src Principal


En Windows:

java -cp gson-2.13.2.jar;src Principal


## 🧮 Ejemplo de uso

Seleccionar conversión (ejemplo: USD → ARS)

Ingresar monto (ej: 100)

## 📘 Aprendizajes del proyecto

Consumo de APIs REST con Java.

Parseo de JSON con Gson.

Manejo de excepciones y validaciones.

Lógica orientada a objetos.

Buenas prácticas al estructurar un proyecto Java.
