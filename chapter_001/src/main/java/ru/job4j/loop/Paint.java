package ru.job4j.loop;

/**
*Class Paint, Draws a pyramid. Solution of the task 4.3.
*@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
*@since 0.1
*/

public class Paint {
/**
*Class Paint Draws a pyramid.
*/

/**
*Method pyramid draws a pyramid of a given height.
*@param h height pyramide.
*@return draws string.
*/
	public String pyramid(int h) {
		StringBuilder sb = new StringBuilder();
        int caret = 1;
        int space = h;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < space - 1; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < caret; j++) {
                sb.append("^");
            }
            for (int j = 0; j < space - 1; j++) {
                sb.append(" ");
            }
            sb.append("\r\n");
            caret += 2;
            space--;
        }
        return sb.toString();
    }
}
