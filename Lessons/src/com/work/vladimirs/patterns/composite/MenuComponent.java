package com.work.vladimirs.patterns.composite;

/**
 * MenuComponent представляет интерфейс объектов MenuItem и Menu. Мы используем
 * абтрактный класс, потому что собираемся предоставить реализации по умолчанию.
 * Задачей класса является определение интерфейса листьев и комбинационных узлов.
 *
 * Так как одни методы имеют смысл только для MenuItem, а другие —
 * только для Menu, реализация по умолчанию инициирует UnsupportedOperationException.
 * Если объект MenuItem или Menu не поддерживает операцию, ему не нужно
 * ничего делать — он просто наследует реализацию по умолчанию.
 */
abstract class MenuComponent {

    /**
     * «Операционный» метод для MenuItem..
     */
    public String getName() {
        throw new UnsupportedOperationException();
    }

    /**
     * «Операционный» метод для MenuItem..
     */
    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    /**
     * «Операционный» метод для MenuItem..
     */
    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    /**
     * «Операционный» метод для MenuItem..
     */
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    /**
     * Метод print() реализуется как в Menu, так и в MenuItem, но мы предоставляем реализацию по умолчанию.
     */
    public void print() {
        throw new UnsupportedOperationException();
    }

    /**
     * «Комбинационный» метод для добавления MenuComponent.
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * «Комбинационный» метод для удаления MenuComponent.
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * «Комбинационный» метод для получения MenuComponent.
     */
    public MenuComponent getChild(int idx) {
        throw new UnsupportedOperationException();
    }
}
