package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

public class CuentaAhorrosStepdefs {

    private String entidadBcancaria;

    private int monto;

    private int montoARetirar;

    @Dado("un usuario registrado en el banco")
    public void unUsuarioRegistradoEnElBanco() {
        System.out.println("Precondicion 1");
    }

    @Y("el banco al que pertenece la cuenta es Davivienda")
    public void elBancoAlQuePerteneceLaCuentaEsDavivienda() {
        System.out.println("Precondicion 2");
    }

    //Escenario: 01 Consultar saldo
    @Dado(":   un usuario requiere saber su saldo")
    public void unUsuarioRequiereSaberSuSaldo() {
        System.out.println("Paso 1");
    }

    @Cuando(": visualice la cantidad de dinero disponible")
    public void visualiceLaCantidadDeDineroDisponible() {

        System.out.println("Visualizo el saldo");
    }

    @Entonces(": el sistema muestra el saldo correspondiente")
    public void elSistemaMuestraElSaldoCorrespondiente() {
        int saldo = 10000;
        Assert.assertEquals(saldo, 10000);
        System.out.println("Fin prueba 1");
    }

    //Esquema del escenario:  02 Transferencia banco no autorizado
    @Dado(": un usuario realiza una transferencia")
    public void unUsuarioRealizaUnaTransferencia() {
    }

    @Y(": la cuenta destino es del banco {string}")
    public void laCuentaDestinoEsDelBanco(String banco) {
        entidadBcancaria = banco;
        System.out.println("Banco: "+ entidadBcancaria);
    }

    @Cuando(": realice una transferencia a un banco no soportado")
    public void realiceUnaTransferenciaAUnBancoNoSoportado() {

    }

    @Entonces(": el sistema debera mostrar un error {string}")
    public void elSistemaDeberaMostrarUnError(String mensaje) {
        Assert.assertTrue(entidadBcancaria.equals("Bancolombia")   || entidadBcancaria.equals("BBVA") );
        Assert.assertEquals(mensaje, "Transferencia no autorizada al banco");
    }

    //Escenario:  03 Recibir deposito
    @Dado(": un usuario requiera recibir un deposito")
    public void unUsuarioRequieraRecibirUnDeposito() {
    }

    @Cuando(": reciba un deposito")
    public void recibaUnDeposito() {
    }

    @Entonces(": el sistema debera mostrar el monto del deposito y el dinero actual")
    public void elSistemaDeberaMostrarElMontoDelDepositoYElDineroActual() {
        monto  = 0;
        int deposito = 10000;
        monto = deposito + monto;

        Assert.assertEquals("Monto:"+ deposito, "Monto:"+ 10000);
        Assert.assertEquals("Saldo:"+ monto, "Saldo:"+ 10000);
    }

    //Escenario:  04 Retiro de saldo no permitido
    @Dado(": un usuario con un monto x")
    public void unUsuarioConUnMontoX() {
        System.out.println("Monto" + monto);
    }

    @Cuando(": solicite un monto mayor a x")
    public void soliciteUnMontoMayorAX() {
        System.out.println("Monto" + montoARetirar);
    }

    @Entonces(": el sistema debera mostrar el un mensaje de error {string}")
    public void elSistemaDeberaMostrarElUnMensajeDeError(String mensaje) {
        monto = 50000;
        montoARetirar = 75000;
        Assert.assertTrue(monto < montoARetirar);
        Assert.assertEquals(mensaje, "Saldo insuficiente");
    }
}
