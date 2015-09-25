package uk.ac.ebi.pride.utilities.netCDF;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ucar.ma2.InvalidRangeException;
import uk.ac.ebi.pride.utilities.netCDF.core.MsScan;
import uk.ac.ebi.pride.utilities.netCDF.utils.netCDFParsingException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import static org.junit.Assert.*;

public class NetCDFFileTest {

    File sourcefile = null;

    NetCDFFile cdfFile = null;

    @Before
    public void setUp() throws Exception {

        try {
            URL testFile = getClass().getClassLoader().getResource("SBEP_Microbiome_025.CDF");
            assertNotNull("Error loading netCDF test file", testFile);
            sourcefile = new File(testFile.toURI());

            if (sourcefile != null)
                cdfFile = new NetCDFFile(sourcefile);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void indexNetFile(){
        assertTrue(cdfFile.getNumberScans() == 5020);
    }

    @Test
    public void testScan() throws netCDFParsingException, InvalidRangeException, IOException {
        Collection<Integer> ids = cdfFile.getScanIdentifiers();
        for(Integer id: ids){
            MsScan scan = cdfFile.readNextScan(id);
            Float totalIntensity = 0.0f;
            for(Float intensity: scan.getDataPoints().values())
                totalIntensity += intensity;
            System.out.println("Scan: " + id + " TIC: " + totalIntensity);
        }
    }



    @After
    public void tearDown() throws Exception {
        cdfFile.close();
    }
}