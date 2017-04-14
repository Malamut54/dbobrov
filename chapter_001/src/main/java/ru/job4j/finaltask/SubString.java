package ru.job4j.finaltask;

/**
*Find substring in String. Task 6 final.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/

public class SubString {
/**
*Class Substring. Find sustring in String.
*/

/**
*Is there any substring in String.
*@param origin - String.
*@param sub - Substring.
*@return boolean - returns whether the substring part of the string.
*/
	public boolean contains(String origin, String sub) {
		char[] originArr = origin.toCharArray();
		char[] subArr = sub.toCharArray();

		int lengthSub = subArr.length;
		int count = 0;

        for (int i = 0; i < subArr.length;) {
            for (int j = 0; j < originArr.length;) {
                if (i == subArr.length & subArr[i] != originArr[j]) {
                    i = 0;
                }
                if (subArr[i] == originArr[j]) {
                    count++;
                    i++;
                    j++;
                } else {
                    i = 0;
                    count = 0;
                    j++;
                }
                if (count == subArr.length) {
                    return (count == lengthSub);
                }
                if (j == originArr.length) {
                    return (count == lengthSub);
                }
            }
        }
        return (count == lengthSub);
	}
}