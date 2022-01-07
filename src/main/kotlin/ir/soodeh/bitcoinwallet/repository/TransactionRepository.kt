package ir.soodeh.bitcoinwallet.repository

import ir.soodeh.bitcoinwallet.entity.Transactions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime


@Repository
interface TransactionRepository : JpaRepository<Transactions, Long> {

    fun findByDateRange(walletId:Long, startDt: LocalDateTime,endDt:LocalDateTime): List<Transactions>;

}