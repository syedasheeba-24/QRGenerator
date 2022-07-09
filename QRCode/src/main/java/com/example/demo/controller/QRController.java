package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.implementation.QRCodeImplementation;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@RestController
@RequestMapping("/barcodes")
public class QRController {
	
    public static QRCodeImplementation qrCodeImplementation =  new QRCodeImplementation();

	

	   /*@GetMapping(value = "/zxing/{qrcode}", produces = MediaType.IMAGE_PNG_VALUE)
	   //public static BufferedImage generateQRCodeImage(@PathVariable("qrcode")String barcodeText) throws Exception {
	 @GetMapping(value = "/zxing", produces = MediaType.IMAGE_PNG_VALUE)
	   public static BufferedImage generateQRCodeImage() throws Exception {
		    QRCodeWriter barcodeWriter = new QRCodeWriter();
		    BitMatrix bitMatrix = 
		      barcodeWriter.encode("hello", BarcodeFormat.QR_CODE, 200, 200);

		    return MatrixToImageWriter.toBufferedImage(bitMatrix);
		}*/
	   
	   
	   @Bean
	   public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
	       return new BufferedImageHttpMessageConverter();
	   }
	    //...
	   @CrossOrigin
	   @GetMapping(value = "/zxing/{url}")
	   public static String generateQRCodeImageNew(@PathVariable String url)
	            throws WriterException, IOException {
	        String shortenedURL=qrCodeImplementation.shortenURL(url);
	        return shortenedURL;
	   }
	   
	   @CrossOrigin
	   @GetMapping(value = "/validateUrl/{testUrl}")
	   public static boolean validateURL(@PathVariable String testUrl) {
	        return qrCodeImplementation.validateURL(testUrl);
	   }
}
