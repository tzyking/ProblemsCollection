package Leetcode;
/*
 * Integer to Roman:
 * 
 * Given an integer, convert it to a roman numeral. 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Roman Numerals, as used today, are based on seven symbols:
	Symbol	Value
	I	1
	V	5
	X	10
	L	50
	C	100
	D	500
	M	1,000
	Numbers are formed by combining symbols together and adding the values. So II is two ones, 
	i.e. 2, and XIII is a ten and three ones, i.e. 13. There is no zero in this system, so 207, 
	for example, is CCVII, using the symbols for two hundreds, a five and two ones. 1066 is MLXVI,
	one thousand, fifty and ten, a five and a one.
	
	Symbols are placed from left to right in order of value, starting with the largest. 
	However, in a few specific cases,[2] to avoid four characters being repeated in succession (such as IIII or XXXX) 
	these can be reduced using subtractive notation as follows:
	the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
	X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
	C can be placed before D and M to make 400 and 900 according to the same pattern
	An example using the above rules would be 1904: this is composed of 1 (one thousand), 9 (nine hundreds), 
	0 (zero tens), and 4 (four units). To write the Roman numeral, each of the non-zero digits should be treated separately. 
	Thus 1,000 = M, 900 = CM, and 4 = IV. Therefore, 1904 is MCMIV. This reflects typical modern usage rather than 
	a universally accepted convention: historically Roman numerals were often written less consistently.[6]
	
	An inscription on Admiralty Arch, London. The numeral is 1910, although MCMX would be more usual
	A common exception to the practice of placing a smaller value before a larger in order to reduce 
	the number of characters, is the use of IIII instead of IV for 4, especially, although by no means exclusively, 
	on clock faces; see below. Another example of the same kind of thing is the representation of 1910 in Roman Numerals
	on Admiralty Arch, London - where DCCCC is used instead of CM for 900 (see illustration). In general, the "rules"
	about subtractively applied symbols are the most frequently "broken".
 * 
 * */


import java.util.Hashtable;

public class Integer2Roman {

	public static String UnitConvertor(int base, int UnitValue, Hashtable<Integer, String> MatchSet)
	{
		if(UnitValue == 4)
			return MatchSet.get(base) + MatchSet.get(base*5);
		else if(UnitValue == 9)
			return MatchSet.get(base) + MatchSet.get(base*10); 
		
		StringBuffer output = new StringBuffer(""); 
		if(UnitValue >= 5)
		{
			output.append(MatchSet.get(base*5)); 
			UnitValue = UnitValue - 5; 
		}
		
		while(UnitValue > 0)
		{
			output.append(MatchSet.get(base)); 
			UnitValue--;
		}	
		
		return output.toString();
	}
	
	public static String Integer2RomanConvertor(int input)
	{
		Hashtable<Integer, String> MatchSet = new Hashtable<Integer, String>();
		MatchSet.put(1, "I");
		MatchSet.put(5, "V");
		MatchSet.put(10, "X");
		MatchSet.put(50, "L");
		MatchSet.put(100, "C");
		MatchSet.put(500, "D");
		MatchSet.put(1000, "M");
		StringBuffer output = new StringBuffer("");
		int base = 1, tempInput = input; 
		while(tempInput >= 10)
		{
			tempInput = tempInput/10;
			base = base * 10; 
		}
		
		while(base > 0 && input > 0)
		{
			int UnitValue = input/base;
			output.append(UnitConvertor(base, UnitValue, MatchSet));
			input = input - (UnitValue * base);
			base = base/10;
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(Integer2RomanConvertor(3467));
	}

}
