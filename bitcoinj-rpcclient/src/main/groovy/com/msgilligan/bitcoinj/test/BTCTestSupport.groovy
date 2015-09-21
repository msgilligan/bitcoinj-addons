package com.msgilligan.bitcoinj.test

import com.msgilligan.bitcoinj.rpc.BitcoinClientDelegate
import com.msgilligan.bitcoinj.rpc.Loggable
import com.msgilligan.bitcoinj.rpc.conversion.BitcoinMath
import org.bitcoinj.core.Coin

/**
 * Test support functions intended to be mixed-in to Spock test specs
 */
trait BTCTestSupport implements BitcoinClientDelegate, FundingSourceDelegate, Loggable {
    // TODO: set, or get and verify default values of the client
    final Coin stdTxFee = 0.00010000.btc
    final Coin stdRelayTxFee = 0.00001000.btc
    final Integer defaultMaxConf = 9999999

    Boolean consolidateCoins() {
        fundingSource.fundingSourceMaintenance();
    }

    Coin btcToCoin(final BigDecimal btc) {
        return BitcoinMath.btcToCoin(btc)
    }
}