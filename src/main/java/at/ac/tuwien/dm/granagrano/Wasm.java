package at.ac.tuwien.dm.granagrano;

import java.util.function.BiFunction;
// import java.util.function.
import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSNumber;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Wasm {


    public static int add(int a, int b) {
        return a + b;
    }

    @JS(args = {"adder"}, value = "globalThis.adder = adder;")
    private static native void export(BiFunction<JSNumber, JSNumber, JSNumber> adder);

    public static void main(String[] args) {
        export((a, b) -> {
            return JSNumber.of(add(a.asInt(), b.asInt()));
        });
    }

}
