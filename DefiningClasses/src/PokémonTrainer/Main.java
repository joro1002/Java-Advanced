

import PokémonTrainer.Pokemon;
import PokémonTrainer.Trainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(trainerName);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(pokemon);


            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.equals("End")) {
            String element = command;
            for (Trainer trainer : trainers.values()) {
                if (trainer.hasELementType(element)) {
                    trainer.incrementBadges(1);
                }else {
                    trainer.damagePokemons(10);
                }
            }


            command = scanner.nextLine();
        }

        trainers
                .entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().getBadges() - f.getValue().getBadges())
                .forEach(entry -> System.out.println(entry.getValue().toString()));

    }
}
