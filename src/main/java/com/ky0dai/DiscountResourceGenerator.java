package com.ky0dai;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Created by kyodai on 1/25/2016.
 */
public class DiscountResourceGenerator {

    // Bad code - just generate some garbage discount
    private DiscountPackage freeShippingDiscount = new DiscountPackage(
            new ArrayList<Promotion>() {{
                add(new Promotion(0.5d, "Half-off shipping!", PromotionType.Shipping));
                add(new Promotion(0.1d, "10% off purchase!", PromotionType.Purchase));
            }},
            "Web Promotion");

    private DiscountPackage storeSaleDiscount = new DiscountPackage(
            new ArrayList<Promotion>() {{
                add(new Promotion(0.2d, "20% off whole purchase!", PromotionType.Purchase));
            }},
            "In-Store Promotion");


    public String getWebPromotionResource() throws JAXBException {
        return generateDiscountPackageXml(freeShippingDiscount);
    }

    public String getStorePromotionResource() throws JAXBException {
        return generateDiscountPackageXml(storeSaleDiscount);
    }

    public int getVersion() {
        return 3;
    }


    private String generateDiscountPackageXml(DiscountPackage discountIn) throws JAXBException {
        final StringWriter writer = new StringWriter();

        final Marshaller discountBuilderContextMarshaller = JAXBContext.newInstance("com.ky0dai").createMarshaller();
        final JAXBElement<DiscountPackage> discountElement =
                new JAXBElement<DiscountPackage>(new QName("DiscountPackage"),
                                                DiscountPackage.class,
                                                discountIn);
        discountBuilderContextMarshaller.marshal(discountElement, writer);

        return writer.toString();
    }
}
