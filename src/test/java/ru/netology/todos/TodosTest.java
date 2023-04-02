package ru.netology.todos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

    String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    // 1) Тест на добавление задач разных типов

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // 2) Тест на поиск задачи типа SimpleTask

    @Test
    public void shouldMatchesSimpleTask() {
        Task[] expected = { simpleTask };
        Task[] actual = todos.search("Купить Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    // 3) Тест на поиск задачи типа Epic

    @Test
    public void shouldMatchesEpic() {
        Task[] expected = { epic };
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    // 4) Тест на поиск задачи типа Meeting

    @Test
    public void shouldMatchesMeeting() {
        Task[] expected = { meeting };
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    // 5) Тест на поиск задач если нет совпадений

    @Test
    public void shouldMatchesTasksFalse() {
        Task[] expected = {};
        Task[] actual = todos.search("Нет слвпадений");
        Assertions.assertArrayEquals(expected, actual);
    }

    // 6) Тест, если есть совпадения в нескольких задачах

    @Test
    public void shouldMatchesTasksAllFind() {
        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }
}
