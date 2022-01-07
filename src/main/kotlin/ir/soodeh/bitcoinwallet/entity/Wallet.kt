package ir.soodeh.bitcoinwallet.entity

import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="Wallet")
class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long =0;

    @Column(name = "currencyName", nullable=false, unique = true)
    var currencyName:String ="";

    @Column(name = "balance", nullable=false)
    var balance:BigDecimal = BigDecimal("0");

    @Column(name = "lastUpdateDt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    var lastUpdate:LocalDateTime = LocalDateTime.now();

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "wallet")
    private val transactionList: MutableList<Transactions> = ArrayList();



}