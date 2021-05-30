package xyz.metahash.apps.bscscan.tests

import org.hamcrest.MatcherAssert
import org.junit.Test
import xyz.metahash.apps.bscscan.BuildConfig.API_KEY
import xyz.metahash.apps.bscscan.sleep
import xyz.metahash.chains.bsc.bscscan.di.BscScanApiImpl

class TokenServiceTest: BscScanApiImpl() {
    @Test
    fun tokenServiceTest_getBep20TotalSupply() {
        val testObserver = tokenService.getBep20TotalSupply(
            contractAddress = "0xe9e7cea3dedca5984780bafc599bd69add087d56"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                MatcherAssert.assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun tokenServiceTest_getBep20CirculatingSupply() {
        val testObserver = tokenService.getBep20CirculatingSupply(
            contractAddress = "0xe9e7cea3dedca5984780bafc599bd69add087d56"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                MatcherAssert.assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
    @Test
    fun tokenServiceTest_getBep20Balance() {
        val testObserver = tokenService.getBep20Balance(
            contractAddress = "0x0e09fabb73bd3ade0a17ecc321fd13a19e81ce82"
            , address = "0xbe0eb53f46cd790cd13851d5eff43d12404d33e8"
            , apiKey = API_KEY
        ).test()
        testObserver.awaitTerminalEvent()
        testObserver
            .assertNoErrors()
            .assertValue(xyz.metahash.apps.bscscan.check {
                MatcherAssert.assertThat("Status ${it.status}: ${it.message}", it.status == "1")
            })
        sleep()
    }
}