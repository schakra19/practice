class IsPermutationPalindrome{

	public boolean isPermutationOfPalindrome(String phrase){
		int bitVector = createBitVector(phrase);
		return bitVector == 0 | checkIfOnlyOneBitSet(bitVector);
	
	}

	public int createBitVector(String phrase){
		int bitVector = 0;
		for(char c : phrase.toCharArray()){
			int x = getCharToNumber(c);
			bitVector = toggleBit(bitVector, x);
		}
		return bitVector;
	}

	public int getCharToNumber(char c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');

		int val = Character.getNumericValue(c);
		if(a <= val && val <= z)
			return val -a;
		else if(A <= val && val >= Z)
			return val - A;

		return -1;
	}

	public int toggleBit(int bitVector, int index){
		if(index < 0) return bitVector;
		
		int mask = 1 << index;
		if((bitVector & mask) == 0)
			bitVector |= mask;
		else
			bitVector &= ~mask;

		return bitVector;
	}

	boolean checkIfOnlyOneBitSet(int bitVector){
		return ((bitVector & (bitVector -1)) == 0);
	}
	public static void main(String[] args){
		String st = "Tact Coa";
		st = st.replaceAll("\\s","");
		IsPermutationPalindrome p = new IsPermutationPalindrome();
		System.out.println(p.isPermutationOfPalindrome(st));
	}
}
