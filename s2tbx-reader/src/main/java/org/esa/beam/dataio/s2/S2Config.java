package org.esa.beam.dataio.s2;

import jp2.TileLayout;
import org.esa.beam.framework.datamodel.ProductData;
import org.openjpeg.JpegUtils;

import java.awt.image.DataBuffer;

/**
 * @author Norman Fomferra
 */
public interface S2Config {
    public boolean DEBUG = Boolean.getBoolean("org.esa.beam.dataio.s2.S2Config.DEBUG");
    public boolean NODUMP = Boolean.getBoolean("org.esa.beam.dataio.s2.S2Config.NODUMP");

    /**
     * Path to "opj_decompress" executable from OpenJPEG 2.1.0 package
     */

    // fixme paramatrize log levels
    String LOG_JPEG = DEBUG ? "INFO" : "FINEST";
    String LOG_SCENE = DEBUG ? "INFO" : "FINEST";
    String LOG_OPS = DEBUG ? "FINE" : "FINEST";

    String OPJ_DECOMPRESSOR_EXE = JpegUtils.getExecutable(L1cMetadataProc.tryGetModulesDir());
    String OPJ_INFO_EXE = JpegUtils.getInfoExecutable(L1cMetadataProc.tryGetModulesDir());

    int DEFAULT_JAI_TILE_SIZE = 512;

    int SAMPLE_PRODUCT_DATA_TYPE = ProductData.TYPE_UINT16;
    int SAMPLE_DATA_BUFFER_TYPE = DataBuffer.TYPE_USHORT;
    int SAMPLE_BYTE_COUNT = 2;

    short FILL_CODE_NO_FILE = DEBUG ? (short) 1000 : 0;
    short FILL_CODE_NO_INTERSECTION = DEBUG ? (short) 1 : 0;
    short FILL_CODE_OUT_OF_X_BOUNDS = DEBUG ? (short) 2 : 0;
    short FILL_CODE_OUT_OF_Y_BOUNDS = DEBUG ? (short) 3 : 0;
    short FILL_CODE_MOSAIC_BG = DEBUG ? (short) 4 : 0;

    short RAW_NO_DATA_THRESHOLD = DEBUG ? (short) 4 : (short) 1;

    //todo these numbers should actually been read from the JP2 files, because they are likely to change if prod. spec. changes
    //todo use classes from jp2 package to read the data
    //todo future improvement: use opj_dump.exe to retrieve the data
    TileLayout[] L1C_TILE_LAYOUTS = new TileLayout[]{
            new TileLayout(10980, 10980, 2048, 2048, 6, 6, 6),
            new TileLayout(5490, 5490, 2048, 2048, 3, 3, 6),
            new TileLayout(1830, 1830, 2048, 2048, 1, 1, 6),
    };

    String FORMAT_NAME = "SENTINEL-2-MSI-L1C";
    String MTD_EXT = ".xml";
}