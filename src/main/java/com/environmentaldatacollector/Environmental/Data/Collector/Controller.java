package com.environmentaldatacollector.Environmental.Data.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/environmental-data-collector.com")
public class Controller {
    private final Service service;

    @Autowired
    public Controller( Service service ) {  this.service = service; }

    @PostMapping("/insert-data")
    public ResponseEntity<Model> insertData( @RequestBody String xml ) throws ParserConfigurationException, IOException, SAXException {
        Model model = service.insetData( xml );
        return new ResponseEntity<>( model, HttpStatus.OK);
    }

    @GetMapping("/get-data")
    public ResponseEntity<List<Model>> getData() {
        List<Model> data = service.getData();
        return new ResponseEntity<>( data, HttpStatus.OK);
    }
}
