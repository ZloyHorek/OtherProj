import java.util.*;


public class CollectionsTask2 {
    public static class Human implements Comparable<Human> {
        private String firstName;
        private String lastName;
        private int age;

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Human)) return false;
            Human human = (Human) o;
            return getAge() == human.getAge() &&
                    Objects.equals(getFirstName(), human.getFirstName()) &&
                    Objects.equals(getLastName(), human.getLastName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getFirstName(), getLastName(), getAge());
        }

        @Override
        public String toString() {
            return "Human{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Human o) {
            int result = this.lastName.compareTo(o.lastName);
            if (result != 0) {
                return result;
            } else {
                return this.firstName.compareTo(o.firstName);
            }
        }

        public static class LastNameComparator implements Comparator<Human> {
            @Override
            public int compare(Human h1, Human h2) {
                String lastName1 = h1.getLastName();
                String lastName2 = h2.getLastName();
                return lastName1.compareTo(lastName2);
            }
        }


        public static void main(String[] args) {
            Human h1 = new Human("Jack", "Jackson", 24);
            Human h2 = new Human("Jack", "Modson", 24);

            Set<Human> s = new HashSet<Human>();
            s.add(new Human("Andy", "Wolf", 25));
            s.add(new Human("Ritta", "SKitter", 24));
            s.add(new Human("Petr", "Petrov", 31));
            System.out.println("HashSet");
            System.out.println(s);
            LinkedHashSet<Human> set = new LinkedHashSet<Human>(s);
            System.out.println(set);
            TreeSet<Human> treeSet = new TreeSet<Human>(s);
            System.out.println(treeSet);
            TreeSet<Human> set2 = new TreeSet<>(new LastNameComparator());
            set2.addAll(set);
            System.out.println(set2);


        }
    }
}
