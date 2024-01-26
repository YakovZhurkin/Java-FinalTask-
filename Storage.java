import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Storage {
    public static void main(String[] args) {
        LaptopSupport laptop1 = new LaptopSupport("Acer Swift X1",16,  512, "Windows 11", "Mystic Black");
        LaptopSupport laptop2 = new LaptopSupport("Apple MacBook Pro 16", 48, 1024, "MacOS", "Spacr Gray");
        LaptopSupport laptop3 = new LaptopSupport("HP Spectre X360", 54, 1024, "Windows 10", "Poseidon Blue");
        LaptopSupport laptop4 = new LaptopSupport("ASUS ROG FLOW Z13", 16 , 1024, "Windows 11", "black");
        LaptopSupport laptop5 = new LaptopSupport(" Xiaomi Book Pro 16", 16, 512, "Windows 10", "Slate Grey");
        LaptopSupport laptop6 = new LaptopSupport("MSI Sword", 32, 512,"FreeDOS", "White");
       

        Set<LaptopSupport> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6));

        for (LaptopSupport laptop : laptops) {
            System.out.println(laptop);
        }

        userRequest(laptops);
    }

    public static void userRequest(Set<LaptopSupport> laptops) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - Наименование");
        System.out.println("2 - Объем оперативной памяти");
        System.out.println("3 - Объем памяти SSD/HDD");
        System.out.println("4 - Операционная система");
        System.out.println("5 - Цвет");

        int criteria = scanner.nextInt();
        scanner.nextLine();


        Map<String, Object> filterCriteria = new HashMap<>();

        switch (criteria) {
            case 1:
                System.out.println("Введите желаемую модель ноутбука:");
                Set<String> allModels = getAllModels(laptops);
                System.out.println("Все модели: " + allModels);
                String name = scanner.nextLine();
                filterCriteria.put("name", name);
                scanner.close();

                break;

            case 2:
                System.out.println("Введите минимальный объем оперативной памяти:");
                Set<Integer> allRam = getAllRam(laptops);
                System.out.println("Все модели: " + allRam);
                int minRam = scanner.nextInt();
                filterCriteria.put("ram", minRam);
                scanner.close();

                break;

            case 3:
                System.out.println("Введите минимальный объем памяти SSD/HDD:");
                Set<Integer> allMemory = getAllStorage(laptops);
                System.out.println("Все модели: " + allMemory);
                int minMemory = scanner.nextInt();
                filterCriteria.put("memory", minMemory);
                scanner.close();

                break;

            case 4:
                System.out.println("Введите желаемую операционную систему:");
                Set<String> allOs = getAllOs(laptops);
                System.out.println("Все модели: " + allOs);
                String os = scanner.nextLine();
                filterCriteria.put("os", os);
                scanner.close();

                break;
            case 5:
                System.out.println("Введите желаемый цвет:");
                Set<String> allColor = getAllColor(laptops);
                System.out.println("Все модели: " + allColor);
                String color = scanner.nextLine();
                filterCriteria.put("color", color);
                scanner.close();

                break;
            default:
                System.out.println("Некорректный выбор критерия.(Выход из программы!)");
                scanner.close();

                return ;
        }


        Set<LaptopSupport> filteredLaptops = filterLaptops(laptops, filterCriteria);

        System.out.println("Отфильтрованные ноутбуки:");
        for (LaptopSupport laptop : filteredLaptops) {
            System.out.println(laptop); 
        }
        
        
    }

    public static Set<LaptopSupport> filterLaptops(Set<LaptopSupport> laptops, Map<String, Object> filterCriteria) {
        Set<LaptopSupport> filteredLaptops = new HashSet<>(laptops);

        for (LaptopSupport laptop : laptops) {
            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                String criteria = entry.getKey();
                Object value = entry.getValue();

                switch (criteria) {
                    case "name":
                        if (!laptop.getName().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "ram":
                        if (laptop.getRam() < (int) value) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "storage":
                        if (laptop.getStorage() < (int) value) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "os":
                        if (!laptop.getOs().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                }
            }
        }

        return filteredLaptops;
    }

    // * Получаем весь модельный список
    public static Set<String> getAllModels(Set<LaptopSupport> laptops) {
        return laptops.stream()
                .map(LaptopSupport::getName)
                .distinct()
                .collect(Collectors.toSet());
    }

    // * Получаем весь список RAM
    public static Set<Integer> getAllRam(Set<LaptopSupport> laptops) {
        return laptops.stream()
                .map(LaptopSupport::getRam)
                .distinct()
                .sorted()
                .collect(Collectors.toSet());
    }

    // * Получаем весь список HDD/SSD по объему
    public static Set<Integer> getAllStorage(Set<LaptopSupport> laptops) {
        return laptops.stream()
                .map(LaptopSupport::getStorage)
                .distinct()
                .sorted()
                .collect(Collectors.toSet());
    }

    // * Получаем весь список ос
    public static Set<String> getAllOs(Set<LaptopSupport> laptops) {
        return laptops.stream()
                .map(LaptopSupport::getOs)
                .distinct()
                .collect(Collectors.toSet());
    }

    // * Получаем весь список цветов
    public static Set<String> getAllColor(Set<LaptopSupport> laptops) {
        return laptops.stream()
                .map(LaptopSupport::getColor)
                .distinct()
                .collect(Collectors.toSet());
    }
}