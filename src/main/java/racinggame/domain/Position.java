package racinggame.domain;

import static java.util.Objects.hash;

public class Position {
	private final int position;

	public Position(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
		}
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Position position1 = (Position) o;

		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return hash(position);
	}
}
