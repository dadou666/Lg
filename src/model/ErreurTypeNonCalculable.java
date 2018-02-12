package model;

public class ErreurTypeNonCalculable extends Error {
	public Si si;
	public ErreurTypeNonCalculable(Si si) {
		this.si=si;
	}
}
