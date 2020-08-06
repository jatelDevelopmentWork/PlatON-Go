package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Int64;
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
public class QuickSort extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001490d60027f7f0060017f017f60017f0060037f7f7f017f60000060027f7f017f60047f7f7f7f017f60037f7f7f0060017f017e60047f7f7f7f0060027f7e0060047f7f7e7e006000017f02a9010703656e760c706c61746f6e5f70616e6963000403656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000c03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000503656e7610706c61746f6e5f6765745f7374617465000603656e7610706c61746f6e5f7365745f7374617465000903656e760d706c61746f6e5f72657475726e0000034241040402020b030500070103010401030708080102000001010000040602010a03050a020000050600020308000000020003010001000306020300070104040101090405017001030305030100020608017f0141d08a040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070f5f5f66756e63735f6f6e5f65786974002106696e766f6b6500130908010041010b0209090ab6564108001008104310440b3801017f4194084200370200419c08410036020041742100034020000440200041a0086a4100360200200041046a21000c010b0b4101100a0b0300010b940101027f41a008410136020041a408280200220145044041a40841ac0836020041ac0821010b024041a8082802002202412046044041840210142201450d0120011042220141a40828020036020041a408200136020041a8084100360200410021020b41a808200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41a00841003602000b4c0020012002a72003a7100c21012000280218044020004200370218200041206a41003602000b20002001290200370218200041206a200128020836020020014100360208200142003702000be40102057f027e0340200120024e4504402000280200220520014103746a34020021082002210420012103034020032004480440200520044103746a210602400340200320044e0d01200629030022092008590440200641786a21062004417f6a21040c010b0b200520034103746a2009370300200341016a21030b200520034103746a21070340200320044e0d02200820072903002209550440200741086a2107200341016a21030c010b0b200620093703002004417f6a21040c010b0b200520034103746a2008370300200020012003417f6a100c1a200341016a21010c010b0b20000b3e01017f2000420037020020004100360208200128020420012802006b2202044020002002410375100e20012802002001280204200041046a100f0b20000b2301017f2000200110102202360200200020023602042000200220014103746a3602080b2800200120006b220141014e044020022802002000200110111a2002200228020020016a3602000b0b0900200041037410120bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b0b002000410120001b10140bb40302057f017e23004180016b22002400100710012201101422021002200041c8006a200041086a20022001101522014100101602400240200041c8006a10172205500d0041800810182005510440200041c8006a1019101a0c020b418508101820055104402000420037033820004200370330200041003602282000420037032020004101360244200020013602702000200041c4006a360274200041c8006a200141011016200041c8006a200041206a101b2000200028024441016a360244200041f0006a200041306a101c200041f0006a200041386a101c200041c8006a1019200041c8006a200041f0006a200041206a100d220120002903302000290338100b200128020022030440200120033602040b101a20002802202201450d02200020013602240c020b418a0810182005520d00200041c8006a1019200041f0006a200041e0006a100d2102200041206a101d22012002101e101f200120021020200128020c200141106a28020047044010000b200128020020012802041006200128020c22040440200120043602100b200228020022010440200220013602040b101a0c010b10000b102120004180016a24000b970101047f230041106b220124002001200036020c2000047f41c40a200041086a2202411076220041c40a2802006a220336020041c00a200241c00a28020022026a41076a417871220436020002400240200341107420044d044041c40a200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104101141086a0541000b200141106a24000b0c00200020012002411c10220bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001102b20012003280208200328020c102c36020c20032001102b410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b200020092802002004411410221a200341106a24000f0b20032001102b41002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b2105200120043602142001200536021020032009410020052004102c104720012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000bac0302057f017e20001023024002402000280204450d00200010230240200028020022012c0000220241004e044020020d010c020b200241807f460d00200241ff0171220341b7014d0440200028020441014d04401000200028020021010b20012d00010d010c020b200341bf014b0d012000280204200241ff017141ca7e6a22024d04401000200028020021010b200120026a2d0000450d010b2000280204450d0020012d000041c001490d010b10000b200010242204200028020422014b04401000200028020421010b20002802002105024002400240200104404100210320052c00002200417f4a0d01027f200041ff0171220341bf014d04404100200041ff017141b801490d011a200341c97e6a0c010b4100200041ff017141f801490d001a200341897e6a0b41016a21030c010b4101210320050d00410021000c010b410021002001200449200320046a20014b720d004100210220012003490d01200320056a2102200120036b20042004417f461b22004109490d0110000c010b410021020b0340200004402000417f6a210020023100002006420886842106200241016a21020c010b0b20060b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b810301087f230041306b22072400200042003702182000428debc585c3a7f9dbf7003703102000410036020820004200370200200041206a4100360200200741186a101d220420002903101025200428020c200441106a28020047044010000b200041186a21080240200428020022052004280204220610032202450d002002101221030340200120036a41003a00002002200141016a2201470d000b20052006200320011004417f460440410021010c010b2007200341016a200120036a2003417f736a10152008101b200221010b200428020c22020440200420023602100b024020010d002000411c6a210320002802042201200028020022056b41037522022000280220200028021822066b4103754d04402002200328020020066b41037522024b04402005200520024103746a2202200610261a200220012003100f0c020b200320052001200610263602000c010b2006044020004100360220200042003702180b2008200820021027100e200520012003100f0b200741306a240020000b9603010a7f230041406a22022400200241086a101d2103200241386a4100360200200241306a4200370300200241286a420037030020024200370320200241206a2000290310102820022802202101200241206a410472102920032001101f200320002903101025200328020c200341106a28020047044010000b200328020421052003280200200241206a101d2101200041186a2207101e210841011012220441fe013a0000200128020c200141106a28020047044010000b2001280204220941016a220a20012802084b047f2001200a102a20012802040520090b20012802006a2004410110111a2001200128020441016a3602042001200441016a200820046b6a101f2001200710200240200128020c2001280210460440200128020021040c010b100020012802002104200128020c2001280210460d0010000b2005200420012802041005200128020c22040440200120043602100b200328020c22010440200320013602100b2000280218220104402000411c6a20013602000b200028020022010440200020013602040b200241406b24000b8f0402077f017e230041d0006b22042400024002402000280204450d0020002802002d000041c001490d0020042000102b20042802042102034020020440200441002004280200220520052002102c22066a20054520022006497222051b3602004100200220066b20051b2102200341016a21030c010b0b2001280208200128020022026b4103752003490440200120042003200128020420026b410375200141086a102d2202102e2002102f0b200441286a2000410110302103200441186a2000410010302107200141086a210820032802042100034020072802042000464100200328020822022007280208461b0d02200420002002411c1022103121090240200128020422002001280208490440200020093703002001200041086a3602040c010b200441386a2001200020012802006b410375220041016a102720002008102d21002004280240220220093703002004200241086a36024020012000102e2000102f0b20032003280204220020032802086a410020001b22003602042003280200220204402003200236020820002002102c21062003027f200328020422024504404100210541000c010b410021054100200328020822002006490d001a200020062006417f461b210520020b2200ad2005ad42208684370204200341002003280200220220056b2205200520024b1b36020005200341003602080b0c000b000b10000b200441d0006a24000b4601017f230041206b22022400200241086a2000280200200028020428020010162001200241086a103137030020002802042200200028020041016a360200200241206a24000b2900200041003602082000420037020020004100102a200041146a41003602002000420037020c20000ba60102027f017e230041206b22012400200141186a4100360200200141106a4200370300200141086a420037030020014200370300027f200028020020002802044604402001410136020041010c010b2001410010322000280204210220002802002100037f2000200246047f2001410110322001280200052001200029030022034201862003423f87851028200041086a21000c010b0b0b20014104721029200141206a24000b13002000280208200149044020002001102a0b0bdf0202067f017e0240200128020420012802006b220204402002410375210420002802042105200041106a2802002202200041146a280200220349044020022004ad2005ad422086843702002000200028021041086a3602100c020b027f41002002200028020c22026b410375220641016a2207200320026b2202410275220320032007491b41ffffffff01200241037541ffffffff00491b2203450d001a200341037410120b2102200220064103746a22062004ad2005ad4220868437020020062000280210200028020c22076b22046b2105200441014e044020052007200410111a0b2000200220034103746a3602142000200641086a3602102000200536020c0c010b200041c0011033200041001034200028020020002802046a4100410010111a200010350b20012802042102200128020021010340200120024704402000200129030022084201862008423f87851025200141086a21010c010b0b0b880101037f41a008410136020041a4082802002100034020000440034041a80841a8082802002201417f6a2202360200200141014845044041a0084100360200200020024102746a22004184016a280200200041046a28020011020041a008410136020041a40828020021000c010b0b41a808412036020041a408200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104520024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104520024d0d0020034104710440100020000f0b200042003702000b20000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000102341012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020bbc0202037f027e02402001500440200041800110330c010b20014280015a044020012106034020052006845045044020054238862006420888842106200241016a2102200542088821050c010b0b0240200241384f04402002210403402004044020044108762104200341016a21030c010b0b200341c9004f044010000b2000200341b77f6a41ff017110332000200028020420036a1036200028020420002802006a417f6a21032002210403402004450d02200320043a0000200441087621042003417f6a21030c000b000b200020024180017341ff017110330b2000200028020420026a1036200028020420002802006a417f6a21024200210503402001200584500d02200220013c0000200542388620014208888421012002417f6a2102200542088821050c000b000b20002001a741ff017110330b200010350b2501017f200120006b220141037521032001044020022000200110410b200220034103746a0b3101017f2001200028020820002802006b2200410275220220022001491b41ffffffff01200041037541ffffffff00491b0b880102027f017e4101210220014280015a044041002102034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002103a20026a0520020b41016a21020b200041186a28020022030440200041086a280200200041146a2802002003103721000b2000200028020020026a3602000bea0101047f230041106b22042400200028020422012000280210220341087641fcffff07716a2102027f410020012000280208460d001a2002280200200341ff07714102746a0b2101200441086a20001040200428020c210303400240200120034604402000410036021420002802082102200028020421010340200220016b41027522034103490d022000200141046a22013602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2003417f6a220241014d04402000418004418008200241016b1b3602100b200020011039200441106a24000b2f01017f2000280208200149044020011014200028020020002802041011210220002001360208200020023602000b0b2101017f20011024220220012802044b044010000b2000200120011046200210470b2301017f230041206b22022400200241086a20002001411410221045200241206a24000b4c01017f2000410036020c200041106a2003360200200104402001101021040b200020043602002000200420024103746a22023602082000200420014103746a36020c2000200236020420000b870101037f200120012802042000280204200028020022046b22036b2202360204200341004a044020022004200310111a200128020421020b200028020021032000200236020020012003360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2b01027f20002802082101200028020421020340200120024704402000200141786a22013602080c010b0b0be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001102b20004100200428020c2201200428020822022001102c22032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b1601017e200010172201420188420020014201837d850bbd0c02077f027e230041306b22052400200041046a2107024020014101460440200041086a280200200041146a280200200041186a220228020022041037280200210120022004417f6a360200200710384180104f044020072000410c6a280200417c6a10390b200141384f047f2001103a20016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002103721000c010b0240200710380d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021042001200241046a360200200520043602182007200541186a103b0c010b2000410c6a2802002202200041086a2802006b4102752204200041106a2203280200220620002802046b220141027549044041802010122104200220064704400240200028020c220120002802102206470d0020002802082202200028020422034b04402000200220012002200220036b41027541016a417e6d41027422036a103c220136020c2000200028020820036a3602080c010b200541186a200620036b2201410175410120011b22012001410276200041106a103d2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002103e200028020c21010b200120043602002000200028020c41046a36020c0c020b02402000280208220120002802042206470d00200028020c2202200028021022034904402000200120022002200320026b41027541016a41026d41027422036a103f22013602082000200028020c20036a36020c0c010b200541186a200320066b2201410175410120011b2201200141036a410276200041106a103d2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002103e200028020821010b2001417c6a2004360200200020002802082201417c6a22023602082002280200210220002001360208200520023602182007200541186a103b0c010b20052001410175410120011b20042003103d210241802010122106024020022802082201200228020c2208470d0020022802042204200228020022034b04402002200420012004200420036b41027541016a417e6d41027422036a103c22013602082002200228020420036a3602040c010b200541186a200820036b2201410175410120011b22012001410276200241106a280200103d21042002280208210320022802042101034020012003470440200428020820012802003602002004200428020841046a360208200141046a21010c010b0b2002290200210920022004290200370200200420093702002002290208210920022004290208370208200420093702082004103e200228020821010b200120063602002002200228020841046a360208200028020c2104034020002802082004460440200028020421012000200228020036020420022001360200200228020421012002200436020420002001360208200029020c21092000200229020837020c200220093702082002103e052004417c6a210402402002280204220120022802002208470d0020022802082203200228020c22064904402002200120032003200620036b41027541016a41026d41027422066a103f22013602042002200228020820066a3602080c010b200541186a200620086b2201410175410120011b2201200141036a4102762002280210103d2002280208210620022802042101034020012006470440200528022020012802003602002005200528022041046a360220200141046a21010c010b0b20022902002109200220052903183702002002290208210a20022005290320370208200520093703182005200a370320103e200228020421010b2001417c6a200428020036020020022002280204417c6a3602040c010b0b0b200541186a20071040200528021c4100360200200041186a2100410121010b2000200028020020016a360200200541306a24000b2500200041011034200028020020002802046a20013a00002000200028020441016a3602040b1b00200028020420016a220120002802084b044020002001102a0b0bf50101057f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220436020020040d002000200236021020004101200028020422032001417c6a28020022026b2201103a220441016a20014138491b220520036a1036200220002802006a220320056a200320011041200141374d0440200028020020026a200141406a3a00000c020b200441f7016a220341ff014d0440200028020020026a20033a00002000280200200220046a6a210203402001450d03200220013a0000200141087621012002417f6a21020c000b000510000c020b000b0b0b0f0020002001102a200020013602040b25002000200120026a417f6a220141087641fcffff07716a280200200141ff07714102746a0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010ba10202057f017e230041206b22052400024020002802082202200028020c2206470d0020002802042203200028020022044b04402000200320022003200320046b41027541016a417e6d41027422046a103c22023602082000200028020420046a3602040c010b200541086a200620046b2202410175410120021b220220024102762000410c6a103d2103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b2000290200210720002003290200370200200320073702002000290208210720002003290208370208200320073702082003103e200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110410b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274101221040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110410b20020b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210111a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041d08a0436020c41bc0a200028020c41076a417871220036020041c00a200036020041c40a3f003602000b3801017f41b00a420037020041b80a410036020041742100034020000440200041bc0a6a4100360200200041046a21000c010b0b4102100a0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001046200010246a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0b1a01004180080b13696e697400736f7274006765745f6172726179";

    public static String BINARY = BINARY_0;

    public static final String FUNC_SORT = "sort";

    public static final String FUNC_GET_ARRAY = "get_array";

    protected QuickSort(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected QuickSort(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<QuickSort> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(QuickSort.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<QuickSort> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(QuickSort.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<QuickSort> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(QuickSort.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<QuickSort> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(QuickSort.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> sort(Int64[] arr, Int64 start, Int64 last) {
        final WasmFunction function = new WasmFunction(FUNC_SORT, Arrays.asList(arr,start,last), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> sort(Int64[] arr, Int64 start, Int64 last, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SORT, Arrays.asList(arr,start,last), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Int64[]> get_array() {
        final WasmFunction function = new WasmFunction(FUNC_GET_ARRAY, Arrays.asList(), Int64[].class);
        return executeRemoteCall(function, Int64[].class);
    }

    public static QuickSort load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new QuickSort(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static QuickSort load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new QuickSort(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
