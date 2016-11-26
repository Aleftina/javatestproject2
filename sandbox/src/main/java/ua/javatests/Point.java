package ua.javatests;

import java.awt.geom.Point2D;

/**
 1. Создать класс Point для представления точек на двумерной плоскости. Объекты этого класса должны содержать два атрибута,
 которые соответствуют координатам точки на плоскости.

 2. Создать функцию
 public static double distance(Point p1, Point p2)
 которая вычисляет расстояние между двумя точками. Для вычисления квадратного корня можно использовать функцию Math.sqrt

 3. Сделать запускаемый класс, то есть содержащий функцию
 public static void main(String[] args) {...}
 и при помощи него убедиться, что функция вычисления расстояния между точками действительно работает.
 Результат вычисления выводить на экран и контролировать визуально.

 4. Реализовать то же самое (вычисление расстояния между двумя точками) при помощи метода в классе Point, и добавить в созданный
 в предыдущем пункте запускаемый класс примеры использования метода вместо ранее созданной функции.
 */

public class Point {

    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }

    public double distanceToPoint(Point p2){
        return Math.sqrt(Math.pow((p2.x - this.x), 2) + Math.pow((p2.y - this.y), 2));
    }
}
