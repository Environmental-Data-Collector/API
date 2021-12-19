package com.environmentaldatacollector.Environmental.Data.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    @Autowired
    public Service( Repository repository ) { this.repository = repository; }

    public Model insetData(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document document = builder.parse(is);
        Model model = new Model();
        model.setId( document.getElementsByTagName("id").item( 0 ).getTextContent() );
        model.setTimeStamp( document.getElementsByTagName("timeStamp").item( 0 ).getTextContent() );
        NodeList nList = document.getElementsByTagName("mean");
        model.setTemperatureMean(((Element) nList.item(0)).getElementsByTagName("value").item( 0 ).getTextContent());
        model.setHumidityMean(((Element) nList.item(1)).getElementsByTagName("value").item( 0 ).getTextContent());
        model.setPressureMean(((Element) nList.item(2)).getElementsByTagName("value").item( 0 ).getTextContent());
        model.setLightIntensityMean(((Element) nList.item(3)).getElementsByTagName("value").item( 0 ).getTextContent());
        nList = document.getElementsByTagName("SD");
        model.setTemperatureSD(((Element) nList.item(0)).getElementsByTagName("value").item( 0 ).getTextContent());
        model.setHumiditySD(((Element) nList.item(1)).getElementsByTagName("value").item( 0 ).getTextContent());
        model.setPressureSD(((Element) nList.item(2)).getElementsByTagName("value").item( 0 ).getTextContent());
        model.setLightIntensitySD(((Element) nList.item(3)).getElementsByTagName("value").item( 0 ).getTextContent());
        return repository.save( model );
    }

    public List<Model> getData() { return repository.findAll(); }
}
