package network.platon.contracts.wasm;

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
public class Test_auth_set extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001420c60027f7f0060017f0060017f017f60000060037f7f7f0060027f7f017f60047f7f7f7f0060037f7f7f017f60047f7f7f7f017f60027f7e006000017f60017f017e02bd010803656e760c706c61746f6e5f70616e6963000303656e760d706c61746f6e5f63616c6c6572000103656e760d706c61746f6e5f6f726967696e000103656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000103656e7617706c61746f6e5f6765745f73746174655f6c656e677468000503656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f73746174650006033534030201010100020200020101000004000204040701000209070100010000000001000205080203040b00030204030302020605000405017001050505030100020608017f0141f08b040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300080f5f5f66756e63735f6f6e5f65786974003206696e766f6b65002e090a010041010b040a0d140a0adc5534100041b00910091a4101100b103510360b190020004200370200200041086a41003602002000100c20000b0300010b940101027f41bc09410136020041c009280200220145044041c00941c80936020041c80921010b024041c40928020022024120460440418402102a2201450d0120011033220141c00928020036020041c009200136020041c4094100360200410021020b41c409200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41bc0941003602000b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0bc70100230041d0006b22002400200041386a100e1a02402001100f04402000100e1a20001001200041c8006a200041106a280200360200200041406b200041086a290300370300200020002903003703380c010b20002001101020002d00140d00200041c8006a200041106a280200360200200041406b200041086a290300370300200020002903003703380b20001011220141306a200041c8006a280200360000200141286a200041406b2903003700002001200029033837002020011012200041d0006a24000b2601017f230041106b22012400200141003a000f20002001410f6a1015200141106a240020000b2101017f027f20002d00002201410171044020002802040c010b20014101760b450bb914010c7f230041e0006b22022400200241106a4100360200200242003703080240034020054180086a2203410371044020054103460d02200541016a21050c010b0b200541fc076a21030340200341046a22032802002205417f73200541fffdfb776a7141808182847871450d000b0340200541ff0171450d01200341016a2d00002105200341016a21030c000b000b200241086a41800820034180086b10162001280208200141016a220b20012d0000220341017122041b21092001280204200341017620041b21084100210341012104024003402004410171410020032008491b0440200320096a2d00002205415f6a41ff017141de004921042006200541bf7f6a41ff0171411a4972210620072005419f7f6a41ff0171411a49722107200341016a21030c01050240200420062007714101737121042008450d002008210303402003450d01200320096a2003417f6a22052103417f6a2d00004131470d000b0c030b0b0b417f21050b02400240200441017145200541076a20084b72200541016a410249200841da004b72720d00410021032002410036023020024200370328200241286a20082005417f7322046a10174101210602400240024003402003200128020420012d00002207410176200741017122071b20046a4f044002402006410171450d05200241186a1009220941016a2103410021040340200420054604402009280204220720022d001822044101762201200441017122061b2204200228020c20022d00082208410176200841017122081b470d052002280210200241086a41017220081b210520060d02200121042003210603402004450440200121070c080b20062d000020052d0000470d06200541016a2105200641016a21062004417f6a21040c000b00052001280208200b20012d00004101711b20046a2c000022084120722008200841bf7f6a411a491b210c024002400240027f20022d0018220a4101712208450440410a2107200a4101760c010b2009280200220a417e71417f6a210720092802040b2206200746044020092802082003200a4101711b210d416f210a200741e6ffffff074d0440410b20074101742208200741016a220a200a2008491b220841106a4170712008410b491b210a0b200a10182208200d200710192009200a410172360200200920083602080c010b2008450d01200928020821080b2009200641016a3602040c010b2002200641017441026a3a0018200321080b200620086a220641003a00012006200c3a0000200441016a21040c010b000b000b05200228022820036a2001280208200b20071b20056a20036a41016a2d00004190086a2d000022073a00002006200741ff0147712106200341016a21030c010b0b2004450d012009280208210603402004450d0220062d000020052d0000470d01200541016a2105200641016a21062004417f6a21040c000b000b200241c8006a100e1a200041003a0014200041106a200241d8006a280200360000200041086a200241d0006a2903003700002000200229034837000020022802282200450d032002200036022c0c030b410021052002410036024020024200370338200241386a2007410174410172101703402005200928020420022d00182201410176200141017122011b22044f450440200228023820056a2009280208200320011b20056a2d000022014105763a00002002280238200928020420022d0018220441017620044101711b6a20056a41016a2001411f713a0000200541016a21050c010b0b200228023820046a41003a0000200228023c21040240200228022c2201200228022822036b22064101480d0020062002280240220520046b4c0440034020012003460d02200420032d00003a00002002200228023c41016a220436023c200341016a21030c000b000b200241d8006a200241406b36020041002107200241003602542004200228023822086b2109200420066a20086b2206200520086b2208410174220520052006491b41ffffffff07200841ffffffff03491b220804402008101821070b200220073602482002200720096a22063602502002200720086a3602542002200636024c200241c8006a410472210703402001200346450440200620032d00003a00002002200228025041016a2206360250200341016a21030c010b0b200228023820042007101a0240200228023c220520046b220141004c0440200228025021040c010b2002200228025020042001101b20016a2204360250200228023c21050b200228023821012002200228024c3602382002200136024c2002200436023c2002200536025020022802402103200220022802543602402002200336025420022001360248200241c8006a101c200228023c21040b2002420037023c2002280238210520024100360238200420056b21044101210303402004044020052d000041002003411d764101716b41b3c5d1d0027141002003411c764101716b41dde788ea037141002003411b764101716b41fab384f5017141002003411a764101716b41ed9cc2b20271410020034119764101716b41b2afa9db0371200341057441e0ffffff037173737373737321032004417f6a2104200541016a21050c010b0b20034101470d0041002103200241003602402002420037033841002104410021060240200228022c417a6a2201200228022822056b2207450d002007101822062104034020012005460d01200420052d00003a0000200441016a2104200541016a21050c000b000b200420066b210a200241406b210b4100210841002101024003402001200a46044002404100200341044c41ff01410820036b762008711b0d00200228023821030c030b05200120066a2d0000200841057441e01f71722108200341056a21030340200341084e04402008200341786a2203762104200228023c220720022802402209490440200720043a00002002200228023c41016a36023c0c02052002200b36025841002105200241003602542007200228023822076b220c41016a220d200920076b220741017422092009200d491b41ffffffff07200741ffffffff03491b220704402007101821050b200220053602482005200c6a220920043a00002002200520076a3602542002200936024c2002200941016a360250200241386a200241c8006a101d200241c8006a101c0c020b000b0b200141016a21010c010b0b200228023c200228023822036b4114470d0041002103200241003a005f200241c8006a200241df006a1015200228023c200228023822016b210403402003200446200341134b72450440200241c8006a20036a200120036a2d00003a0000200341016a21030c010b0b20002002290348370000200041013a0014200041106a200241d8006a280200360000200041086a200241d0006a290300370000200104402002200136023c0b20022802282200450d032002200036022c0c030b2003450d002002200336023c0b20022802282201450d002002200136022c0b200241c8006a100e1a200041003a0014200041106a200241d8006a280200360000200041086a200241d0006a290300370000200020022903483700000b200241e0006a24000bc10302077f027e23004180016b220124002000100e1a200042befadbd3c388a6d88a7f370318200041206a100e2103200141306a101e22042000290318101f200428020c200441106a28020047044010000b02402004280200220520042802042207100522064504400c010b2001410036022820014200370320200141206a200610172005200720012802202205200128022420056b1006417f470440200141086a2001280220220241016a20012802242002417f736a102022021021200141f8006a200210220240200228020445200128027c220541144b7245044020022802002d000041c001490d010b10000b200141e0006a100e2005411420054114491b22026b41146a20012802782002101b1a200141d8006a200141f0006a2802002202360200200141d0006a200141e8006a2903002208370300200120012903602209370348200341106a2002360000200341086a200837000020032009370000200621020b20012802202206450d00200120063602240b200428020c22060440200420063602100b200245044020032000290300370300200341106a200041106a280200360200200341086a200041086a2903003703000b20014180016a240020000bf90602097f027e230041b0016b22012400200141186a101e2105200141e0006a4100360200200141d8006a4200370300200141d0006a420037030020014200370348410121042000290318220b4280015a04400340200a200b8450450440200a423886200b42088884210b200341016a2103200a420888210a0c010b0b024020034138490d002003210403402004450d01200341016a2103200441087621040c000b000b200341016a21040b20012004360248200141c8006a410472102320052004102420052000290318101f200528020c200541106a28020047044010000b2005280204210720052802002001101e210241002103200141e0006a4100360200200141d8006a4200370300200141d0006a4200370300200141406b200041306a2800002204360200200141386a200041286a290000220a3703002001420037034820012000290020220b370330200141f0006a200a370300200141f8006a200436020020014188016a200a37030020014190016a20043602002001200b3703682001200b37038001200141a8016a2004360200200141a0016a200a3703002001200b37039801410121060240034020034114460d0120014198016a20036a200341016a21032d0000450d000b411521060b20012006360248200141c8006a410472102341011018220341fe013a0000200228020c200241106a28020047044010000b2002280204220441016a220920022802084b047f20022009102520022802040520040b20022802006a20034101101b1a2002200228020441016a3602042002200341016a200620036b6a1024200141f8006a200041206a220341106a2800002200360200200141f0006a200341086a290000220a37030020012003290000220b37036820014188016a200a37030020014190016a2000360200200141a0016a200a370300200141a8016a20003602002001200b370380012001200b37039801200141d8006a2000360200200141d0006a200a3703002001200b37034820024194011026200241141027200228020020022802046a200141c8006a4114101b1a2002200228020441146a360204200210280240200228020c2002280210460440200228020021030c010b100020022802002103200228020c2002280210460d0010000b2007200320022802041007200228020c22000440200220003602100b200528020c22000440200520003602100b200141b0016a24000b9c0101017f230041d0006b22012400200141386a100e1a02402000100f04402001100e1a20011002200141c8006a200141106a280200360200200141406b200141086a290300370300200120012903003703380c010b20012000101020012d00140d00200141c8006a200141106a280200360200200141406b200141086a290300370300200120012903003703380b200110111012200141d0006a24000b0600200110130b2601017f03402002411446450440200020026a20012d00003a0000200241016a21020c010b0b0b5a01027f02402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204101821032000200236020420002004410172360200200020033602080b2003200120021019200220036a41003a00000bfa0101057f230041206b22022400024020002802042203200028020022046b22052001490440200028020820036b200120056b22044f04400340200341003a00002000200028020441016a22033602042004417f6a22040d000c030b000b20002001102b2106200241186a200041086a3602002002410036021441002101200604402006101821010b200220013602082002200120056a22033602102002200120066a3602142002200336020c0340200341003a00002002200228021041016a22033602102004417f6a22040d000b2000200241086a101d200241086a101c0c010b200520014d0d002000200120046a3602040b200241206a24000b0b002000410120001b102a0b100020020440200020012002101b1a0b0b270020022002280200200120006b22016b2202360200200141014e0440200220002001101b1a0b0bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b2b01027f200028020821012000280204210203402001200247044020002001417f6a22013602080c010b0b0b6701017f20002802002000280204200141046a101a200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b29002000410036020820004200370200200041001025200041146a41003602002000420037020c20000bbc0202037f027e02402001500440200041800110260c010b20014280015a044020012106034020052006845045044020054238862006420888842106200241016a2102200542088821050c010b0b0240200241384f04402002210403402004044020044108762104200341016a21030c010b0b200341c9004f044010000b2000200341b77f6a41ff017110262000200028020420036a1029200028020420002802006a417f6a21032002210403402004450d02200320043a0000200441087621042003417f6a21030c000b000b200020024180017341ff017110260b2000200028020420026a1029200028020420002802006a417f6a21024200210503402001200584500d02200220013c0000200542388620014208888421012002417f6a2102200542088821050c000b000b20002001a741ff017110260b200010280b0c00200020012002411c102c0b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bd40101047f2001102d2204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b860201067f200028020422032000280210220241087641fcffff07716a2101027f200320002802082204460440200041146a210541000c010b2003200028021420026a220541087641fcffff07716a280200200541ff07714102746a2106200041146a21052001280200200241ff07714102746a0b21020340024020022006460440200541003602000340200420036b41027522014103490d022000200341046a22033602040c000b000b200241046a220220012802006b418020470d0120012802042102200141046a21010c010b0b2001417f6a220141014d04402000418004418008200141016b1b3602100b03402003200447044020002004417c6a22043602080c010b0b0b1300200028020820014904402000200110250b0b2f01017f200028020820014904402001102a20002802002000280204101b210220002001360208200020023602000b0b2500200041011027200028020020002802046a20013a00002000200028020441016a3602040b1b00200028020420016a220120002802084b04402000200110250b0b960201057f0340024020002802102201200028020c460d00200141786a28020041014904401000200028021021010b200141786a2202200228020041016b220436020020040d002000200236021020004101200028020422052001417c6a28020022026b220121044100210303402004044020044108762104200341016a21030c010b0b2003220441016a20014138491b220320056a10292003200220002802006a22036a2003200110340240200141374d0440200028020020026a200141406a3a00000c010b200441f7016a220341ff014d0440200028020020026a20033a00002000280200200220046a6a210203402001450d02200220013a0000200141087621012002417f6a21020c000b000b10000b0c010b0b0b0f00200020011025200020013602040b970101047f230041106b220124002001200036020c2000047f41e00b200041086a2202411076220041e00b2802006a220336020041dc0b200241dc0b28020022026a41076a417871220436020002400240200341107420044d044041e00b200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104101b41086a0541000b200141106a24000b2e01017f2001200028020820002802006b2200410174220220022001491b41ffffffff07200041ffffffff03491b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000103720024f0d002003410471044010000c010b200042003702000b02402003411071450d002000103720024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000102141012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b870302057f017e230041406a22002400100810032201102a22021004200041086a200041206a20022001102022034100102f200041086a102102400240200028020c450d00200041086a10210240200028020822012c0000220241004e044020020d010c020b200241807f460d00200241ff0171220441b7014d0440200028020c41014d04401000200028020821010b20012d00010d010c020b200441bf014b0d01200028020c200241ff017141ca7e6a22024d04401000200028020821010b200120026a2d0000450d010b200028020c450d0020012d000041c001490d010b10000b200041386a200041086a1022200028023c220241094f044010000b200028023821010340200204402002417f6a210220013100002005420886842105200141016a21010c010b0b024002402005500d00419009103020055104402003410210310c020b41950910302005510440230041106b22012400200110091013200141106a24000c020b41a00910302005520d002003410310310c010b10000b1032200041406b24000bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001103b20012003280208200328020c103a36020c20032001103b410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b2000200928020020044114102c1a200341106a24000f0b20032001103b41002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b2105200120043602142001200536021020032009410020052004103a103920012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010be30301057f230041406a22022400200210091a200241106a20004101102f024002402002280214044020022802102d000041c001490d010b200241286a10091a0c010b200241386a200241106a1022200241106a102d21030240024002400240200228023822000440200228023c220420034f0d010b41002100200241306a410036020020024200370328410021040c010b200241306a4100360200200242003703282000200420032003417f461b22046a21052004410a4b0d010b200220044101743a0028200241286a41017221030c010b200441106a4170712206101821032002200436022c20022006410172360228200220033602300b034020002005470440200320002d00003a0000200341016a2103200041016a21000c010b0b200341003a00000b024020022d0000410171450440200241003b01000c010b200228020841003a00002002410036020420022d0000410171450d00200241003602000b200241086a2200200241306a28020036020020022002290328370300200241286a100c200241186a2203410036020020024200370310024020022d000041017145044020032000280200360200200220022903003703100c010b200241106a2002280208200228020410160b200241286a200241106a2001110000200241406b24000b880101037f41bc09410136020041c0092802002100034020000440034041c40941c4092802002201417f6a2202360200200141014845044041bc094100360200200020024102746a22004184016a280200200041046a28020011010041bc09410136020041c00928020021000c010b0b41c409412036020041c009200028020022003602000c010b0b0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002101b1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b3501017f230041106b220041f08b0436020c41d80b200028020c41076a417871220036020041dc0b200036020041e00b3f003602000b3801017f41cc0b420037020041d40b410036020041742100034020000440200041d80b6a4100360200200041046a21000c010b0b4104100b0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010382000102d6a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b2301017f230041206b22022400200241086a200020014114102c1037200241206a24000b2101017f2001102d220220012802044b044010000b2000200120011038200210390b0bad0102004180080b036c6178004190080b9c01ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff0fff0a1115141a1e0705ffffffffffffff1dff180d19090817ff12161f1b13ff010003100b1c0c0e060402ffffffffffff1dff180d19090817ff12161f1b13ff010003100b1c0c0e060402ffffffffff696e697400746573745f6f776e657200746573745f6f776e65725f70";

    public static String BINARY = BINARY_0;

    public static final String FUNC_TEST_OWNER_P = "test_owner_p";

    public static final String FUNC_TEST_OWNER = "test_owner";

    protected Test_auth_set(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected Test_auth_set(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public RemoteCall<TransactionReceipt> test_owner_p(String addr) {
        final WasmFunction function = new WasmFunction(FUNC_TEST_OWNER_P, Arrays.asList(addr), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> test_owner_p(String addr, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_TEST_OWNER_P, Arrays.asList(addr), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> test_owner() {
        final WasmFunction function = new WasmFunction(FUNC_TEST_OWNER, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> test_owner(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_TEST_OWNER, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static RemoteCall<Test_auth_set> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId, String addr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(addr));
        return deployRemoteCall(Test_auth_set.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Test_auth_set> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId, String addr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(addr));
        return deployRemoteCall(Test_auth_set.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Test_auth_set> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId, String addr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(addr));
        return deployRemoteCall(Test_auth_set.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<Test_auth_set> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId, String addr) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(addr));
        return deployRemoteCall(Test_auth_set.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static Test_auth_set load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new Test_auth_set(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static Test_auth_set load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new Test_auth_set(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
