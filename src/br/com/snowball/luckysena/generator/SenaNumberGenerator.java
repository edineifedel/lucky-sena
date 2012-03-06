package br.com.snowball.luckysena.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SenaNumberGenerator {

	private static final int MAX_SENA_NUMBER = 60;

	public static String generateLuckyNumbers() {
		Random random = new Random();
		Set<Integer> numbers = new HashSet<Integer>();
		for (int i = 1; i <= 6; i++) {
			do {
				int chooseNumber = random.nextInt(MAX_SENA_NUMBER) + 1;
				numbers.add(chooseNumber);
			} while (numbers.size() != i);
		}
		return formatStringNumbers(numbers);
	}

	private static String formatStringNumbers(Set<Integer> numbers) {
		StringBuilder sb = new StringBuilder();
		for (Integer integer : numbers) {
			sb.append(integer).append(" ");
		}
		return sb.toString();
	}

}
