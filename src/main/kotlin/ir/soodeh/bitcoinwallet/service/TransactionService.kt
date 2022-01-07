package ir.soodeh.bitcoinwallet.service

import ir.soodeh.bitcoinwallet.service.dto.CreateTransactionRequest
import ir.soodeh.bitcoinwallet.service.dto.TransactionListRequest
import ir.soodeh.bitcoinwallet.service.dto.TransactionResponse

interface TransactionService {
    fun receive(createTransactionRequest: CreateTransactionRequest): TransactionResponse;
    fun getHistory(transactionListRequest: TransactionListRequest): List<TransactionResponse>;
}