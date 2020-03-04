package network.platon.contracts.wasm;

import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
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
 * <p>Generated with platon-web3j version 0.9.1.1-SNAPSHOT.
 */
public class CoinbaseFunction extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001510d60000060017f006000017f60027f7f0060037f7f7f017f60017f017f60027f7f017f60037f7f7f0060087f7f7f7f7f7f7f7f0060047f7f7f7f017f60057f7f7f7f7f017f60047f7f7f7f0060017f017e02730503656e760c706c61746f6e5f70616e6963000003656e760f706c61746f6e5f636f696e62617365000103656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000203656e7610706c61746f6e5f6765745f696e707574000103656e760d706c61746f6e5f72657475726e0003033f3e000004040505040601000501050401010607040508040409040a07010500040104050505050b030705010504070303050303030707040100010301000c000405017001030305030100020615037f0141f08a040b7f0041f08a040b7f0041ea0a0b075406066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300050b5f5f686561705f6261736503010a5f5f646174615f656e6403020f5f5f66756e63735f6f6e5f65786974002206696e766f6b6500400908010041010b02243d0a89463e0800100e103c10420b02000bc60a010b7f2002410f6a210341002104410020026b21052002410e6a2106410120026b21072002410d6a2108410220026b210902400340200020046a210b200120046a210a20022004460d01200a410371450d01200b200a2d00003a00002003417f6a2103200541016a21052006417f6a2106200741016a21072008417f6a2108200941016a2109200441016a21040c000b0b200220046b210c02400240024002400240200b410371220d450d00200c4120490d03200d4101460d01200d4102460d02200d4103470d03200b200120046a28020022063a0000200041016a210c200220046b417f6a21092004210b0240034020094113490d01200c200b6a220a2001200b6a220741046a2802002208411874200641087672360200200a41046a200741086a2802002206411874200841087672360200200a41086a2007410c6a2802002208411874200641087672360200200a410c6a200741106a2802002206411874200841087672360200200b41106a210b200941706a21090c000b0b2002417f6a2005416d2005416d4b1b20036a4170716b20046b210c2001200b6a41016a210a2000200b6a41016a210b0c030b200c210a02400340200a4110490d01200020046a220b200120046a2207290200370200200b41086a200741086a290200370200200441106a2104200a41706a210a0c000b0b02400240200c4108710d00200120046a210a200020046a21040c010b200020046a220b200120046a2204290200370200200441086a210a200b41086a21040b0240200c410471450d002004200a280200360200200a41046a210a200441046a21040b0240200c410271450d002004200a2f00003b0000200441026a2104200a41026a210a0b200c410171450d032004200a2d00003a000020000f0b200b200120046a220a28020022063a0000200b41016a200a41016a2f00003b0000200041036a210c200220046b417d6a21052004210b0240034020054111490d01200c200b6a220a2001200b6a220741046a2802002203410874200641187672360200200a41046a200741086a2802002206410874200341187672360200200a41086a2007410c6a2802002203410874200641187672360200200a410c6a200741106a2802002206410874200341187672360200200b41106a210b200541706a21050c000b0b2002417d6a2009416f2009416f4b1b20086a4170716b20046b210c2001200b6a41036a210a2000200b6a41036a210b0c010b200b200120046a220a28020022083a0000200b41016a200a41016a2d00003a0000200041026a210c200220046b417e6a21052004210b0240034020054112490d01200c200b6a220a2001200b6a220941046a2802002203411074200841107672360200200a41046a200941086a2802002208411074200341107672360200200a41086a2009410c6a2802002203411074200841107672360200200a410c6a200941106a2802002208411074200341107672360200200b41106a210b200541706a21050c000b0b2002417e6a2007416e2007416e4b1b20066a4170716b20046b210c2001200b6a41026a210a2000200b6a41026a210b0b0240200c411071450d00200b200a2d00003a0000200b200a280001360001200b200a290005370005200b200a2f000d3b000d200b200a2d000f3a000f200b41106a210b200a41106a210a0b0240200c410871450d00200b200a290000370000200b41086a210b200a41086a210a0b0240200c410471450d00200b200a280000360000200b41046a210b200a41046a210a0b0240200c410271450d00200b200a2f00003b0000200b41026a210b200a41026a210a0b200c410171450d00200b200a2d00003a00000b20000bfb0202027f017e02402002450d00200020013a0000200020026a2203417f6a20013a000020024103490d00200020013a0002200020013a00012003417d6a20013a00002003417e6a20013a000020024107490d00200020013a00032003417c6a20013a000020024109490d002000410020006b41037122046a2203200141ff017141818284086c22013602002003200220046b417c7122046a2202417c6a200136020020044109490d002003200136020820032001360204200241786a2001360200200241746a200136020020044119490d002003200136021820032001360214200320013602102003200136020c200241706a20013602002002416c6a2001360200200241686a2001360200200241646a20013602002001ad220542208620058421052004200341047141187222016b2102200320016a2101034020024120490d0120012005370300200141186a2005370300200141106a2005370300200141086a2005370300200141206a2101200241606a21020c000b0b20000b3a01017f23808080800041106b220141f08a84800036020c2000200128020c41076a41787122013602042000200136020020003f0036020c20000b120041808880800020004108108b808080000bc10101067f23808080800041106b22032480808080002003200136020c024002402001450d002000200028020c200241036a410020026b220471220520016a220641107622076a220836020c200020022000280204220120066a6a417f6a20047122023602040240200841107420024b0d002000410c6a200841016a360200200741016a21070b0240200740000d001080808080000b20012003410c6a41041087808080001a200120056a21000c010b410021000b200341106a24808080800020000b2e000240418088808000200120006c22004108108b808080002201450d002001410020001088808080001a0b20010b02000b0f004180888080001089808080001a0b3a01027f2000410120001b2101024003402001108a8080800022020d014100280290888080002200450d012000118080808000000c000b0b20020b0a002000108d808080000b7a01027f200021010240024003402001410371450d0120012d0000450d02200141016a21010c000b0b2001417c6a21010340200141046a22012802002202417f73200241fffdfb776a7141808182847871450d000b0340200241ff0171450d01200141016a2d00002102200141016a21010c000b0b200120006b0bce0301067f024020002001460d000240024002400240200120006b20026b410020024101746b4d0d0020012000734103712103200020014f0d012003450d02200021030c030b2000200120021087808080000f0b024020030d002001417f6a210402400340200020026a2203410371450d012002450d052003417f6a200420026a2d00003a00002002417f6a21020c000b0b2000417c6a21032001417c6a2104034020024104490d01200320026a200420026a2802003602002002417c6a21020c000b0b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b0b200241046a21052002417f7321064100210402400340200120046a2107200020046a2208410371450d0120022004460d03200820072d00003a00002005417f6a2105200641016a2106200441016a21040c000b0b200220046b2101410021030240034020014104490d01200820036a200720036a280200360200200341046a21032001417c6a21010c000b0b200720036a2101200820036a210320022006417c2006417c4b1b20056a417c716b20046b21020b03402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b0b20000b0900200041013602000b0900200041003602000b5201017f20004200370200200041086a22024100360200024020012d00004101710d00200020012902003702002002200141086a28020036020020000f0b20002001280208200128020410968080800020000b7701027f0240200241704f0d00024002402002410a4b0d00200020024101743a0000200041016a21030c010b200241106a4170712204108f8080800021032000200236020420002004410172360200200020033602080b2003200120021097808080001a200320026a41003a00000f0b108680808000000b1a0002402002450d0020002001200210878080800021000b20000b1d00024020002d0000410171450d0020002802081090808080000b20000b8f0201037f0240416e20016b2002490d000240024020002d00004101710d00200041016a21080c010b200028020821080b416f21090240200141e6ffffff074b0d00410b21092001410174220a200220016a22022002200a491b2202410b490d00200241106a41707121090b2009108f80808000210202402004450d002002200820041097808080001a0b02402006450d00200220046a200720061097808080001a0b0240200320056b220320046b2207450d00200220046a20066a200820046a20056a20071097808080001a0b02402001410a460d0020081090808080000b200020023602082000200320066a220436020420002009410172360200200220046a41003a00000f0b108680808000000b1a0002402002450d0020002001200210928080800021000b20000b1e0002402001450d002000200241ff0171200110888080800021000b20000ba50201047f0240024020002d0000220441017122050d00200441017621040c010b200028020421040b024020042001490d00410a210602402005450d002000280200417e71417f6a21060b0240024002400240200620046b20034f0d0020002006200420036a20066b200420014100200320021099808080000c010b2003450d0020050d01200041016a21060c020b20000f0b200028020821060b0240200420016b2207450d00200620016a220520036a20052007109a808080001a200220036a2002200620046a20024b1b2002200520024d1b21020b200620016a20022003109a808080001a200420036a21040240024020002d00004101710d00200020044101743a00000c010b200020043602040b200620046a41003a000020000f0b108680808000000b16002000200120022002109180808000109c808080000bbb0301047f0240024020002d0000220541017122060d00200541017621050c010b200028020421050b024020052001490d00200520016b2207200220072002491b2102410a210802402006450d002000280200417e71417f6a21080b0240200220056b20086a20044f0d0020002008200520046a20026b20086b2005200120022004200310998080800020000f0b0240024020060d00200041016a21080c010b200028020821080b02400240024020022004470d00200421020c010b200720026b2207450d00200820016a21060240200220044d0d00200620032004109a808080001a200620046a200620026a2007109a808080001a0c020b0240200620034f0d00200820056a20034d0d000240200620026a20034d0d00200620032002109a808080001a200420026b2106200320046a2103200220016a210141002102200621040c010b2003200420026b6a21030b200820016a220620046a200620026a2007109a808080001a0b200820016a20032004109a808080001a0b200420026b20056a21050240024020002d00004101710d00200020054101743a00000c010b200020053602040b200820056a41003a000020000f0b108680808000000b7701027f0240200141704f0d00024002402001410a4b0d00200020014101743a0000200041016a21030c010b200141106a4170712204108f8080800021032000200136020420002004410172360200200020033602080b200320012002109b808080001a200320016a41003a00000f0b108680808000000b2801017f41002101024003402001410c460d01200020016a4100360200200141046a21010c000b0b0b1d0020004200370200200041086a4100360200200010a08080800020000bb60101037f4194888080001093808080004100280298888080002100024003402000450d01024003404100410028029c888080002202417f6a220136029c8880800020024101480d01200020014102746a22004184016a2802002102200041046a2802002100419488808000109480808000200220001181808080000041948880800010938080800041002802988880800021000c000b0b4100412036029c88808000410020002802002200360298888080000c000b0b0bcd0101027f419488808000109380808000024041002802988880800022030d0041a0888080002103410041a088808000360298888080000b02400240410028029c8880800022044120470d004184024101108c808080002203450d0141002104200341002802988880800036020041002003360298888080004100410036029c888080000b4100200441016a36029c88808000200320044102746a22034184016a2001360200200341046a200036020041948880800010948080800041000f0b419488808000109480808000417f0b0f0041a48a8080001098808080001a0b89010020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d00200010a68080800020012802044f0d00024020024104710d00200042003702000c010b1080808080000b024002402002411071450d00200010a68080800020012802044d0d0020024104710d01200042003702000b20000f0b10808080800020000b3400024002402000280204450d0020002802002c0000417f4c0d0141010f0b41000f0b200010a780808000200010a8808080006a0b280002402000280204450d0020002802002c0000417f4c0d0041000f0b200010ad8080800041016a0bc90301047f0240024002402000280204450d00200010ae808080004101210120002802002c00002202417f4c0d010c020b41000f0b0240200241ff0171220141b7014b0d00200141807f6a0f0b024002400240200241ff0171220241bf014b0d000240200041046a22032802002202200141c97e6a22044b0d00108080808000200328020021020b024020024102490d0020002802002d00010d001080808080000b024020044105490d001080808080000b024020002802002d00010d001080808080000b41002101410021020240034020042002460d012001410874200028020020026a41016a2d0000722101200241016a21020c000b0b200141384f0d010c020b0240200241f7014b0d00200141c07e6a0f0b0240200041046a22032802002202200141897e6a22044b0d00108080808000200328020021020b024020024102490d0020002802002d00010d001080808080000b024020044105490d001080808080000b024020002802002d00010d001080808080000b41002101410021020240034020042002460d012001410874200028020020026a41016a2d0000722101200241016a21020c000b0b20014138490d010b200141ff7d490d010b10808080800020010f0b20010b5102017f017e23808080800041306b220124808080800020012000290200220237031020012002370308200141186a200141086a411410a58080800010a6808080002100200141306a24808080800020000b6a01037f02400240024020012802002204450d0041002105200320026a200128020422064b0d0120062002490d014100210120062003490d02200620026b20032003417f461b2101200420026a21050c020b410021050b410021010b20002001360204200020053602000b3301017f0240200110a880808000220220012802044d0d001080808080000b20002001200110a780808000200210aa808080000bd003020a7f017e23808080800041c0006b220324808080800002402001280208220420024d0d00200341386a200110ab80808000200320032903383703182001200341186a10a98080800036020c200341306a200110ab80808000410021044100210541002106024020032802302207450d00410021054100210620032802342208200128020c2209490d00200820092009417f461b2105200721060b20012006360210200141146a2005360200200141086a41003602000b200141106a2106200141146a21092001410c6a2107200141086a210802400340200420024f0d012009280200450d01200341306a200110ab8080800041002104024002402003280230220a450d00410021052003280234220b2007280200220c490d01200a200c6a2105200b200c6b21040c010b410021050b20092004360200200620053602002003200436022c2003200536022820032003290328370310200341306a20064100200341106a10a98080800010aa8080800020062003290330220d37020020072007280200200d422088a76a3602002008200828020041016a22043602000c000b0b20032006290200220d3703202003200d3703082000200341086a411410a5808080001a200341c0006a2480808080000b4701017f4100210102402000280204450d00024020002802002d0000220041bf014b0d00200041b801490d01200041c97e6a0f0b200041f801490d00200041897e6a21010b20010b5401017f024020002802040d001080808080000b0240200028020022012d0000418101470d000240200041046a28020041014b0d00108080808000200028020021010b20012c00014100480d001080808080000b0bbc0101047f024002402000280204450d00200010ae80808000200028020022012c000022024100480d0120024100470f0b41000f0b410121030240200241807f460d000240200241ff0171220441b7014b0d000240200041046a28020041014b0d00108080808000200028020021010b20012d00014100470f0b41002103200441bf014b0d000240200041046a280200200241ff017141ca7e6a22024b0d00108080808000200028020021010b200120026a2d000041004721030b20030b2701017f200020012802002203200320012802046a10b1808080002000200210b28080800020000b34002000200220016b220210b380808000200028020020002802046a200120021087808080001a2000200028020420026a3602040bb60201087f02402001450d002000410c6a2102200041106a2103200041046a21040340200328020022052002280200460d010240200541786a28020020014f0d00108080808000200328020021050b200541786a2206200628020020016b220136020020010d01200320063602002000410120042802002005417c6a28020022016b220510b480808000220741016a20054138491b2206200428020022086a10b580808000200120002802006a220920066a2009200820016b1092808080001a02400240200541374b0d00200028020020016a200541406a3a00000c010b0240200741f7016a220641ff014b0d00200028020020016a20063a00002000280200200720016a6a210103402005450d02200120053a0000200541087621052001417f6a21010c000b0b1080808080000b410121010c000b0b0b21000240200028020420016a220120002802084d0d002000200110b6808080000b0b2501017f41002101024003402000450d0120004108762100200141016a21010c000b0b20010b13002000200110b680808000200020013602040b4501017f0240200028020820014f0d002001108a808080002202200028020020002802041087808080001a200010bb80808000200041086a2001360200200020023602000b0b29002000410110b380808000200028020020002802046a20013a00002000200028020441016a3602040b3c01017f0240200110b480808000220320026a2202418002480d001080808080000b2000200241ff017110b78080800020002001200310b9808080000b44002000200028020420026a10b580808000200028020020002802046a417f6a2100024003402001450d01200020013a0000200141087621012000417f6a21000c000b0b0bf90101037f23808080800041106b22032480808080002001280200210420012802042105024002402002450d004100210102400340200420016a2102200120054f0d0120022d00000d01200141016a21010c000b0b200520016b21050c010b200421020b0240024002400240024020054101470d0020022c000022014100480d012000200141ff017110b7808080000c040b200541374b0d010b200020054180017341ff017110b7808080000c010b2000200541b70110b8808080000b2003200536020c200320023602082003200329030837030020002003410010b0808080001a0b2000410110b280808000200341106a24808080800020000b1700024020002802002200450d002000108d808080000b0b240041a48a80800010a1808080001a418180808000410041808880800010a3808080001a0b0f0041b08a8080001098808080001a0b830401077f23808080800041c0006b22022480808080004114108f8080800022034200370000200341106a22044100360000200341086a220542003700002003108180808000200241086a41106a2004280000360200200241086a41086a200529000037030020022003290000370308200241306a41086a410036020020024200370330200241306a41d88a8080004100109680808000200241206a41086a410036020020024200370320200241206a200228023420022d0030220441017620044101711b220441286a4130109f808080000240024020022d003022054101710d0020054101762106200241306a41017221070c010b20022802342106200228023821070b41002105200241206a4100200420072006109e808080001a200241206a4101722106200241286a21070240034020054114460d012007280200200620022d00204101711b20046a200241086a20056a2d0000220841047641d98a8080006a2d00003a00002007280200200620022d00204101711b20046a41016a2008410f7141d98a8080006a2d00003a0000200541016a2105200441026a21040c000b0b200241306a1098808080001a2000200241206a410041d58a808000109d808080002204290200370200200041086a200441086a280200360200200410bf80808000200241206a1098808080001a2003109080808000200241c0006a2480808080000b2801017f41002101024003402001410c460d01200020016a4100360200200141046a21010c000b0b0bfd0502077f017e23808080800041f0006b22002480808080001085808080001082808080002201108a808080002202108380808000200020013602542000200236025020002000290350370308200041d0006a200041106a200041086a411c10a580808000410010ac80808000200041d0006a10ae8080800002400240200041d0006a10af80808000450d002000280254450d0020002802502d000041c001490d010b1080808080000b0240200041d0006a10a8808080002203200028025422044d0d00108080808000200028025421040b200028025021050240024002400240024002402004450d004100210620052c00002201417f4a0d03200141ff0171220641bf014b0d0141002102200141ff017141b801490d02200641c97e6a21020c020b4101210620050d02410021010c030b41002102200141ff017141f801490d00200641897e6a21020b200241016a21060b41002101200620036a20044b0d0020042003490d004100210220042006490d01200520066a2102200420066b20032003417f461b22014109490d011080808080000c010b410021020b42002107024003402001450d012001417f6a210120074208862002310000842107200241016a21020c000b0b0240024020074200510d00200741bc8a80800010c180808000510d01200741c18a80800010c180808000520d00200041306a200041286a10be80808000200041e0006a22024200370300200041d8006a4200370300200042003703502000200041c0006a200041306a1095808080002201280208200141016a20002d0040220441017122061b36026820002001280204200441017620061b36026c20002000290368370300200041d0006a2000410010ba808080001a20011098808080001a0240200028025c2002280200460d001080808080000b200028025020002802541084808080000240200041dc006a2802002201450d00200041e0006a200136020020011090808080000b2000280250108d80808000200041306a1098808080001a0c010b1080808080000b200041f0006a2480808080000b3a01027e42a5c688a1c89ca7f94b21010240034020003000002202500d01200041016a2100200142b383808080207e20028521010c000b0b20010b3900410042003702b08a808000410041003602b88a80800041b08a80800010bf80808000418280808000410041808880800010a3808080001a0b0bf80202004180080bbc02000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000041bc0a0b2e696e6974006765745f706c61746f6e5f636f696e6261736500307800003031323334353637383961626364656600";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GET_PLATON_COINBASE = "get_platon_coinbase";

    protected CoinbaseFunction(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected CoinbaseFunction(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CoinbaseFunction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CoinbaseFunction.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<CoinbaseFunction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CoinbaseFunction.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public RemoteCall<String> get_platon_coinbase() {
        final WasmFunction function = new WasmFunction(FUNC_GET_PLATON_COINBASE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static CoinbaseFunction load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new CoinbaseFunction(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CoinbaseFunction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new CoinbaseFunction(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
