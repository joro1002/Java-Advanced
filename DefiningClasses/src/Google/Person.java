package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }


    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company.toString()).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car.toString()).append("\n");
        }
        builder.append("Pokemon:").append("\n");
        if (pokemons.size() > 0) {
            for (Pokemon pokemon : pokemons) {
                builder.append(pokemon.toString());
                builder.append("\n");
            }
        }
        builder.append("Parents:").append("\n");
        if (parents.size() > 0) {
            for (Parent parent : parents) {
                builder.append(parent.toString());
                builder.append("\n");
            }
        }
        builder.append("Children:").append("\n");
        if (children.size() > 0) {
            for (Child child : children) {
                builder.append(child.toString());
                builder.append("\n");
            }
        }
        return builder.toString();

    }
}
