package Exercise_06_DefiningClasses.P07_Google;

public class Pokemon extends PersonName {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String name, String pokemonName, String pokemonType) {
        super(name);
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }
}
