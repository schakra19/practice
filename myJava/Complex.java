public class Complex{

	private double real;
	private double imaginary;
	
	public Complex(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}

	public Complex add(final Complex other){
		return new Complex(this.real + other.real,this.imaginary + other.imaginary);
	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Complex test = (Complex) o;
		if(Double.compare(test.real,real) != 0) return false;
		if(Double.compare(test.imaginary,imaginary)!= 0) return false;

		return true;
	}

	public static void main(String[] args){
		final Complex expected = new Complex(6,2);
		final Complex a = new Complex(8,2);
		final Complex b = new Complex(-2,0);
		System.out.println(expected.equals(a.add(b)));
	}
}
