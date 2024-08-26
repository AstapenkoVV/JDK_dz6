package ru.gb.lisson6_dz;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
 * (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса
 * (запустить игру в цикле на 1000 и вывести итоговый счет).
 * Необходимо:
 * Создать свой Java Maven или Gradle проект;
 * Подключить зависимость lombok.
 * Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
 * Самостоятельно реализовать прикладную задачу;
 * Сохранить результат в HashMap<шаг теста, результат>
 * Вывести на экран статистику по победам и поражениям
 * Работы принимаются в виде ссылки на гит репозиторий со всеми ключевыми файлами проекта
 */

public class Main {
    static final int countIterations = 1000;
    static HashMap<Integer, Boolean> resultsWithSameDoor;
    static HashMap<Integer, Boolean> resultsWithOtherDoor;

    public static void main(String[] args) {
        Game game = new Game(3);
        resultsWithSameDoor = game.start(countIterations, false);
        resultsWithOtherDoor = game.start(countIterations, true);
        System.out.println("\nСтатистика при отказе от изменения двери: ");
        AtomicInteger winStat = new AtomicInteger();
        for (HashMap.Entry<Integer, Boolean> entry : resultsWithSameDoor.entrySet()) {
            if (entry.getValue()) {
                winStat.getAndIncrement();
            }
        }
        System.out.printf("Из %s игр выиграно %s", resultsWithSameDoor.size(), winStat);
        System.out.println('\n');
        System.out.println("Статистика при изменении двери: ");
        winStat.set(0);
        for (HashMap.Entry<Integer, Boolean> entry : resultsWithOtherDoor.entrySet()) {
            if (entry.getValue()) {
                winStat.getAndIncrement();
            }
        }
        System.out.printf("Из %s игр выиграно %s", resultsWithOtherDoor.size(), winStat);
    }
}