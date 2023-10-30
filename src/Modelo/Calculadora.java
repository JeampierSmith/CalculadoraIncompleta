/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Calculadora {

    public double calcular(String expresion) {
        Pila<Double> numeros = new Pila<>();
        Pila<String> operadores = new Pila<>();
        String token = "";

        for (char caracter : expresion.toCharArray()) {
            if (Character.isDigit(caracter) || caracter == '.') {
                token += caracter;
            } else {

                if (!token.isEmpty()) {

                    numeros.push(Double.parseDouble(token));
                    token = "";
                }
                if (esOperador(caracter)) {

                    String operador = String.valueOf(caracter);
                    while (!operadores.isEmpty() && prioridadOperador(operadores.peek()) >= prioridadOperador(operador)) {
                        realizarOperacion(numeros, operadores);
                    }
                    operadores.push(operador);
                } else if (caracter == '!') {
                    operadores.push("!");
                } else if (caracter == 'a') {
                    if (expresion.length() >= 5) {
                        String funcion = expresion.substring(0, 5);
                        switch (funcion) {
                            case "asinr(":
                                operadores.push("asinr");
                                token = "";
                                expresion = expresion.substring(5);
                                break;
                            case "acosr(":
                                operadores.push("acosr");
                                token = "";
                                expresion = expresion.substring(5);
                                break;
                            case "atanr(":
                                operadores.push("atanr");
                                token = "";
                                expresion = expresion.substring(5);
                                break;
                            default:
                                break;
                        }
                    }
                } else if (caracter == 'a') {
                    if (expresion.length() >= 5) {
                        String funcion = expresion.substring(0, 5);
                        switch (funcion) {
                            case "asin(":
                                operadores.push("asin");
                                token = "";
                                expresion = expresion.substring(4);
                                break;
                            case "acos(":
                                operadores.push("acos");
                                token = "";
                                expresion = expresion.substring(4);
                                break;
                            case "atan(":
                                operadores.push("atan");
                                token = "";
                                expresion = expresion.substring(4);
                                break;
                            default:
                                break;
                        }
                    }
                } else if (caracter == 's') {
                    if (expresion.length() >= 5) {
                        String funcion = expresion.substring(0, 5);
                        switch (funcion) {
                            case "senr(":
                                operadores.push("senr");
                                token = "";
                                expresion = expresion.substring(5);
                                break;
                            case "cosr(":
                                operadores.push("cosr");
                                token = "";
                                expresion = expresion.substring(5);
                                break;
                            case "tanr(":
                                operadores.push("tanr");
                                token = "";
                                expresion = expresion.substring(5);
                                break;
                        }
                    }
                } else if (caracter == 's') {

                    if (expresion.length() >= 4) {
                        String funcion = expresion.substring(0, 4);
                        if (funcion.equals("sen(")) {
                            operadores.push("sen");

                            token = "";
                            expresion = expresion.substring(3);
                        }
                    }
                } else if (caracter == 'c') {

                    if (expresion.length() >= 4) {
                        String funcion = expresion.substring(0, 4);
                        if (funcion.equals("cos(")) {
                            operadores.push("cos");

                            token = "";
                            expresion = expresion.substring(3);
                        }
                    }
                } else if (caracter == 't') {

                    if (expresion.length() >= 4) {
                        String funcion = expresion.substring(0, 4);
                        if (funcion.equals("tan(")) {
                            operadores.push("tan");
                            token = "";
                            expresion = expresion.substring(3);
                        }
                    }
                } else if (caracter == 'i') {

                    if (expresion.length() >= 4) {
                        String funcion = expresion.substring(0, 4);
                        if (funcion.equals("inv(")) {
                            operadores.push("inv");

                            token = "";
                            expresion = expresion.substring(3);
                        }
                    }
                } else if (caracter == 'l') {

                    if (expresion.length() >= 3) {
                        String funcion = expresion.substring(0, 3);
                        if (funcion.equals("log")) {
                            operadores.push("log");

                            token = "";
                            expresion = expresion.substring(2);
                        } else if (funcion.equals("ln(")) {
                            operadores.push("ln");

                            token = "";
                            expresion = expresion.substring(2);
                        }
                    }
                } else if (caracter == 'e') {

                    numeros.push(Math.E);
                } else if (caracter == 'p') {

                    numeros.push(Math.PI);
                } else if (caracter == 's') {

                    if (expresion.length() >= 5) {
                        String funcion = expresion.substring(0, 5);
                        if (funcion.equals("sqrt(")) {
                            operadores.push("sqrt");

                            token = "";
                            expresion = expresion.substring(4);
                        }
                    } else if (caracter == '%') {
                        operadores.push("%");
                    } else if (caracter == 'c') {
                        if (expresion.length() >= 4) {
                            String funcion = expresion.substring(0, 4);
                            if (funcion.equals("cbrt(")) {
                                operadores.push("cbrt");
                                token = "";
                                expresion = expresion.substring(4);
                            }
                        }
                    }
                }
            }
        }

        if (!token.isEmpty()) {

            numeros.push(Double.valueOf(token));
        }

        while (!operadores.isEmpty()) {
            realizarOperacion(numeros, operadores);
        }

        return numeros.pop();
    }

    private boolean esOperador(char caracter) {
        return "+-*/^".contains(String.valueOf(caracter));
    }

    private int prioridadOperador(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            case "senr":
            case "cosr":
            case "tanr":
            case "asinr":
            case "acosr":
            case "atanr":
                return 4;
            case "!":
                return 5;
            case "sin":
            case "cos":
            case "tan":
            case "asin":
            case "acos":
            case "atan":
            case "inv":
            case "log":
            case "ln":
            case "sqrt":
            case "cbrt":
                return 6;
            case "e":
                return 7;
            case "pi":
                return 7;
            case "%":
                return 7;
            default:
                break;
        }
        return 0;
    }

    private double factorial(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        } else if (numero == 0) {
            return 1;
        } else {
            double resultado = 1;
            for (int i = 1; i <= numero; i++) {
                resultado *= i;
            }
            return resultado;
        }
    }

    private void realizarOperacion(Pila<Double> numeros, Pila<String> operadores) {
        String operador = operadores.pop();
        switch (operador) {
            case "sen" -> {
                double num = numeros.pop();
                double resultado = Math.sin(Math.toRadians(num));
                numeros.push(resultado);
            }
            case "cos" -> {
                double num = numeros.pop();
                double resultado = Math.cos(Math.toRadians(num));
                numeros.push(resultado);
            }
            case "tan" -> {
                double num = numeros.pop();
                double resultado = Math.tan(Math.toRadians(num));
                numeros.push(resultado);
            }
            case "inv" -> {
                double num = numeros.pop();
                double resultado = 1.0 / num;
                numeros.push(resultado);
            }
            case "log" -> {
                double num = numeros.pop();
                double resultado = Math.log10(num);
                numeros.push(resultado);
            }
            case "ln" -> {
                double num = numeros.pop();
                double resultado = Math.log(num);
                numeros.push(resultado);
            }
            case "sqrt" -> {
                double num = numeros.pop();
                double resultado = Math.sqrt(num);
                numeros.push(resultado);
            }
            case "asin" -> {  // Función inversa de seno (arcoseno)
                double num = numeros.pop();
                double resultado = Math.toDegrees(Math.asin(num));
                numeros.push(resultado);
            }
            case "cbrt" -> {
                double num = numeros.pop();
                double resultado = Math.cbrt(num);
                numeros.push(resultado);
            }
            case "acos" -> {  // Función inversa de coseno (arcocoseno)
                double num = numeros.pop();
                double resultado = Math.toDegrees(Math.acos(num));
                numeros.push(resultado);
            }
            case "atan" -> {  // Función inversa de tangente (arcotangente)
                double num = numeros.pop();
                double resultado = Math.toDegrees(Math.atan(num));
                numeros.push(resultado);
            }
            case "%" -> {
                double num2 = numeros.pop();
                double num1 = numeros.pop();
                double resultado = num1 % num2;
                numeros.push(resultado);
            }
            case "!" -> {  // Operador factorial
                double num = numeros.pop();
                double resultado = factorial(num);
                numeros.push(resultado);
            }
            case "senr" -> {
                double num = numeros.pop();
                double resultado = Math.sin(num);
                numeros.push(resultado);
            }
            case "cosr" -> {
                double num = numeros.pop();
                double resultado = Math.cos(num);
                numeros.push(resultado);
            }
            case "tanr" -> {
                double num = numeros.pop();
                double resultado = Math.tan(num);
                numeros.push(resultado);
            }
            case "asinr" -> {
                double num = numeros.pop();
                double resultado = Math.asin(num);
                numeros.push(resultado);
            }
            case "acosr" -> {
                double num = numeros.pop();
                double resultado = Math.acos(num);
                numeros.push(resultado);
            }
            case "atanr" -> {
                double num = numeros.pop();
                double resultado = Math.atan(num);
                numeros.push(resultado);
            }
            default -> {
                double num2 = numeros.pop();
                double num1 = numeros.pop();
                double resultado = 0;
                switch (operador) {
                    case "+" ->
                        resultado = num1 + num2;
                    case "-" ->
                        resultado = num1 - num2;
                    case "*" ->
                        resultado = num1 * num2;
                    case "/" ->
                        resultado = num1 / num2;
                    case "^" ->
                        resultado = Math.pow(num1, num2);
                }
                numeros.push(resultado);
            }
        }
    }

}
