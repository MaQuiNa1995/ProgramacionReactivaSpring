package maquina1995.programacion.reactiva;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import reactor.core.publisher.Flux;

public class Main {

    public static void main(String... args) {

	// Generamos un array de 10 numeros a traves del IntStream
	Integer[] listaNumeros = IntStream.range(1, 11)
		// para poder pasarlo a una lista el intStream recurrimos al metodo .boxed()
		.boxed()
		// Seguidamente Lo pasamos a una lista a traves del metodo Collectors.toList()
		.collect(Collectors.toList())
		// Como los Flux solo aceptan arrays y no listas necesitamos hacer una nueva
		// transformacion a este se usa el constructor del integer para evitar llamadas
		// innecesarias y optimizar la creacion del array mas info en:
		// https://stackoverflow.com/questions/4042434/converting-arrayliststring-to-string-in-java
		.toArray(new Integer[0]);

	// Creamos el objeto Flux
	Flux<Integer> flux1 = Flux.just(listaNumeros);

	// Hacemos un filtro para quedarnos con los que sean mayores de 5
	flux1.filter(e -> e >= 5)
		// Sumamos 1 a los que hemos obtenido
		.map(e -> e + 1)
		// Del resultado de las transformaciones anteriores imprimimos 1 a 1 cada numero
		// resultante
		.subscribe(System.out::println);

    }

}
