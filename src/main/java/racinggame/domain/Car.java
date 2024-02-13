package racinggame.domain;

import java.util.Objects;
import java.util.Random;
import racinggame.utils.StringUtils;

public class Car {

	private static final int FORWARD_NUM = 4;
	private static final int MAX_BOUND = 10;

	private final String name;
	private int position = 0;

	public Car(final String name) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Car car = (Car) o;
		return Objects.equals(name, car.name);
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.movable()) {
			this.position++;
		}
	}

	public void move(int randomNo) {
		if (randomNo >= FORWARD_NUM) {
			this.position++;
		}
	}

	public void move() {
		if (getRandomNo() >= FORWARD_NUM) {
			this.position++;
		}
	}

	private int getRandomNo() {
		Random random = new Random();
		return random.nextInt(MAX_BOUND);
	}
}