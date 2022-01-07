package ir.soodeh.bitcoinwallet.service.dto

import java.time.LocalDateTime

data class TransactionListRequest(val walletId:Long, val startDt:LocalDateTime, val endDt:LocalDateTime) {

}