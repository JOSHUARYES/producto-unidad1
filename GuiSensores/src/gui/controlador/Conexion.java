/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controlador;

import static java.awt.image.ImageObserver.ERROR;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;

/**
 *
 * @author JOSHUA
 */
public class Conexion {
    
    private CommPortIdentifier idPuerto;
    private SerialPort puertoSerie;
    private InputStream flujoEntrada;
    

    
    public void inicializarConexion(String puerto) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{
        
        idPuerto = CommPortIdentifier.getPortIdentifier(puerto);
        System.out.println("Puerto" + puerto + "encontrado.");
        if (idPuerto.isCurrentlyOwned()) {
            System.out.println("El puerto esta en uso.");
        } else {
            puertoSerie = (SerialPort) idPuerto.open("RX", 1000);
            System.out.println("Puerto abierto.");
            puertoSerie.setSerialPortParams(9600, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("Puerto COnfigurado");
            flujoEntrada = puertoSerie.getInputStream();
            System.out.println("Flujo de entrada");
        
    
        }

    }
}
