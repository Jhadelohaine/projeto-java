import java.sql.SQLOutput;
import java.util.regex.Pattern;

// validador de senha

public class passwordValidator {


    public static void main(String[] args) {
        String password = "12511123155A5";
        passwordValidator validator = new passwordValidator();
        validator.validatePassword(password);
    }



    public void validatePassword(String password){
        if (isValid(password)){
            System.out.println("Senha válida!");
        } else {
            System.out.println("Senha inválida!");
        }
    }

    private boolean isValid(String password) {
        if (password.length() < 8) {
            System.out.println("A senha dee ter pelo menos 8 caracteres. ");
            return false;
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            System.out.println("A senha deve conter pelo menos uma letra maiúscula!");
            return false;
        }

        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            System.out.println(" A senha deve conter pelo menos uma letra minúscula!");
            return false;
        }

        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            System.out.println("A seha deve conter pelo menos um digito numérico!");
            return false;
        }

        if (!Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]").matcher(password).find()) {
            System.out.println("A senha deve conter pelo menos um caractere especial.");
            return false;
        }

        return true;

    }
}