/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmockit;

import apptesting.CountryNotFoundException;

/**
 *
 * @author BERNAT
 */
public class FootballReport {
    
    
    public  String getReport(Pais p) throws CountryNotFoundException{
        
        String report="";
       
        Downloader d = new Downloader();
        CountryManager cm = new CountryManager();
        String url = cm.getUrlFor(p);
        String XML;
        if(url!=null) {
            XML = d.downloadXML(url);
        } else {
            throw new CountryNotFoundException();
        }
        return XML;
    }
}
