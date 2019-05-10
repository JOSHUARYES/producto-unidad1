/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author JOSHUA
 */
public class Distancia {
    public ChartPanel tx(XYSeriesCollection datos, XYSeries series){
           
    
        JFreeChart grafica;
        
    
        //Introduccion de datos
        series.add(0,0);
        datos.addSeries(series);
            
            
        grafica = ChartFactory.createXYLineChart("Distancia", 
                    "Tiempo", "cm", datos, PlotOrientation.VERTICAL, 
                    true, true, false);
            
        
        //ChartFrame frame= new ChartFrame("Ejemplo",chart);
        //frame.pack();
        //frame.setVisible(true);
        ChartPanel panel=new ChartPanel(grafica);
        
        return panel;
        
        }

       
}
