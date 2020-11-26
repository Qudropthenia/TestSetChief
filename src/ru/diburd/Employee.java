package ru.diburd;

import java.time.LocalDate;
import java.util.UUID;

// Структура сотрудника
public class Employee {
	private String uuid;
	private Employee chief;
	private String name;
	private String patronymic;
	private Gender gender;

	public Employee() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Employee getChief() {
		return chief;
	}

	public void setChief(Employee chief) {
		this.chief = chief;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee{ " +
				"uuid = '" + uuid + '\'' +
				", chiefU = '" + chief + '\'' +
				", name = '" + name + '\'' +
				", patronymic = '" + patronymic + '\'' +
				", gender = " + gender + " }";
	}

	enum Gender {
		MAN, WOMAN
	}
}
