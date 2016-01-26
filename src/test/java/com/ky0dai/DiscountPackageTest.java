package com.ky0dai;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * DiscountPackage Tester.
 *
 * @author <Authors name>
 * @since <pre>01/26/2016</pre>
 * @version 1.0
 */
public class DiscountPackageTest {

    DiscountPackage thing;
    @Before
    public void setUp() throws Exception {
        thing = new DiscountPackage(null, "TestDiscount");
    }

    @Test
    public void testGetDiscountName() throws Exception {
        assertEquals("TestDiscount", thing.getDiscountName());
    }

}
