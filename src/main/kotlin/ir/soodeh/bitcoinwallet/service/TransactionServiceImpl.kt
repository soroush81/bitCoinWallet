package ir.soodeh.bitcoinwallet.service

import ir.soodeh.bitcoinwallet.entity.Transactions
import ir.soodeh.bitcoinwallet.repository.TransactionRepository
import ir.soodeh.bitcoinwallet.service.dto.CreateTransactionRequest
import ir.soodeh.bitcoinwallet.service.dto.TransactionListRequest
import ir.soodeh.bitcoinwallet.service.dto.TransactionResponse
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TransactionServiceImpl(
    val transactionRepository: TransactionRepository
) : TransactionService {
    override fun receive(createTransactionRequest: CreateTransactionRequest): TransactionResponse {
        val transaction = Transactions(
            id = createTransactionRequest.id!!,
            trxAmount = createTransactionRequest.amount!!,
            insertDt = LocalDateTime.now()
        )

        transactionRepository.save(transaction)
        return convertTransactionToTransactionResponse(transaction)
    }

    override fun getHistory(transactionListRequest: TransactionListRequest): List<TransactionResponse> {
        val transactions = transactionRepository.findByDateRange(transactionListRequest.walletId, transactionListRequest.startDt, transactionListRequest.endDt);
        return transactions.map { convertTransactionToTransactionResponse(it)}
    }

    private fun convertTransactionToTransactionResponse(transaction: Transactions): TransactionResponse {
        return TransactionResponse(
            id = transaction.id,
            walletId = transaction.wallet.id,
            amount = transaction.trxAmount,
            insertDt = transaction.insertDt
        )
    }



}