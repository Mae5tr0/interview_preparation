package chapter_3;


import structures.LinkedList;
import structures.Pair;

/**
 * Animal Shelter
 * <p>
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations such as enqueue,
 * dequeueAny, dequeueDog, and dequeueCat. You may use the built-in Linked list data structure.
 */
public class Task_6 {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Cat("Boris"));
        shelter.enqueue(new Cat("Murka"));

        shelter.enqueue(new Dog("Sultan"));
        shelter.enqueue(new Dog("Roman"));

        shelter.enqueue(new Cat("Pum"));
        shelter.enqueue(new Dog("Arnold"));

        System.out.println(shelter);
        System.out.println(shelter.dequeueAny()); // Boris
        System.out.println(shelter.dequeueDog()); // Sultan
        System.out.println(shelter.dequeueAny()); // Murka
        System.out.println(shelter.dequeueCat()); // Pum
        System.out.println(shelter.dequeueDog()); // Roman
        System.out.println(shelter);
    }

    private static class AnimalShelter {
        private Integer counter = 0;  // in long time it's possible to overflow counter, we can use Date here
        LinkedList<Pair<Integer, Cat>> cats = new LinkedList<>();
        LinkedList<Pair<Integer, Dog>> dogs = new LinkedList<>();

        public void enqueue(Animal animal) {
            if (animal instanceof Dog) {
                dogs.push(new Pair<>(counter++, (Dog) animal));
            } else if (animal instanceof Cat) {
                cats.push(new Pair<>(counter++, (Cat) animal));
            } else {
                throw new IllegalArgumentException("Invalid animal type");
            }
        }

        public Animal dequeueAny() {
            if (cats.isEmpty() && dogs.isEmpty()) throw new IllegalArgumentException("Shelter are empty");

            if (cats.isEmpty()) return dogs.removeFirst().getLast();
            if (dogs.isEmpty()) return cats.removeFirst().getLast();

            Integer oldestDogAge = dogs.getFirst().getFirst();
            Integer oldestCatAge = cats.getFirst().getFirst();
            if (oldestCatAge < oldestDogAge) return cats.removeFirst().getLast();

            return dogs.removeFirst().getLast();
        }

        public Cat dequeueCat() {
            if (cats.isEmpty()) throw new IllegalArgumentException("No cats in the shelter");

            return cats.removeFirst().getLast();
        }

        public Dog dequeueDog() {
            if (dogs.isEmpty()) throw new IllegalArgumentException("No dogs in the shelter");

            return dogs.removeFirst().getLast();
        }

        @Override
        public String toString() {
            return "AnimalShelter{" +
                    "counter=" + counter +
                    ", cats=" + cats +
                    ", dogs=" + dogs +
                    '}';
        }
    }

    private static class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal(" + name  + ')';
        }
    }

    private static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Dog(" + name  + ')';
        }
    }

    private static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Cat(" + name  + ')';
        }
    }
}
