package ManelCodingFinance;

import java.util.Random;

public class CuentaBancaria {
    private String IBAN;

    public String genIBAN() {
        Random rand = new Random();
        String IBAN = "ES6969777713";
        for (int i = 0; i < 10; i++) {
            IBAN += rand.nextInt(10);
        }
        return IBAN;
    }
}
