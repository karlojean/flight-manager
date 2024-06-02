package com.flight_manager.validations;

public class CpfUtils {

    public static boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * (10 - i);
            }
            int firstDigit = 11 - (sum % 11);
            if (firstDigit == 10 || firstDigit == 11) {
                firstDigit = 0;
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * (11 - i);
            }
            int secondDigit = 11 - (sum % 11);
            if (secondDigit == 10 || secondDigit == 11) {
                secondDigit = 0;
            }

            return (cpf.charAt(9) - '0') == firstDigit && (cpf.charAt(10) - '0') == secondDigit;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
