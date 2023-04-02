package ru.netology.todos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TasksTest {

    // 1) Тест, когда есть совпадение в SimpleTask

    @Test
    public void shouldMatchesSimpleTasksTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    // 2) Тест, когда нет совпадения в SimpleTask

    @Test
    public void shouldMatchesSimpleTasksFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить друзьям");
        Assertions.assertEquals(expected, actual);
    }

    // 3) Тест, когда есть совпадение в Epic

    @Test
    public void shouldMatchesEpicTrue() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }

    // 4) Тест, когда нет совпадения в Epic

    @Test
    public void shouldMatchesEpicFalse() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Помидоры");
        Assertions.assertEquals(expected, actual);
    }

    // 5) Тест, когда есть совпадение в Meeting в поле topic

    @Test
    public void shouldMatchesMeetingInTopicFieldTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);

    }

    // 6) Тест, когда есть совпадение в Meeting в поле project

    @Test
    public void shouldMatchesMeetingInProjectFieldTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);

    }

    // 7) Тест, когда нет совпадения в Meeting в поле topic

    @Test
    public void shouldMatchesMeetingInTopicFieldFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 4й версии приложения");
        Assertions.assertEquals(expected, actual);

    }

    // 8) Тест, когда нет совпадения в Meeting в поле project

    @Test
    public void shouldMatchesMeetingInProjectFieldFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Приложение Банка");
        Assertions.assertEquals(expected, actual);

    }
}
