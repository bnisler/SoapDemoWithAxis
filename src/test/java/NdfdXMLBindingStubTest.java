import gov.weather.DwmlType;
import gov.weather.NdfdXMLBindingStub;
import gov.weather.NdfdXMLLocator;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by Ben on 2/21/2017.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        String response = binding.latLonListZipCode("53711");
        DwmlType dwmlType = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));

        Assert.assertNotNull("Could not get a response", response);
        Assert.assertNotNull("Could not Unmarshall the reseponse", dwmlType);
        Assert.assertEquals("Result did not match expected value", "43.0798,-89.3875", dwmlType.getLatLonList());
    }

}