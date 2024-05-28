package Util;

import com.example.QRCodeLast.entity.Ticket;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void generateQRCode(Ticket ticket) throws WriterException, IOException {
        String qrCodePath = "C:\\Users\\ROG\\Downloads\\Project\\img\\";
        String qrCodeName = qrCodePath+ticket.getNameFilm()+ticket.getId()+"-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =  qrCodeWriter.encode("ID: "+ticket.getId()+"\n"+
                "Name: "+ticket.getNameFilm()+"\n"+
                "Seat: "+ticket.getSeatID()+"\n"
                +"Host: "+ticket.getHostID(), BarcodeFormat.QR_CODE,400,400 );
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
}

