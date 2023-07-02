package com.asig.casco.pdfGenerator;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.asig.casco.insurance.insurance.dto.insurance.InsuranceDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;


@Component
public class PdfGenerator {

    public byte[] generatePdf(InsuranceDTO insurance) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Hello, World!");
                contentStream.endText();
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);
            return outputStream.toByteArray();
        }
    }
}





/*
@Component
public class PdfGenerator {

    public static void generatePdf(InsuranceDTO insurance) {
        // Create a new PDF document
        PDDocument document = new PDDocument();

        // Create a new page
        PDPage page = new PDPage();
        document.addPage(page);

        // Create a content stream for drawing on the page
        PDPageContentStream contentStream;
        try {
            contentStream = new PDPageContentStream(document, page);

            // Add content to the page

            // ...

            // Close the content stream
            contentStream.close();

            // Save the document to a temporary file
            File tempFile = File.createTempFile("insurance", ".pdf");
            document.save(tempFile);

            // Upload the PDF file to AWS S3 bucket
            uploadToS3(tempFile);

            // Generate a public URL for the uploaded file
            URL publicUrl = generatePublicUrl();

            // Print the public URL
            System.out.println("Public URL: " + publicUrl);

            // Close the document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void uploadToS3(File file) {
        // Create S3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        // Specify the S3 bucket and folder path where you want to store the PDF files
        String bucketName = "casco-md-assets";
        String folderPath = "pdfinsurance/";

        // Generate a unique key for the PDF file (e.g., using UUID or timestamp)
        String uniqueKey = folderPath + file.getName();

        // Upload the PDF file to the S3 bucket
        s3Client.putObject(bucketName, uniqueKey, file);
    }

    private static URL generatePublicUrl() {
        // Create S3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        // Specify the S3 bucket and folder path where the PDF files are stored
        String bucketName = "casco-md-assets";
        String folderPath = "pdfinsurance/";

        // Generate a unique key for the PDF file (e.g., using UUID or timestamp)
        String uniqueKey = folderPath + "filename.pdf";

        // Generate a presigned URL for the uploaded file
        GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketName, uniqueKey)
                .withMethod(HttpMethod.GET)
                .withExpiration(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))); // URL expiration time (e.g., 24 hours)

        return s3Client.generatePresignedUrl(urlRequest);
    }

}*/
