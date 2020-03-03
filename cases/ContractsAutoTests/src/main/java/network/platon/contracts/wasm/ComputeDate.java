package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Int32;
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
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.7.5.6-SNAPSHOT.
 */
public class ComputeDate extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001410b60000060017f0060027f7f006000017f60037f7f7f017f60017f017f60027f7f017f60037f7f7f0060057f7f7f7f7f017f60047f7f7f7f0060047f7f7f7f017f02700503656e760c706c61746f6e5f6465627567000203656e760c706c61746f6e5f70616e6963000003656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000303656e7610706c61746f6e5f6765745f696e707574000103656e760d706c61746f6e5f72657475726e00020380017f000004040505050401060100050104040101010607040805080406050100040206050605010501060104050505050902070501040a02060a04050909040502020602060206020702070402020605060505050707060606060602090506020202090102060604090202060a02050609010402060706000501010400020602000405017001040405030100020615037f0141f08c040b7f0041f08c040b7f0041e20c0b075406066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300050b5f5f686561705f6261736503010a5f5f646174615f656e6403020f5f5f66756e63735f6f6e5f65786974002206696e766f6b65007f0909010041010b03292d7c0aeb717f09001010107a1083010b02000bc60a010b7f2002410f6a210341002104410020026b21052002410e6a2106410120026b21072002410d6a2108410220026b210902400340200020046a210b200120046a210a20022004460d01200a410371450d01200b200a2d00003a00002003417f6a2103200541016a21052006417f6a2106200741016a21072008417f6a2108200941016a2109200441016a21040c000b0b200220046b210c02400240024002400240200b410371220d450d00200c4120490d03200d4101460d01200d4102460d02200d4103470d03200b200120046a28020022063a0000200041016a210c200220046b417f6a21092004210b0240034020094113490d01200c200b6a220a2001200b6a220741046a2802002208411874200641087672360200200a41046a200741086a2802002206411874200841087672360200200a41086a2007410c6a2802002208411874200641087672360200200a410c6a200741106a2802002206411874200841087672360200200b41106a210b200941706a21090c000b0b2002417f6a2005416d2005416d4b1b20036a4170716b20046b210c2001200b6a41016a210a2000200b6a41016a210b0c030b200c210a02400340200a4110490d01200020046a220b200120046a2207290200370200200b41086a200741086a290200370200200441106a2104200a41706a210a0c000b0b02400240200c4108710d00200120046a210a200020046a21040c010b200020046a220b200120046a2204290200370200200441086a210a200b41086a21040b0240200c410471450d002004200a280200360200200a41046a210a200441046a21040b0240200c410271450d002004200a2f00003b0000200441026a2104200a41026a210a0b200c410171450d032004200a2d00003a000020000f0b200b200120046a220a28020022063a0000200b41016a200a41016a2f00003b0000200041036a210c200220046b417d6a21052004210b0240034020054111490d01200c200b6a220a2001200b6a220741046a2802002203410874200641187672360200200a41046a200741086a2802002206410874200341187672360200200a41086a2007410c6a2802002203410874200641187672360200200a410c6a200741106a2802002206410874200341187672360200200b41106a210b200541706a21050c000b0b2002417d6a2009416f2009416f4b1b20086a4170716b20046b210c2001200b6a41036a210a2000200b6a41036a210b0c010b200b200120046a220a28020022083a0000200b41016a200a41016a2d00003a0000200041026a210c200220046b417e6a21052004210b0240034020054112490d01200c200b6a220a2001200b6a220941046a2802002203411074200841107672360200200a41046a200941086a2802002208411074200341107672360200200a41086a2009410c6a2802002203411074200841107672360200200a410c6a200941106a2802002208411074200341107672360200200b41106a210b200541706a21050c000b0b2002417e6a2007416e2007416e4b1b20066a4170716b20046b210c2001200b6a41026a210a2000200b6a41026a210b0b0240200c411071450d00200b200a2d00003a0000200b200a280001360001200b200a290005370005200b200a2f000d3b000d200b200a2d000f3a000f200b41106a210b200a41106a210a0b0240200c410871450d00200b200a290000370000200b41086a210b200a41086a210a0b0240200c410471450d00200b200a280000360000200b41046a210b200a41046a210a0b0240200c410271450d00200b200a2f00003b0000200b41026a210b200a41026a210a0b200c410171450d00200b200a2d00003a00000b20000bfb0202027f017e02402002450d00200020013a0000200020026a2203417f6a20013a000020024103490d00200020013a0002200020013a00012003417d6a20013a00002003417e6a20013a000020024107490d00200020013a00032003417c6a20013a000020024109490d002000410020006b41037122046a2203200141ff017141818284086c22013602002003200220046b417c7122046a2202417c6a200136020020044109490d002003200136020820032001360204200241786a2001360200200241746a200136020020044119490d002003200136021820032001360214200320013602102003200136020c200241706a20013602002002416c6a2001360200200241686a2001360200200241646a20013602002001ad220542208620058421052004200341047141187222016b2102200320016a2101034020024120490d0120012005370300200141186a2005370300200141106a2005370300200141086a2005370300200141206a2101200241606a21020c000b0b20000b7a01027f200021010240024003402001410371450d0120012d0000450d02200141016a21010c000b0b2001417c6a21010340200141046a22012802002202417f73200241fffdfb776a7141808182847871450d000b0340200241ff0171450d01200141016a2d00002102200141016a21010c000b0b200120006b0b3901017f23808080800041106b2201410036020c2000200128020c28020041076a41787122013602042000200136020020003f0036020c20000b120041808880800020004108108c808080000bbd0101047f23808080800041106b22032480808080002003200136020c024002402001450d002000200028020c200141046a220441107622056a220636020c200020022000280204220120046a6a417f6a410020026b7122023602040240200641107420024b0d002000410c6a200641016a360200200541016a21050b0240200540000d0041c88a808000108d808080000b20012003410c6a41041087808080001a200141046a21000c010b410021000b200341106a24808080800020000b1800200020001089808080001080808080001081808080000b2e000240418088808000200120006c22004108108c808080002201450d002001410020001088808080001a0b20010b02000b0f00418088808000108a808080001a0b3a01027f2000410120001b2101024003402001108b8080800022020d014100280290888080002200450d012000118080808000000c000b0b20020b0a002000108f808080000bce0301067f024020002001460d000240024002400240200120006b20026b410020024101746b4d0d0020012000734103712103200020014f0d012003450d02200021030c030b2000200120021087808080000f0b024020030d002001417f6a210402400340200020026a2203410371450d012002450d052003417f6a200420026a2d00003a00002002417f6a21020c000b0b2000417c6a21032001417c6a2104034020024104490d01200320026a200420026a2802003602002002417c6a21020c000b0b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b0b200241046a21052002417f7321064100210402400340200120046a2107200020046a2208410371450d0120022004460d03200820072d00003a00002005417f6a2105200641016a2106200441016a21040c000b0b200220046b2101410021030240034020014104490d01200820036a200720036a280200360200200341046a21032001417c6a21010c000b0b200720036a2101200820036a210320022006417c2006417c4b1b20056a417c716b20046b21020b03402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b0b20000b4201027f0240024003402002450d0120002d0000220320012d00002204470d02200141016a2101200041016a21002002417f6a21020c000b0b41000f0b200320046b0b0900200041013602000b0900200041003602000b0900108680808000000b5201017f20004200370200200041086a22024100360200024020012d00004101710d00200020012902003702002002200141086a28020036020020000f0b20002001280208200128020410998080800020000b7701027f0240200241704f0d00024002402002410a4b0d00200020024101743a0000200041016a21030c010b200241106a417071220410918080800021032000200236020420002004410172360200200020033602080b200320012002109a808080001a200320026a41003a00000f0b108680808000000b1a0002402002450d0020002001200210878080800021000b20000b6701027f20004200370200200041086a41003602000240200128020420012d00002205410176200541017122051b22062002490d0020002001280208200141016a20051b20026a200620026b2201200320012003491b10998080800020000f0b108680808000000b1d00024020002d0000410171450d0020002802081092808080000b20000b9a0101027f0240024020002d0000220541017122060d00200541017621050c010b200028020421050b02402004417f460d0020052001490d00200520016b2205200220052002491b21020240024020060d00200041016a21000c010b200028020821000b0240200020016a200320042002200220044b22001b109e808080002201450d0020010f0b417f200020022004491b0f0b108680808000000b190002402002450d002000200120021094808080000f0b41000b270020004200370200200041086a410036020020002001200110898080800010998080800020000b8c0101037f034020002c0000220141776a2102200041016a2203210020014120460d002003210020024105490d000b41002100024002402001412b460d0002402001412d470d00410121020c020b2003417f6a21030b410021020b0240034020032c000041506a220141094b0d01200341016a21032000410a6c20016b21000c000b0b2000410020006b20021b0b0900108680808000000bb60101037f4194888080001095808080004100280298888080002100024003402000450d01024003404100410028029c888080002202417f6a220136029c8880800020024101480d01200020014102746a22004184016a2802002102200041046a2802002100419488808000109680808000200220001181808080000041948880800010958080800041002802988880800021000c000b0b4100412036029c88808000410020002802002200360298888080000c000b0b0bcd0101027f419488808000109580808000024041002802988880800022030d0041a0888080002103410041a088808000360298888080000b02400240410028029c8880800022044120470d004184024101108e808080002203450d0141002104200341002802988880800036020041002003360298888080004100410036029c888080000b4100200441016a36029c88808000200320044102746a22034184016a2001360200200341046a200036020041948880800010968080800041000f0b419488808000109680808000417f0b6001017f23808080800041206b2202248080808000200241186a420037030020024200370310200242003703082000200241086a200110a58080800010a68080800010a7808080001a200241086a10a8808080001a200241206a2480808080000b4101017f23808080800041106b2202248080808000200020022001109f80808000220110e88080800021002001109c808080001a200241106a24808080800020000b23000240200028020c200041106a280200460d0041e98b808000108d808080000b20000b4e01017f20004200370200200041003602080240200128020420012802006b2202450d002000200210de80808000200041086a2001280200200141046a280200200041046a10df808080000b20000b19002000410c6a10e0808080001a200010aa808080001a20000b0f0041a48a80800010aa808080001a0b2201017f024020002802002201450d002000200136020420011092808080000b20000b4701027f23808080800041206b22012480808080002000200141086a410010ac80808000220210a68080800010a7808080001a200210a8808080001a200141206a2480808080000b24002000420037020820004200370200200041106a42003702002000200110c5808080000b0f0041b08a80800010aa808080001a0b95010020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d00200010af8080800020012802044f0d00024020024104710d00200042003702000c010b41e28a808000108d808080000b024002402002411071450d00200010af8080800020012802044d0d0020024104710d01200042003702000b20000f0b41f08a808000108d8080800020000b3400024002402000280204450d0020002802002c0000417f4c0d0141010f0b41000f0b200010b080808000200010b1808080006a0b280002402000280204450d0020002802002c0000417f4c0d0041000f0b200010b68080800041016a0b980401047f0240024002402000280204450d00200010b7808080004101210120002802002c00002202417f4c0d010c020b41000f0b0240200241ff0171220141b7014b0d00200141807f6a0f0b02400240200241ff0171220241bf014b0d000240200041046a22032802002202200141c97e6a22044b0d0041ff8a808000108d80808000200328020021020b024020024102490d0020002802002d00010d0041ff8a808000108d808080000b024020044105490d0041f08a808000108d808080000b024020002802002d00010d0041ff8a808000108d808080000b41002101410021020240034020042002460d012001410874200028020020026a41016a2d0000722101200241016a21020c000b0b200141384f0d0141ff8a808000108d8080800020010f0b0240200241f7014b0d00200141c07e6a0f0b0240200041046a22032802002202200141897e6a22044b0d0041ff8a808000108d80808000200328020021020b024020024102490d0020002802002d00010d0041ff8a808000108d808080000b024020044105490d0041f08a808000108d808080000b024020002802002d00010d0041ff8a808000108d808080000b41002101410021020240034020042002460d012001410874200028020020026a41016a2d0000722101200241016a21020c000b0b200141384f0d0041ff8a808000108d8080800020010f0b200141ff7d490d0041f08a808000108d8080800020010f0b20010b5102017f017e23808080800041306b220124808080800020012000290200220237031020012002370308200141186a200141086a411410ae8080800010af808080002100200141306a24808080800020000b6a01037f02400240024020012802002204450d0041002105200320026a200128020422064b0d0120062002490d014100210120062003490d02200620026b20032003417f461b2101200420026a21050c020b410021050b410021010b20002001360204200020053602000b3901017f0240200110b180808000220220012802044d0d0041808c808000108d808080000b20002001200110b080808000200210b3808080000bd003020a7f017e23808080800041c0006b220324808080800002402001280208220420024d0d00200341386a200110b480808000200320032903383703182001200341186a10b28080800036020c200341306a200110b480808000410021044100210541002106024020032802302207450d00410021054100210620032802342208200128020c2209490d00200820092009417f461b2105200721060b20012006360210200141146a2005360200200141086a41003602000b200141106a2106200141146a21092001410c6a2107200141086a210802400340200420024f0d012009280200450d01200341306a200110b48080800041002104024002402003280230220a450d00410021052003280234220b2007280200220c490d01200a200c6a2105200b200c6b21040c010b410021050b20092004360200200620053602002003200436022c2003200536022820032003290328370310200341306a20064100200341106a10b28080800010b38080800020062003290330220d37020020072007280200200d422088a76a3602002008200828020041016a22043602000c000b0b20032006290200220d3703202003200d3703082000200341086a411410ae808080001a200341c0006a2480808080000b4701017f4100210102402000280204450d00024020002802002d0000220041bf014b0d00200041b801490d01200041c97e6a0f0b200041f801490d00200041897e6a21010b20010b6601017f024020002802040d0041ff8a808000108d808080000b0240200028020022012d0000418101470d000240200041046a28020041014b0d0041ff8a808000108d80808000200028020021010b20012c00014100480d0041ff8a808000108d808080000b0b2d01017f2000200028020420012802002203200320012802046a10b9808080001a2000200210ba8080800020000b970201057f23808080800041206b22042480808080000240200320026b22054101480d00024020052000280208200028020422066b4c0d00200441086a2000200520066a20002802006b10bb80808000200120002802006b200041086a10bc8080800021060240034020032002460d01200641086a220528020020022d00003a00002005200528020041016a360200200241016a21020c000b0b20002006200110bd808080002101200610be808080001a0c010b024002402005200620016b22074c0d00200041086a200220076a22082003200041046a10bf80808000200741014e0d010c020b200321080b200020012006200120056a10c08080800020022008200110c1808080001a0b200441206a24808080800020010bd00201087f02402001450d002000410c6a2102200041106a2103200041046a21040340200328020022052002280200460d010240200541786a28020020014f0d0041878b808000108d80808000200328020021050b200541786a2206200628020020016b220136020020010d0120032006360200200428020020002802006b2005417c6a28020022016b220510c28080800021062000200428020020002802006b22074101200641016a20054138491b22086a10c380808000200120002802006a220920086a2009200720016b1093808080001a02400240200541374b0d00200028020020016a200541406a3a00000c010b0240200641f7016a220741ff014b0d00200028020020016a20073a00002000280200200620016a6a210103402005450d02200120053a0000200541087621052001417f6a21010c000b0b419b8b808000108d808080000b410121010c000b0b0b4c01017f02402001417f4c0d0041ffffffff0721020240200028020820002802006b220041feffffff034b0d0020012000410174220020002001491b21020b20020f0b200010a180808000000b5401017f410021042000410036020c200041106a200336020002402001450d00200110918080800021040b200020043602002000200420026a22023602082000410c6a200420016a3602002000200236020420000b8c0101027f20012802042103200041086a220420002802002002200141046a10e580808000200420022000280204200141086a10eb80808000200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c2001200128020436020020030b2301017f200010e680808000024020002802002201450d0020011092808080000b20000b2e000240200220016b22024101480d002003280200200120021087808080001a2003200328020020026a3602000b0b5c01037f200041046a21042000280204220521062001200520036b6a2203210002400340200020024f0d01200620002d00003a00002004200428020041016a2206360200200041016a21000c000b0b20012003200510ea808080001a0b21000240200120006b2201450d002002200020011093808080001a0b200220016a0b2501017f41002101024003402000450d0120004108762100200141016a21010c000b0b20010b4001027f02402000280204200028020022026b220320014f0d002000200120036b10c4808080000f0b0240200320014d0d00200041046a200220016a3602000b0b920101027f23808080800041206b2202248080808000024002402000280208200028020422036b20014f0d00200241086a2000200320016a20002802006b10bb80808000200041046a28020020002802006b200041086a10bc808080002203200110ec808080002000200310e480808000200310be808080001a0c010b2000200110ed808080000b200241206a2480808080000b7501017f23808080800041106b2202248080808000024002402001450d00200220013602002002200028020420002802006b3602042000410c6a200210c6808080000c010b20024100360208200242003703002000200210c7808080001a200210aa808080001a0b200241106a24808080800020000b3d01017f02402000280204220220002802084f0d0020022001290200370200200041046a2200200028020041086a3602000f0b2000200110c8808080000b5101027f23808080800041106b22022480808080002002200128020022033602082002200128020420036b36020c200220022903083703002000200210c9808080002101200241106a24808080800020010b840101027f23808080800041206b2202248080808000200241086a2000200028020420002802006b41037541016a10ee80808000200028020420002802006b410375200041086a10ef80808000220328020820012902003702002003200328020841086a3602082000200310f080808000200310f1808080001a200241206a2480808080000b800102027f017e23808080800041206b2202248080808000024002402001280204220341374b0d002002200341406a3a001f20002002411f6a10ca808080000c010b2000200341f70110cb808080000b200220012902002204370310200220043703082000200241086a410110b8808080002100200241206a24808080800020000b3d01017f02402000280204220220002802084f0d00200220012d00003a0000200041046a2200200028020041016a3602000f0b2000200110cc808080000b6401027f23808080800041106b22032480808080000240200110c280808000220420026a2202418002480d0041d18b808000108d808080000b200320023a000f20002003410f6a10ca8080800020002001200410cd80808000200341106a2480808080000b7e01027f23808080800041206b2202248080808000200241086a2000200028020441016a20002802006b10bb80808000200028020420002802006b200041086a10bc80808000220328020820012d00003a00002003200328020841016a3602082000200310e480808000200310be808080001a200241206a2480808080000b44002000200028020420026a20002802006b10c3808080002000280204417f6a2100024003402001450d01200020013a00002000417f6a2100200141087621010c000b0b0bfc0101037f23808080800041206b22032480808080002001280200210420012802042105024002402002450d004100210102400340200420016a2102200120054f0d0120022d00000d01200141016a21010c000b0b200520016b21050c010b200421020b0240024002400240024020054101470d0020022c00004100480d012000200210cf808080000c040b200541374b0d010b20032005418001733a001f20002003411f6a10ca808080000c010b2000200541b70110cb808080000b2003200536021420032002360210200320032903103703082000200341086a410010b8808080001a0b2000410110ba80808000200341206a24808080800020000b3d01017f0240200028020422022000280208460d00200220012d00003a0000200041046a2200200028020041016a3602000f0b2000200110d0808080000b7e01027f23808080800041206b2202248080808000200241086a2000200028020441016a20002802006b10bb80808000200028020420002802006b200041086a10bc80808000220328020820012d00003a00002003200328020841016a3602082000200310e480808000200310be808080001a200241206a2480808080000bdb0201047f2380808080004190026b2202248080808000024002400240200110d280808000450d00200141b78b80800010d380808000450d012002200110d4808080003a008f0220002002418f026a10ca808080000c020b200041b78b80800010cf808080000c010b200241c8016a200141c0001087808080001a200241c8006a200241c8016a41c0001087808080001a02400240200241c8006a10d580808000220341374b0d0020022003418001733a008f0220002002418f026a10ca808080000c010b0240200310d680808000220441b7016a2205418002490d0041b88b808000108d808080000b200220053a008f0220002002418f026a10ca8080800020002003200410d7808080000b20024188016a200141c0001087808080001a200241086a20024188016a41c0001087808080001a2000200241086a200310d8808080000b2000410110ba8080800020024190026a24808080800020000b3b01017f23808080800041106b22012480808080002001410036020c20002001410c6a10d9808080002100200141106a24808080800020004101730b5101017f2380808080004180016b2202248080808000200241c0006a200041c0001087808080001a200241c0006a200220012d000010da8080800010db80808000210120024180016a24808080800020010b3701027f410021012000413f6a210241012100024003402000410171450d01200120022d0000722101410021000c000b0b200141ff01710b5701027f23808080800041106b220124808080800041002102024003402001410036020c20002001410c6a10dc80808000450d012000410810dd808080001a200241016a21020c000b0b200141106a24808080800020020b2501017f41002101024003402000450d0120004108762100200141016a21010c000b0b20010b44002000200028020420026a20002802006b10c3808080002000280204417f6a2100024003402001450d01200020013a00002000417f6a2100200141087621010c000b0b0b54002000200028020420026a20002802006b10c3808080002000280204417f6a210002400340200110d280808000450d012000200110d4808080003a00002001410810dd808080001a2000417f6a21000c000b0b0b6d01047f23808080800041c0006b22022480808080002002200128020010e1808080001a4100210141012103024003402001413f4b0d01200020016a2104200220016a2105200141016a210120042d000020052d0000460d000b410021030b200241c0006a24808080800020030b1b002000410041c0001088808080002200200110e38080800020000b7501047f23808080800041c0006b22022480808080002002200141c00010878080800021034100210441002101024003402001413f4b0d01200020016a2102200320016a2105200141016a210120022d0000220220052d00002205460d000b200220054921040b200341c0006a24808080800020040b5101017f2380808080004180016b2202248080808000200241c0006a200041c0001087808080001a200241c0006a2002200128020010e18080800010f780808000210120024180016a24808080800020010b3f01017f23808080800041c0006b220224808080800020022000200110f8808080002000200241c0001087808080002100200241c0006a24808080800020000b3801017f02402001417f4c0d00200020011091808080002202360200200020023602042000200220016a3602080f0b200010a180808000000b2e000240200220016b22024101480d002003280200200120021087808080001a2003200328020020026a3602000b0b2201017f024020002802002201450d002000200136020420011092808080000b20000b1b002000410041c0001088808080002200200110e28080800020000b6802017f027e2000413f6a21022001ac2103420021040240034020044220510d01200220032004873c00002002417f6a2102200442087c21040c000b0b2001411f752101413b2102024003402002417f460d01200020026a20013a00002002417f6a21020c000b0b0b2d00200020013a003f413e2101024003402001417f460d01200020016a41003a00002001417f6a21010c000b0b0b7001017f200041086a20002802002000280204200141046a10e580808000200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2f01017f20032003280200200220016b22026b2204360200024020024101480d002004200120021087808080001a0b0b0f002000200028020410e7808080000b2d01017f20002802082102200041086a21000240034020012002460d0120002002417f6a22023602000c000b0b0b4501017f23808080800041106b22022480808080002002200241086a200110e98080800029020037030020002002410010ce808080002100200241106a24808080800020000b360020002001280208200141016a20012d00004101711b3602002000200128020420012d0000220141017620014101711b36020420000b23000240200120006b2201450d00200220016b2202200020011093808080001a0b20020b2e000240200220016b22024101480d002003280200200120021087808080001a2003200328020020026a3602000b0b3401017f20002802082102200041086a21000340200241003a00002000200028020041016a22023602002001417f6a22010d000b0b3401017f20002802042102200041046a21000340200241003a00002000200028020041016a22023602002001417f6a22010d000b0b5301017f024020014180808080024f0d0041ffffffff0121020240200028020820002802006b220041037541feffffff004b0d0020012000410275220020002001491b21020b20020f0b200010a180808000000b5c01017f410021042000410036020c200041106a200336020002402001450d002003200110f28080800021040b200020043602002000200420024103746a22033602082000410c6a200420014103746a3602002000200336020420000b7001017f200041086a20002802002000280204200141046a10f380808000200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2301017f200010f480808000024020002802002201450d0020011092808080000b20000b0e0020002001410010f5808080000b2f01017f20032003280200200220016b22026b2204360200024020024101480d002004200120021087808080001a0b0b0f002000200028020410f6808080000b2300024020014180808080024f0d0020014103741091808080000f0b108680808000000b2d01017f20002802082102200041086a21000240034020012002460d012000200241786a22023602000c000b0b0b0f002000200110f9808080004101730bc10201087f23808080800041c0006b2203248080808000024002402002418004490d002000410010e1808080001a0c010b02402002450d002003200141c00010878080800021040240024020024107712205450d00200420042d003f20057622063a003f410820056b210741002101024003402001413e6a4100480d01200420016a2208413e6a220920092d00002209200576220a3a00002008413f6a20062009200774723a00002001417f6a2101200a21060c000b0b200220056b2202450d010b2004200241086d22066b2108413f21010240034020012006480d01200420016a200820016a2d00003a00002001417f6a21010c000b0b034020014100480d01200420016a41003a00002001417f6a21010c000b0b2000200441c0001087808080001a0c010b2000200141c0001087808080001a0b200341c0006a2480808080000b6e01047f23808080800041c0006b22022480808080002002200141c00010878080800021034100210141012104024003402001413f4b0d01200020016a2102200320016a2105200141016a210120022d000020052d0000460d000b410021040b200341c0006a24808080800020040b4a0041a48a80800041e18a80800010a480808000418180808000410041808880800010a3808080001a41b08a80800010ab80808000418280808000410041808880800010a3808080001a0b2201017f024020002802002201450d002000200136020420011092808080000b20000b0f0041bc8a808000109c808080001a0b1800200020001089808080001080808080001081808080000b890201047f23808080800041c0006b2203248080808000200341306a2001410041042001109b808080002204280208200441016a20042d00004101711b10a08080800021052004109c808080001a200341206a2001410541022001109b808080002201280208200141016a20012d00004101711b10a08080800021042001109c808080001a200341106a2002410041042002109b808080002201280208200141016a20012d00004101711b10a08080800021062001109c808080001a20032002410541022002109b808080002202280208200241016a20022d00004101711b10a08080800021012002109c808080001a200341c0006a2480808080002001200620056b410c6c20046b6a0b800a02057f027e23808080800041b0026b220024808080800010858080800020004198016a410036020020004200370390014100210102404100410c460d00034020004190016a20016a4100360200200141046a2201410c470d000b0b200041003602880120004200370380010240024002401082808080002201450d002001417f4c0d0220004188016a2001109180808000220241002001108880808000220320016a220136020020002001360284012000200336028001200321030c010b4100210141002102410021030b2003108380808000200020023602f0012000200120026b3602f401200020002903f001370348200041d0006a200041e8006a200041c8006a411c10ae808080002203410010b580808000200041d0006a20004190016a10808180800002400240024020002802940120002d009001220141017620014101711b450d0020004190016a41978c8080001081818080000d0220004190016a419c8c808000108181808000450d01200041a8016a4100360200200042003703a0014100210102404100410c460d000340200041a0016a20016a4100360200200141046a2201410c470d000b0b200041b4016a4100360200200042003702ac01200041a0016a410c6a21024100210102404100410c460d000340200220016a4100360200200141046a2201410c470d000b0b200020033602f001200041013602d8012000200041d8016a3602f401200041f0016a200041a0016a108281808000200041f0016a200041ac016a22021082818080002000419f016a200041c8016a200041a0016a1098808080002203200041b8016a2002109880808000220410fe80808000210142002105200041d8016a41106a4200370300200041d8016a41086a4200370300200042003703d801200041a8026a4200370300200041a0026a420037030020004198026a420037030020004190026a420037030020004188026a4200370300200041f0016a41106a4200370300200041f0016a41086a4200370300200042003703f0012001ac22064201862006423f87852106200041af026a21010240420042c000510d000340200120062005883c00002001417f6a2101200542087c220542c000520d000b0b4137210102404137417f460d000340200041f0016a20016a41003a00002001417f6a2201417f470d000b0b200041086a41386a200041f0016a41386a290300370300200041086a41306a200041f0016a41306a290300370300200041086a41286a200041f0016a41286a290300370300200041086a41206a200041f0016a41206a290300370300200041086a41186a200041f0016a41186a290300370300200041086a41106a200041f0016a41106a290300370300200041086a41086a200041f0016a41086a290300370300200020002903f001370308200041d8016a200041086a10d1808080001a024020002802e401200041d8016a41106a280200460d0041c28c80800010fd808080000b20002802d801220120002802dc0120016b1084808080000240200041e4016a2802002201450d00200041e8016a200136020020011092808080000b200041d8016a10fb808080001a2004109c808080001a2003109c808080001a2002109c808080001a200041a0016a109c808080001a0c020b41898c80800010fd808080000c010b41af8c80800010fd808080000b20004180016a10fb808080001a20004190016a109c808080001a200041b0026a2480808080000f0b20004180016a10a180808000000bc50501077f23808080800041106b2202248080808000024002400240024002400240024002400240024002402000280204450d0020002802002d000041c0014f0d000240200010b1808080002203200041046a220428020022054d0d0041d98c80800010fd80808000200428020021050b200028020021062005450d014100210420062c00002207417f4a0d04200741ff0171220841bf014b0d0241002104200741ff017141b801490d03200841c97e6a21040c030b200241086a410036020020024200370300410021004100410c460d080340200220006a4100360200200041046a2200410c470d000c090b0b4101210420060d020c030b41002104200741ff017141f801490d00200841897e6a21040b200441016a21040b200420036a20054b0d0020052003490d0020052004490d00200520046b20032003417f461b2205200010b1808080002200490d01200241086a410036020020024200370300200520002000417f461b220741704f0d05200620046a220520076a21032007410a4d0d02200741106a417071220410918080800021002002200736020420022004410172360200200220003602080c030b200010b1808080001a0b41002107200241086a41003602002002420037030041002105410021030b200220074101743a0000200241017221000b024020032005460d000340200020052d00003a0000200041016a21002003200541016a2205470d000b0b200041003a00000b0240024020012d00004101710d00200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141086a280200109280808000200141003602000b20012002290300370200200141086a200241086a2802003602004100210002404100410c460d000340200220006a4100360200200041046a2200410c470d000b0b2002109c808080001a200241106a2480808080000f0b2002109780808000000b4201037f41002102024020011089808080002203200028020420002d0000220441017620044101711b470d0020004100417f20012003109d808080004521020b20020b5701017f23808080800041206b2202248080808000200241086a2000280200200028020428020010b580808000200241086a200110808180800020002802042200200028020041016a360200200241206a2480808080000b5501017f410042003702bc8a808000410041003602c48a8080004174210002404174450d000340200041c88a8080006a4100360200200041046a22000d000b0b418380808000410041808880800010a3808080001a0b0bf10402004180080bc802000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000041c80a0b9a026661696c656420746f20616c6c6f6361746520706167657300006f7665722073697a6520726c7000756e6465722073697a6520726c700062616420726c70006974656d436f756e7420746f6f206c61726765006974656d436f756e7420746f6f206c6172676520666f7220524c5000804e756d62657220746f6f206c6172676520666f7220524c5000436f756e7420746f6f206c6172676520666f7220524c50006c697374537461636b206973206e6f7420656d7074790062616420636173740076616c6964206d6574686f640a00696e6974004d6f6e7468734265747765656e3244617465006e6f206d6574686f6420746f2063616c6c0a006c697374537461636b206973206e6f7420656d70747900626164206361737400";

    public static String BINARY = BINARY_0;

    public static final String FUNC_MONTHSBETWEEN2DATE = "MonthsBetween2Date";

    protected ComputeDate(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected ComputeDate(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ComputeDate> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ComputeDate.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ComputeDate> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ComputeDate.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public RemoteCall<Int32> MonthsBetween2Date(String date1, String date2) {
        final WasmFunction function = new WasmFunction(FUNC_MONTHSBETWEEN2DATE, Arrays.asList(date1,date2), Int32.class);
        return executeRemoteCall(function, Int32.class);
    }

    public static ComputeDate load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new ComputeDate(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ComputeDate load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new ComputeDate(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}