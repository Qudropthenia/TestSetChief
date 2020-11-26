package ru.diburd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // Создаём список считанныйх из XML файла сотрудников
        List<EmplTemp> readingFromXML = initList();
        // Конечный список сотрудников
        List<Employee> employees = new ArrayList<>();

        // Поиск и подстановка босса
        for (EmplTemp temp : readingFromXML) {
            if (temp.getChiefUUID() != null) {

                Optional<EmplTemp> optChief = readingFromXML.stream()
                        .filter(emplTemp -> emplTemp.getUuid().equals(temp.getChiefUUID()))
                        .findFirst();
                if (optChief.isPresent()) {
                    Employee chief = optChief.get();
                    temp.setChief(chief);
                }
            }
            employees.add(temp);
        }
        employees.forEach(System.out::println);
    }

    private static List<EmplTemp> initList() {
        List<EmplTemp> list = new ArrayList<>();

        EmplTemp temp = new EmplTemp();
        temp.setUuid("9a2acbd5-b7eb-4104-aab0-8a93c39524e0");
        temp.setName("Эмулик");
        temp.setPatronymic("Альбертович");
        temp.setGender(Employee.Gender.MAN);
        list.add(temp);

        temp = new EmplTemp();
        temp.setUuid("e18657c7-d02c-43f8-b595-48195708e644");
        temp.setChiefUUID("9a2acbd5-b7eb-4104-aab0-8a93c39524e0");
        temp.setName("Габдир");
        temp.setPatronymic("Павлович");
        temp.setGender(Employee.Gender.MAN);
        list.add(temp);

        temp = new EmplTemp();
        temp.setUuid("9b21d3b1-8174-40d9-a353-1ff780141f46");
        temp.setChiefUUID("9a2acbd5-b7eb-4104-aab0-8a93c39524e0");
        temp.setName("Атине");
        temp.setPatronymic("Кирилловна");
        temp.setGender(Employee.Gender.WOMAN);
        list.add(temp);

        temp = new EmplTemp();
        temp.setUuid("6f4280c9-da97-489a-a0c7-77f22e169b0e");
        temp.setName("Челли");
        temp.setPatronymic("Платоновна");
        temp.setGender(Employee.Gender.WOMAN);
        list.add(temp);

        return list;
    }
}
