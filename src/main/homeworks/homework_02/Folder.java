package ru.gb.homeworks.homework_02;

import java.util.ArrayList;
import java.util.List;

class Folder implements Component {
    private String name;
    private List<Component> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        if (components.contains(component)) {
            components.remove(component);
        } else {
            throw new IllegalArgumentException("Нет такой папки или файла");
        }
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public void showDetails() {
        System.out.println("Папка: " + name);
        if (components.isEmpty()) {
            System.out.println("Папка пуста");
        } else {
            System.out.println("содержит: ");
            for (Component component : components) {
                component.showDetails();
            }
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }
}
