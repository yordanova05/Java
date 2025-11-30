package week9;
import java.util.*;
import java.util.stream.Collectors;

public class exercies {
    public static List<Product> getProductsByCategory(List<Product> products, String category){
        List<Product> result = products.stream().filter(p-> p.category.equals(category)).sorted(Comparator.comparing(p->p.price)).toList();
        return result;
    }

    public static List<Product> getExpensiveProducts(List<Product> products, double minPrice){
        List<Product> expencivesProducts = products.stream().filter(n->n.price > minPrice).sorted(Comparator.comparingDouble((Product p) -> p.price).reversed())
                .toList();
        return expencivesProducts;
    }
    public static void main(String[] args){
        System.out.println("Exercise 1:");
        //exercise1
        List<Integer> list = List.of(1,5,8,12,3,6);
        List<Integer> list2 = list.stream().filter(n-> n%2==0).toList();
        for(Integer n: list2){
            System.out.println(n);
        }
        System.out.println("Exercise 2:");
        //exercise2
        List<String> names = List.of("ivan","Maria", "pesho");
        List<String> names2 = names.stream().map(s-> s.toUpperCase()).toList();

        for(String s: names2){
            System.out.println(s);
        }
        System.out.println("Exercise 3:");
        //exercise3
        List<String> names3 = names.stream().filter(s-> s.length() > 4).filter(s-> Character.isUpperCase(s.charAt(0))).toList();
        for(String s: names3){
            System.out.println(s);
        }
        System.out.println("Exercise 4:");
        //exercise4
        List<Integer> numbers = List.of(3,8,1,21,234,5,2,9,10,4,7,6,11);
        List<Integer> numbers2 = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        for(Integer n: numbers2){
            System.out.println(n);
        }
        System.out.println("Exercise 5:");
        //exercise5
        List<Integer> dublicates = List.of(1,1,1,2,2,3,3,3,4,4,5,5,5,5,5,6,7,8,9,9,9,10);
        List<Integer> noDublicates = dublicates.stream().distinct().toList();

        for(Integer n: noDublicates){
            System.out.println(n);
        }
        System.out.println("Exercise 6:");
        //exercise6
        List<Student> students = List.of(
                new Student("Yoanna", 5),
                new Student("Kolio", 6),
                new Student("Katq", 4),
                new Student("Georgi",6)
        );
        List<Student> excellent = students.stream().filter(s-> s.grade==6).toList();
        for(Student s: excellent){
            System.out.println(s.name + " "+s.grade);
        }
        List<String> namesStudent = excellent.stream().map(s->s.name).sorted((a,b)-> a.compareTo(b)).toList();
        for(Student s: excellent){
            System.out.println(s.name);
        }
        System.out.println("Exercise 7:");
        //exercise7
        List<Integer> integers = List.of(1,1,1,2,2,3,3,3,4,4,5,5,5,5,5,6,7,8,9,9,9,10);

        double avg = integers.stream().mapToInt(n -> n).average().orElse(0);
        System.out.println(avg);

        System.out.println("Exercise 8:");
        //exercise8
        List<Item> items = List.of(
                new Item("data", 4.6),
                new Item("frame", 5.9)
        );
        Map<String,List<Item>> result = items.stream().collect(Collectors.groupingBy( i -> i.category));
        result.forEach((category, list5)->{
            System.out.println("Category: " + category);
            list5.forEach(item->{
                System.out.println("Price: " + item.price);
            });
        });

        //exercise9
        List<Integer> listOfIntegers = List.of(5, 12, 8, 20, 13,14);
        List<Integer> newListOfIntegers = listOfIntegers.stream().filter(n-> n%2 == 0 && n>10).sorted().toList();
        for(Integer i: newListOfIntegers){
            System.out.println(i);
        }

        //exercise10
        List<Product> products = List.of(
                new Product("phone",50.0,"device"),
                new Product("iphone",1050.0,"device"),
                new Product("HP",40.0,"tv")
        );
        List<Product> res = getProductsByCategory(products, "device");
        res.forEach(prod->System.out.println(prod.name + " " + prod.price + " " + prod.category));
        List<Product> res2 = getExpensiveProducts(products, 30.0);
        res2.forEach(prod->System.out.println(prod.name + " " + prod.price + " " + prod.category));
    }
}
