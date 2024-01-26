// Критерии ноутбука для магазина техники:
// 0 - Название
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система(FreeDOS/Linux/MacOS)
// 4 - Цвет
// 5 - Расскалдка(графировка клавиш) -(only US/ US+RUS)
// 6 - Тип жесткого диска (SSD/HDD)
// 7 - Диагональ экрана 
// 8 - Процессор(частота) - ГГЦ
// 9 - Количество ядерпроцессора
import java.util.Objects;

public class LaptopSupport {
    public static void main(String[] args) {
    }
        private String name;
        private int ram;
        private int storage;
        private String os;
        private String color;
    

        // 1. Название 2.ОЗУ 3.Память 4.ОС 5.Цвет
   

    public LaptopSupport(String name, int ram, int storage, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }


    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  "Название модели: '" + name + '\'' +
                ", объем оперативной памяти: '" + ram + '\'' +
                ", объем памяти: '" + storage + '\'' +
                ", операционная система: '" + os + '\'' +
                ", цвет: '" + color + '\'';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LaptopSupport laptop = (LaptopSupport) obj;
        return name.equals(laptop.name) && ram == laptop.ram && storage == laptop.storage && ram == laptop.ram && os.equals(laptop.os) && color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ram, storage, os, color);
    }
}