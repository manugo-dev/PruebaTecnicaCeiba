package dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Util {

	private Util() { }

	/**
	 * Calcula la fecha sumandole n dias con la restricci�n de que
	 * "Si la fecha de entrega cae un domingo deber� ser el siguiente d�a h�bil. 
	 * @param actual Fecha actual
	 * @param dias Entero numero de dias que quiere sumar
	 * @return Retorna la fecha agregandole el numero de dias y teniendo en cuenta la restricci�n de los domingos
	 * 
	 */	
	public static LocalDate calcularFecha(LocalDate diaHoy, int dias) {
		int diasAgregados = dias - 1;
		LocalDate fechaEntrega = diaHoy;

		while(diasAgregados > 0){
			if(fechaEntrega.getDayOfWeek() == DayOfWeek.SUNDAY) {
				fechaEntrega = fechaEntrega.plusDays(1);
			} else {
				fechaEntrega = fechaEntrega.plusDays(1);
				diasAgregados--;
			}
		}
		if(fechaEntrega.getDayOfWeek() == DayOfWeek.SUNDAY) {
			fechaEntrega = fechaEntrega.plusDays(1);
		}
		return fechaEntrega;
	}

	/**
	 *  Hace uso de alReves para invertir el string entrado
	 *  y si el invertido es igual al entrado entonces retorna true. 
	 *  @param isbn String a verificar si es palindromo
	 *  @return Devuelve true si el string ingresado es palindromo
	 */
	public static boolean esPalindromo(String cadena) {
		String cadenaInvertida = alReves(cadena);
		return cadena.equals(cadenaInvertida);
	}

	/**
	 * Invierte un string "dato" entrado.
	 * @param dato String que se quiere invertir
	 * @return Devuelve el string invertido
	 */	
	private static String alReves(String cadena) {
		if (cadena.length() <= 1) {
			return cadena;
		}
		return alReves(cadena.substring(1)) + cadena.charAt(0);
	}

	/**
	 * Verifica si la suma de los digitos del string entrado es mayor a 30
	 * @param isbn String a verificar si la suma de los digitos del string entrado es mayor a 30
	 * @return Retorna TRUE si los digitos numericos del string isbn suman mas de 30
	 * 
	 */	
	public static boolean sumaDigitosMayorA(String cadena, int i) {
		String cadenaNumerico = cadena.replaceAll("[^\\d.]", "");
		int sum = String.valueOf(cadenaNumerico)
				.chars()
				.map(Character::getNumericValue)
				.sum();
		return sum > i;
	}
}
