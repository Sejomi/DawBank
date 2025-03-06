package ManelCodingFinance;

import java.util.Random;

public class CuentaBancaria {
    private String IBAN;
    private int saldo;
    private Cliente titular;

    public CuentaBancaria(String IBAN, Cliente titular) {
        this.IBAN = IBAN;
        this.saldo = 0;
        this.titular = titular;
    }

    public String genIBAN() {
        Random rand = new Random();
        String IBAN = "ES6969777713";
        for (int i = 0; i < 10; i++) {
            IBAN += rand.nextInt(10);
        }
        return IBAN;
    }
}
