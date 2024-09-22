package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        var result = new LinkedList<Integer>();
        Integer upperBoundLocal = upperBound;
        Integer prev = null;
        while (count > 0) {
            upperBoundLocal = findBound(root, upperBoundLocal, prev);
            if (null == upperBoundLocal) {
                break;
            }
            result.add(upperBoundLocal);
            prev = upperBoundLocal;
            --upperBoundLocal;
            --count;

        }
        return result.stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());
    }

    private Integer findBound(Node node, int upperBound, Integer prev) {
        var val = node.value;
        var left = node.left;
        var right = node.right;

        if (val == upperBound) {
            return val;
        }
        if (val > upperBound && null != left) {
            return findBound(left, upperBound, val);
        }
        if (val < upperBound && null != right) {
            return findBound(right, upperBound, val);
        }

        return prev;
    }


}
