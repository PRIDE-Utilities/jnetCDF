package uk.ac.ebi.pride.utilities.netCDF.core;

import java.util.Map;

/**
 * @author Yasset Perez-Riverol (ypriverol@gmail.com)
 * @date 25/09/15
 */
public class MsScan {

    private Map<Float, Float> dataPoints;

    private SpectrumType spectrumType;

    private Float retentionTime;

    public MsScan() {
    }

    public MsScan(Map<Float, Float> dataPoints, SpectrumType spectrumType, Float retentionTime) {
        this.dataPoints = dataPoints;
        this.spectrumType = spectrumType;
        this.retentionTime = retentionTime;
    }

    public void setDataPoints(Map<Float, Float> dataPoints) {
        this.dataPoints = dataPoints;
    }

    public Map<Float, Float> getDataPoints() {
        return dataPoints;
    }

    public void setSpectrumType(SpectrumType spectrumType) {
        this.spectrumType = spectrumType;
    }

    public SpectrumType getSpectrumType() {
        return spectrumType;
    }

    public Float getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(Float retentionTime) {
        this.retentionTime = retentionTime;
    }
}
