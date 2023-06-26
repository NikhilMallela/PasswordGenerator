public class Main {
    public static void main(String[] args)
    {
        System.out.println();

        Generator gen = new Generator(8);
        String pass = gen.generatePassword();
        System.out.println(pass);

    }
}