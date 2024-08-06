import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//validador de senha refatorado para aparecer todas as mensagem de error juntas.

public class validatorPassword {
    public static void main(String[] args){
        String password = "aPP1*2233";
        validatorPassword validator = new validatorPassword();
        validator.validatePassword(password);
    }

    public void validatePassword(String password){
        List<String> errors = new ArrayList<>();

        if (!isValid(password, errors)){
            for(String error: errors){
                System.out.println(error);
            }
        } else {
            System.out.println(Message.VALID_PASSWORD);
        }
    }

    private boolean isValid(String password, List<String>  errors){
        boolean isValid = true;
        if(!hasMinimumLength(password)){
            errors.add(Message.MIN_LENGTH);
            isValid = false;
        }

        if(!hasUpperCase(password)) {
            errors.add(Message.UPPERCASE_LETTER);
            isValid = false;
        }

        if(!hasLowerCase(password)) {
            errors.add(Message.LOWERCASE_LETTER);
            isValid = false;
        }

        if(!hasDigit(password)){
            errors.add(Message.DIGIT);
            isValid = false;
        }

        if(!hasSpecialCharacter(password)) {
            errors.add(Message.SPECIAL_CHARACTER);
            isValid = false;
        }
    return isValid;

    }


    private boolean hasMinimumLength(String password){
        return password.length() >= 8;
    }

    private boolean hasUpperCase(String password){
        return Pattern.compile("[A-Z]").matcher(password).find();
    }

    private boolean hasLowerCase(String password){
        return Pattern.compile("[a-z]").matcher(password).find();
    }

    private boolean hasDigit(String password){
        return Pattern.compile("[0-9]").matcher(password).find();
    }

    private boolean hasSpecialCharacter(String password){
        return Pattern.compile("[!@#$%&*()_+=|<>?{}~-]").matcher(password).find();
    }



    private static class Message{
        static final String VALID_PASSWORD = "Senha Válida!";
        static final String MIN_LENGTH = "A senha deve conter pelo menos 8 caracteres.";
        static final String UPPERCASE_LETTER = "A senha deve conter pelo menos uma letra Maiúscula.";
        static final String LOWERCASE_LETTER = " A senha deve conter pelo menos uma letra Minúscula.";
        static final String DIGIT = "A senha deve conter pelo menos um número.";
        static final String SPECIAL_CHARACTER = "A senha deve conter pelo menos um caractere especial.";

    }

}


