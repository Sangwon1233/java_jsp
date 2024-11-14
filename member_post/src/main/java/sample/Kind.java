package sample;

public enum Kind {
	CLOVER(1,"클로버"),HEART(10,"하트"),DIAMOND(100,"다이아"),SPADE(1000,"스페이드");

	private int value;
	private String name;
	
	Kind(int value,String name) {
		this.value=value;
		this.name=name;
	}
	public int getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	
	
}
