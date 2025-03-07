package ManelCodingFinance;

import java.util.Random;

public class CuentaBancaria {
    private String IBAN;
    private int saldo;
    private Cliente titular;

    public CuentaBancaria(Cliente titular) {
        this.IBAN = genIBAN();
        this.saldo = 0;
        this.titular = titular;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
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

    public void printCuenta() {
        System.out.println("Titular: " + titular.getDNI());
        System.out.println("IBAN: " + IBAN);
        System.out.println("Saldo: " + saldo);
    }
}
