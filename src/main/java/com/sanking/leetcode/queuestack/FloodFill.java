package com.sanking.leetcode.queuestack;

import java.util.LinkedList;
import java.util.Queue;

/**
 An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

 Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

 To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

 At the end, return the modified image.

 Example 1:
 Input:
 image = [[1,1,1],[1,1,0],[1,0,1]]
 sr = 1, sc = 1, newColor = 2
 Output: [[2,2,2],[2,2,0],[2,0,1]]
 Explanation:
 From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 by a path of the same color as the starting pixel are colored with the new color.
 Note the bottom corner is not colored 2, because it is not 4-directionally connected
 to the starting pixel.
 Note:

 The length of image and image[0] will be in the range [1, 50].
 The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFill {

    private static int[] d = new int[]{0,1,0,-1,0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {


        // if( image==null || image.length == 0 || image[0] == null || image[0].length == 0){
        //     return image;
        // }

        int x_size = image.length;
        int y_size = image[0].length;

        int currColor = image[sr][sc];

        if(currColor == newColor){
            return image;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sr*y_size + sc);

        image[sr][sc] = newColor;
        while(!queue.isEmpty()){

            int key = queue.poll();
            int x = key/y_size;
            int y = key%y_size;


            for(int i = 0 ; i < 4 ; i ++){
                int m = x + d[i];
                int n = y + d[i+1];
                if( m >=0 && m < x_size && n >= 0 && n<y_size && image[m][n] == currColor ){
                    queue.offer(m*y_size+n);
                    image[m][n] = newColor;
                }
            }

        }

        return image;

    }
}


class FloodFill_1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}