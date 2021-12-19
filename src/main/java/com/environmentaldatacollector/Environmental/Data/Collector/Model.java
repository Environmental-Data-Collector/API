package com.environmentaldatacollector.Environmental.Data.Collector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Model {
    @Id
    private String id;
    private String timeStamp;
    private String temperatureMean;
    private String humidityMean;
    private String pressureMean;
    private String lightIntensityMean;
    private String temperatureSD;
    private String humiditySD;
    private String pressureSD;
    private String lightIntensitySD;

    public Model( String timeStamp, String temperatureMean, String humidityMean, String pressureMean, String lightIntensityMean, String temperatureSD, String humiditySD, String pressureSD, String lightIntensitySD ) {
        this.timeStamp = timeStamp;
        this.temperatureMean = temperatureMean;
        this.humidityMean = humidityMean;
        this.pressureMean = pressureMean;
        this.lightIntensityMean = lightIntensityMean;
        this.temperatureSD = temperatureSD;
        this.humiditySD = humiditySD;
        this.pressureSD = pressureSD;
        this.lightIntensitySD = lightIntensitySD;
    }
}
