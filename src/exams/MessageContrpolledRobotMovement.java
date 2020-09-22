package exams;

// Read only region start
public class MessageContrpolledRobotMovement {
    public static void main(String[] args) {
        System.out.println(funtion(5, 4, "1-2-E", "r M I m L M r"));
    }

    static String funtion(int input1, int input2, String input3, String input4) {
        String[] x = input4.split(" ");
        int[][] grid = new int[input1 + 1][input2 + 1];
        String output = "";
        int r, c;
        String d;
        String[] t = input3.split("-");
        r = Integer.parseInt(t[0]);
        c = Integer.parseInt(t[1]);
        d = t[2];
        for (String q : x) {
            if (q.equals("L")) {
                if (d.equals("N"))
                    d = "W";
                else if (d.equals("E"))
                    d = "N";
                else if (d.equals("S"))
                    d = "E";
                else if (d.equals("W"))
                    d = "S";
            } else if (q.equals("R")) {
                if (d.equals("N"))
                    d = "E";
                else if (d.equals("E"))
                    d = "S";
                else if (d.equals("S"))
                    d = "W";
                else if (d.equals("W"))
                    d = "N";
            } else {
                if (d.equals("N")) {
                    c = c + 1;
                    try {
                        int w = grid[r][c];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        output = r + "-" + (c - 1) + "-" + d + "-" + "ER";
                        return (output);
                    }
                } else if (d.equals("E")) {
                    r = r + 1;
                    try {
                        int w = grid[r][c];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        output = (r - 1) + "-" + c + "-" + d + "-" + "ER";
                        return output;
                    }
                } else if (d.equals("S")) {
                    c = c - 1;
                    try {
                        int w = grid[r][c];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        output = r + "-" + (c + 1) + "-" + d + "-" + "ER";
                        return output;
                    }
                } else if (d.equals("W")) {
                    r = r - 1;
                    try {
                        int w = grid[r][c];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        output = (r + 1) + "-" + c + "-" + d + "-" + "ER";
                        return (output);
                    }
                }
            }
        }
        output = r + "-" + c + "-" + d;
        return output;
    }
}