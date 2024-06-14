import java.util.regex.Pattern;

//Validador de senha refatorado (reorganizado e mais legível)

public class Validator {
        public static void main(String[] args){
            String password = "12544589Ai#";
            Validator validator = new Validator();
            validator.validatePassword(password);
        }

        public void  validatePassword(String password) {
            if (isValid(password)) {
                System.out.println(Message.VALID_PASSWORD);

            } else {
                System.out.println(Message.INVALID_PASSWORD);
            }
        }
            private boolean isValid(String password) {
                return hasMinimumLength(password) &&
                        hasUpperCase(password) &&
                        hasLowerCase(password) &&
                        hasDigit(password) &&
                        hasSpecialCharacter(password);
            }

            private boolean hasMinimumLength(String password){
                if(password.length() < 8 ){
                    System.out.println(Message.MIN_LENGTH);
                    return false;
                }

                return true;
            }

            private boolean  hasUpperCase(String password){
            if (!Pattern.compile("[A-Z]").matcher(password).find()){
                System.out.println(Message.UPPERCASE_LETTER);
                 return false;
            }

            return true;
        }

        private boolean hasLowerCase(String password){
            if(!Pattern.compile("[a-z]").matcher(password).find()){
                System.out.println(Message.LOWERCASE_LETTER);
                return false;
            }
            return true;
        }

        private boolean hasDigit(String password){
            if (!Pattern.compile("[0-9]").matcher(password).find()){
                System.out.println(Message.DIGIT);
                 return false;
            }
            return true;
        }


        private boolean hasSpecialCharacter(String password) {
            if (!Pattern.compile("[!@#$%&*()_+=|<>?{}~-]").matcher(password).find()){
                System.out.println(Message.SPECIAL_CHARACTER);
                return false;
            }
            return true;
        }



          private static class Message{
                static final String VALID_PASSWORD = "Senha Válida!";
                static final String INVALID_PASSWORD = "Senha Inválida";
                static final String MIN_LENGTH = "A senha deve conter pelo menos 8 caracteres.";
                static final String UPPERCASE_LETTER = "A senha deve conter pelo menos uma letra Maiúscula.";
                static final String LOWERCASE_LETTER = " A senha deve conter pelo menos uma letra Minúscula.";
                static final String DIGIT = "A senha deve conter pelo menos um número.";
                static final String SPECIAL_CHARACTER = "A senha deve conter pelo menos um caractere especial.";

          }
        }


