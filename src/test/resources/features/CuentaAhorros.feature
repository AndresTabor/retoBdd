# language:es

Característica: Operaciones con cuenta de ahorros
  Antecedentes:
  Dado un usuario registrado en el banco
    Y  el banco al que pertenece la cuenta es Davivienda

  @pruebaDeHumo
  Escenario: 01 Consultar saldo
    Dado :   un usuario requiere saber su saldo
    Cuando : visualice la cantidad de dinero disponible
    Entonces : el sistema muestra el saldo correspondiente

  @retest
  Esquema del escenario:  02 Transferencia banco no autorizado
    Dado : un usuario realiza una transferencia
    Y : la cuenta destino es del banco "<banco>"
    Cuando : realice una transferencia a un banco no soportado
    Entonces : el sistema debera mostrar un error "Transferencia no autorizada al banco"
    Ejemplos:
      | banco       |
      | Bancolombia |
      | BBVA        |

  @regresion
  Escenario:  03 Recibir deposito
    Dado : un usuario requiera recibir un deposito
    Cuando : reciba un deposito
    Entonces : el sistema debera mostrar el monto del deposito y el dinero actual

  @regresion
  Escenario:  04 Retiro de saldo no permitido
    Dado : un usuario con un monto x
    Cuando : solicite un monto mayor a x
    Entonces : el sistema debera mostrar el un mensaje de error "Saldo insuficiente"
