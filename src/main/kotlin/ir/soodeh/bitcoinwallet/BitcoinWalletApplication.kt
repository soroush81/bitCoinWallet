package ir.soodeh.bitcoinwallet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BitcoinWalletApplication

fun main(args: Array<String>) {
    runApplication<BitcoinWalletApplication>(*args)
}
