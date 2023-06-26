import java.util.Random;

public class Generator
{
    private int maxLength;

    public Generator( int len )
    {
        maxLength = len;
    }

    public String generatePassword()
    {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()_-";

        String allCharacters = uppercaseLetters + lowercaseLetters + digits + specialCharacters;

        Random random = new Random();
        StringBuilder password = new StringBuilder(maxLength);

        // Ensure at least one uppercase letter
        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));

        // Ensure at least one number
        password.append(digits.charAt(random.nextInt(digits.length())));

        // Ensure at least one special character
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Fill the remaining password length with random characters
        for (int i = 3; i < maxLength; i++)
        {
            int randomIndex = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }

        // Shuffle the password to randomize the positions of the required characters
        char[] passwordArray = password.toString().toCharArray();
        for (int i = password.length() - 1; i > 0; i--)
        {
            int j = random.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray);
    }

}
