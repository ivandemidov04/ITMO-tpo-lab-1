package task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FibonacciHeapTest {

    @Test
    public void testInsertAndGetMin() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        Assertions.assertEquals(5, heap.getMin(), "Минимальный элемент после вставки 10, 5, 20 должен быть 5");
    }

    @Test
    public void testExtractMin() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        Assertions.assertEquals(5, heap.extractMin(), "Извлеченный минимальный элемент должен быть 5");
        Assertions.assertEquals(10, heap.getMin(), "Новый минимальный элемент после извлечения должен быть 10");
    }

    @Test
    public void testDecreaseKey() {
        FibonacciHeap heap = new FibonacciHeap();
        FibonacciHeap.Node node1 = new FibonacciHeap.Node(10);
        FibonacciHeap.Node node2 = new FibonacciHeap.Node(20);
        heap.insert(node1.key);
        heap.insert(node2.key);
        heap.decreaseKey(node2, 5);
        Assertions.assertEquals(5, heap.getMin(), "Минимальный элемент после уменьшения ключа должен быть 5");
    }

    @Test
    public void testIsEmpty() {
        FibonacciHeap heap = new FibonacciHeap();
        Assertions.assertTrue(heap.isEmpty(), "Куча должна быть пустой после создания");
        heap.insert(10);
        Assertions.assertFalse(heap.isEmpty(), "Куча не должна быть пустой после вставки элемента");
    }

    @Test
    public void testSize() {
        FibonacciHeap heap = new FibonacciHeap();
        Assertions.assertEquals(0, heap.size(), "Размер кучи после создания должен быть 0");
        heap.insert(10);
        heap.insert(20);
        Assertions.assertEquals(2, heap.size(), "Размер кучи после вставки двух элементов должен быть 2");
        heap.extractMin();
        Assertions.assertEquals(1, heap.size(), "Размер кучи после извлечения одного элемента должен быть 1");
    }

    @Test
    public void testConsolidation() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(15);
        heap.extractMin();
        Assertions.assertEquals(10, heap.getMin(), "Минимальный элемент после консолидации должен быть 10");
    }

    @Test
    public void testMultipleOperations() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(15);
        Assertions.assertEquals(5, heap.extractMin(), "Первый извлеченный элемент должен быть 5");
        Assertions.assertEquals(10, heap.extractMin(), "Второй извлеченный элемент должен быть 10");
        Assertions.assertEquals(15, heap.extractMin(), "Третий извлеченный элемент должен быть 15");
        Assertions.assertEquals(20, heap.extractMin(), "Четвертый извлеченный элемент должен быть 20");
        Assertions.assertTrue(heap.isEmpty(), "Куча должна быть пустой после извлечения всех элементов");
    }

    @Test
    public void testDecreaseKeyToMin() {
        FibonacciHeap heap = new FibonacciHeap();
        FibonacciHeap.Node node1 = new FibonacciHeap.Node(10);
        FibonacciHeap.Node node2 = new FibonacciHeap.Node(20);
        heap.insert(node1.key);
        heap.insert(node2.key);
        heap.decreaseKey(node2, 5);
        Assertions.assertEquals(5, heap.getMin(), "Минимальный элемент после уменьшения ключа должен быть 5");
        heap.decreaseKey(node1, 3);
        Assertions.assertEquals(3, heap.getMin(), "Минимальный элемент после второго уменьшения ключа должен быть 3");
    }

    @Test
    public void testExtractMinOnEmptyHeap() {
        FibonacciHeap heap = new FibonacciHeap();
        Assertions.assertThrows(IllegalStateException.class, heap::extractMin, "Извлечение из пустой кучи должно выбрасывать исключение");
    }

    @Test
    public void testDecreaseKeyOnSingleNode() {
        FibonacciHeap heap = new FibonacciHeap();
        FibonacciHeap.Node node = new FibonacciHeap.Node(10);
        heap.insert(node.key);
        heap.decreaseKey(node, 5);
        Assertions.assertEquals(5, heap.getMin(), "Минимальный элемент после уменьшения ключа должен быть 5");
    }
}
