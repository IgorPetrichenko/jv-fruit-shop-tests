package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FruitTransactionParserTest {

    @Test
    public void fruitTransactionParser_parseOK() {
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        FruitTransaction fruitTransaction = new FruitTransaction("b", "banana", 20);
        List<String> textForParse = List.of("type,fruit,quantity", "b,banana,20");
        List<FruitTransaction> expected = List.of(fruitTransaction);
        List<FruitTransaction> actual = fruitTransactionParser.getTransaction(textForParse);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fruitTransactionParser_emptyOrNull_notOK() {
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        List<FruitTransaction> expected = new ArrayList<>();
        List<FruitTransaction> actual = fruitTransactionParser.getTransaction(null);
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected, actual);
    }
}
