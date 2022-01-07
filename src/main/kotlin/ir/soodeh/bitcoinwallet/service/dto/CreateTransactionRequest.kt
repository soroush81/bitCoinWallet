package ir.soodeh.bitcoinwallet.service.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CreateTransactionRequest (
    val id:Long,
    val walletId:Long,
    val amount:BigDecimal
    )
