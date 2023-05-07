public class test {
    public static void main(String[] args) {
        String s = "30 May 2023";
        String[] date = s.split(" ");
        int i = Integer.parseInt(date[0]);
        String day = Integer.toString(i);
        System.out.println(date[1] + " " + day);
    }
}
