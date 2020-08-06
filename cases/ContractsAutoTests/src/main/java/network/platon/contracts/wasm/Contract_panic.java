package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.0.6.
 */
public class Contract_panic extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001420c60027f7f0060017f017f60017f0060000060027f7f017f60037f7f7f0060047f7f7f7f0060037f7f7f017f60047f7f7f7f017f60017f017e60027f7e006000017f02a9010703656e760c706c61746f6e5f70616e6963000303656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000b03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000403656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000603656e760d706c61746f6e5f72657475726e00000333320301020202000004000301070509090102000203080200040001010101000000010200000007020a010503050301010604000405017001050505030100020608017f0141908b040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070f5f5f66756e63735f6f6e5f65786974001a06696e766f6b650010090a010041010b04090d0f090aad3d32100041d00810081a4101100a103110330b190020004200370200200041086a41003602002000100b20000b0300010b940101027f41dc08410136020041e008280200220145044041e00841e80836020041e80821010b024041e4082802002202412046044041840210112201450d012001102f220141e00828020036020041e008200136020041e4084100360200410021020b41e408200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41dc0841003602000b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b880201047f20002001470440200128020420012d00002202410176200241017122031b2102200141016a21042001280208410a2101200420031b210420002d0000410171220304402000280200417e71417f6a21010b200220014d0440027f2003044020002802080c010b200041016a0b21012002044020012004200210300b200120026a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b416f2103200141e6ffffff074d0440410b20014101742201200220022001491b220141106a4170712001410b491b21030b200310212201200420021032200020023602042000200341017236020020002001360208200120026a41003a00000b0b0c002000200141186a100e1a0ba10101037f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b20012802082103024020012802042201410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712204102121022000200136020420002004410172360200200020023602080b2002200320011032200120026a41003a000020000b0c002000200141406b100e1a0bcc0202037f017e230041a0016b22002400100710012201101122021002200041406b200020022001101222014100101302400240200041406b10142203500d0041800810152003510440200041406b101610170c020b41850810152003510440200041186a1008210220004200370328200041406b200141011013200041406b20021018200041406b2001410210132000200041406b1014370328200041406b10162101200041306a2002100e210220002903281a200141186a20004190016a2002100e2202100c200141406b2002100c200110170c020b4194081015200351044020004190016a10082102200041406b200141011013200041406b20021018200041406b1016220141186a200041186a2002100e100c200110170c020b41a70810152003510440410210190c020b41ba0810152003520d00410310190c010b10000b101a200041a0016a24000b970101047f230041106b220124002001200036020c2000047f41800b200041086a2202411076220041800b2802006a220336020041fc0a200241fc0a28020022026a41076a417871220436020002400240200341107420044d044041800b200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104102c41086a0541000b200141106a24000b0c00200020012002411c101b0bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001103820012003280208200328020c103736020c200320011038410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b2000200928020020044114101b1a200341106a24000f0b20032001103841002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200320094100200520041037103620012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000b870202047f017e230041106b220324002000101c024002402000280204450d002000101c0240200028020022012c0000220241004e044020020d010c020b200241807f460d00200241ff0171220441b7014d0440200028020441014d04401000200028020021010b20012d00010d010c020b200441bf014b0d012000280204200241ff017141ca7e6a22024d04401000200028020021010b200120026a2d0000450d010b2000280204450d0020012d000041c001490d010b10000b200341086a2000101d200328020c220041094f044010000b200328020821010340200004402000417f6a210020013100002005420886842105200141016a21010c010b0b200341106a240020050b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b6b01027f200010082102200042afb59bdd9e8485b9f800370310200041106a200041186a10082201101e45044020012002100c0b200041286a10082102200041386a220142ecae96e4b694b9d9d0003703002001200041406b10082201101e45044020012002100c0b20000b1a00200041386a200041406b101f200041106a200041186a101f0bf40201057f230041206b22022400024002402000280204044020002802002d000041c001490d010b200241086a10081a0c010b200241186a2000101d2000102021030240024002400240200228021822000440200228021c220420034f0d010b41002100200241106a410036020020024200370308410021040c010b200241106a4100360200200242003703082000200420032003417f461b22046a21052004410a4b0d010b200220044101743a0008200241086a41017221030c010b200441106a4170712206102121032002200436020c20022006410172360208200220033602100b03402000200546450440200320002d00003a0000200341016a2103200041016a21000c010b0b200341003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141003602000b20012002290308370200200141086a200241106a280200360200200241086a100b200241206a24000b850101037f23004190016b22012400200141086a1016200141d8006a200141086a2000110000200141f8006a10222200200141d8006a102310242000200141e8006a200141d8006a100e1025200028020c200041106a28020047044010000b200028020020002802041006200028020c22030440200020033602100b101720014190016a24000b880101037f41dc08410136020041e0082802002100034020000440034041e40841e4082802002201417f6a2202360200200141014845044041dc084100360200200020024102746a22004184016a280200200041046a28020011020041dc08410136020041e00828020021000c010b0b41e408412036020041e008200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000103420024f0d002003410471044010000c010b200042003702000b02402003411071450d002000103420024d0d0020034104710440100020000f0b200042003702000b20000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bd40101047f200110202204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000bb50101067f230041306b22052400200541186a102222022000290300102e200228020c200241106a28020047044010000b02400240200228020022062002280204220710032204450d00200410212103410021000340200020036a41003a00002004200041016a2200470d000b20062007200320001004417f460d002005200341016a200020036a2003417f736a1012200110180c010b410021040b200228020c22000440200220003602100b200541306a240020040bbf0302087f027e230041d0006b22032400200341186a10222105200341c8006a4100360200200341406b4200370300200341386a420037030020034200370330410121042000290300220b4280015a04400340200a200b8450450440200a423886200b42088884210b200241016a2102200a420888210a0c010b0b200241384f047f2002102720026a0520020b41016a21040b20032004360230200341306a410472102820052004102420052000290300102e200528020c200541106a28020047044010000b200528020421062005280200200341306a1022210220011023210841011021220441fe013a0000200228020c200241106a28020047044010000b2002280204220041016a220920022802084b047f20022009102620022802040520000b20022802006a20044101102c1a2002200228020441016a3602042002200441016a20086a20046b10242002200341086a2001100e10250240200228020c2002280210460440200228020021040c010b100020022802002104200228020c2002280210460d0010000b2006200420022802041005200228020c22000440200220003602100b200528020c22000440200520003602100b200341d0006a24000bff0201037f200028020445044041000f0b2000101c41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b0b002000410120001b10110b29002000410036020820004200370200200041001026200041146a41003602002000420037020c20000bb80101047f230041306b22012400200141286a4100360200200141206a4200370300200141186a4200370300200142003703104101210202400240024020012000100e220328020420032d00002200410176200041017122041b220041014d0440200041016b0d032003280208200341016a20041b2c0000417f4c0d010c030b200041374b0d010b200041016a21020c010b2000102720006a41016a21020b20012002360210200141106a4104721028200141306a240020020b1300200028020820014904402000200110260b0b810201047f410121022001280208200141016a20012d0000220341017122051b210402400240024002402001280204200341017620051b2203410146044020042c000022014100480d012000200141ff017110290c040b200341374b0d01200321020b200020024180017341ff017110290c010b20031027220141b7016a22024180024e044010000b2000200241ff017110292000200028020420016a102a200028020420002802006a417f6a210220032101037f2001047f200220013a0000200141087621012002417f6a21020c010520030b0b21020b20002002102b200028020020002802046a20042002102c1a2000200028020420026a3602040b2000102d0b2f01017f200028020820014904402001101120002802002000280204102c210220002001360208200020023602000b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b860201067f200028020422032000280210220241087641fcffff07716a2101027f200320002802082204460440200041146a210541000c010b2003200028021420026a220541087641fcffff07716a280200200541ff07714102746a2106200041146a21052001280200200241ff07714102746a0b21020340024020022006460440200541003602000340200420036b41027522014103490d022000200341046a22033602040c000b000b200241046a220220012802006b418020470d0120012802042102200141046a21010c010b0b2001417f6a220141014d04402000418004418008200141016b1b3602100b03402003200447044020002004417c6a22043602080c010b0b0b250020004101102b200028020020002802046a20013a00002000200028020441016a3602040b0f00200020011026200020013602040b1b00200028020420016a220120002802084b04402000200110260b0bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bf80101057f0340024020002802102201200028020c460d00200141786a28020041014904401000200028021021010b200141786a2202200228020041016b220436020020040d002000200236021020004101200028020422032001417c6a28020022026b22011027220441016a20014138491b220520036a102a200220002802006a220320056a2003200110300240200141374d0440200028020020026a200141406a3a00000c010b200441f7016a220341ff014d0440200028020020026a20033a00002000280200200220046a6a210203402001450d02200220013a0000200141087621012002417f6a21020c000b000b10000b0c010b0b0bbc0202037f027e02402001500440200041800110290c010b20014280015a044020012106034020052006845045044020054238862006420888842106200241016a2102200542088821050c010b0b0240200241384f04402002210403402004044020044108762104200341016a21030c010b0b200341c9004f044010000b2000200341b77f6a41ff017110292000200028020420036a102a200028020420002802006a417f6a21032002210403402004450d02200320043a0000200441087621042003417f6a21030c000b000b200020024180017341ff017110290b2000200028020420026a102a200028020420002802006a417f6a21024200210503402001200584500d02200220013c0000200542388620014208888421012002417f6a2102200542088821050c000b000b20002001a741ff017110290b2000102d0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002102c1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b3501017f230041106b220041908b0436020c41f80a200028020c41076a417871220036020041fc0a200036020041800b3f003602000b100020020440200020012002102c1a0b0b3801017f41ec0a420037020041f40a410036020041742100034020000440200041f80a6a4100360200200041046a21000c010b0b4104100a0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001035200010206a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b2301017f230041206b22022400200241086a200020014114101b1034200241206a24000b2101017f20011020220220012802044b044010000b2000200120011035200210360b0b5401004180080b4d696e69740070616e69635f636f6e7472616374007365745f737472696e675f73746f72616765006765745f737472696e675f73746f72616765006765745f737472696e675f73746f7261676531";

    public static String BINARY = BINARY_0;

    public static final String FUNC_PANIC_CONTRACT = "panic_contract";

    public static final String FUNC_SET_STRING_STORAGE = "set_string_storage";

    public static final String FUNC_GET_STRING_STORAGE1 = "get_string_storage1";

    public static final String FUNC_GET_STRING_STORAGE = "get_string_storage";

    protected Contract_panic(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected Contract_panic(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<Contract_panic> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_panic.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> panic_contract(String name, Uint64 value) {
        final WasmFunction function = new WasmFunction(FUNC_PANIC_CONTRACT, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> panic_contract(String name, Uint64 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_PANIC_CONTRACT, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> set_string_storage(String name) {
        final WasmFunction function = new WasmFunction(FUNC_SET_STRING_STORAGE, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> set_string_storage(String name, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SET_STRING_STORAGE, Arrays.asList(name), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<String> get_string_storage1() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING_STORAGE1, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<String> get_string_storage() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING_STORAGE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static Contract_panic load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new Contract_panic(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static Contract_panic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new Contract_panic(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
