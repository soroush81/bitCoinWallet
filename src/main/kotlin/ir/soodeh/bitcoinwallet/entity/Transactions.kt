package ir.soodeh.bitcoinwallet.entity

import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="Transactions")
@NamedQuery(name = "Transactions.findByDateRange", query = "select t from Transactions t where t.insertDt > ?1 and t.insertDt < ?2")
class Transactions {

    constructor(id: Long, trxAmount: BigDecimal, insertDt: LocalDateTime) {
        this.id = id
        this.trxAmount = trxAmount
        this.insertDt = insertDt
    }

    constructor()

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long =-1;

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    lateinit var wallet: Wallet

    @Column(name = "trxAmount")
    var trxAmount: BigDecimal = BigDecimal("0");

    @Column(name = "insertDt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    var insertDt: LocalDateTime = LocalDateTime.now();


}