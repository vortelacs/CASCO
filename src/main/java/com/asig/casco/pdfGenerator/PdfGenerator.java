package com.asig.casco.pdfGenerator;

import com.asig.casco.insurance.insurance.dto.insurance.InsuranceDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Component
public class PdfGenerator {

    public byte[] generatePdf(InsuranceDTO insurance) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDMMType1Font.TIMES_ROMAN, 12);
                float x = 100;
                float y = 700;
                float lineHeight = 16;

                contentStream.newLineAtOffset(x, y);
                String[] lines = {
                        "Date asigurare:",
                        "Tipul de asigurare                  :   " + insurance.getInsuranceType(),
                        "Valabil de la                       :   " + insurance.getEffectiveDate(),
                        "Valabil pana la                     :   " + insurance.getEffectiveDate(),
                        "",
                        "Date sofer:",
                        "Prenume                             :   " + insurance.getPersons().get(0).getFirstName(),
                        "Nume                                :   " + insurance.getPersons().get(0).getLastName(),
                        "Email                               :   " + insurance.getPersons().get(0).getEmail(),
                        "Telefon                             :   " + insurance.getPersons().get(0).getPhone()
                };

                for (String line : lines) {
                    contentStream.showText(line);
                    contentStream.newLineAtOffset(0, -lineHeight);
                }


                if (insurance.getPersons().size() == 2) {
                    String[] additionalPersonLines = {
                            "",
                            "Date sofer aditional:",
                            "Prenume                         :   " + insurance.getPersons().get(1).getFirstName(),
                            "Nume                            :   " + insurance.getPersons().get(1).getLastName(),
                            "Email                           :   " + insurance.getPersons().get(1).getEmail(),
                            "Telefon                         :   " + insurance.getPersons().get(1).getPhone()
                    };

                    for (String line : additionalPersonLines) {
                        contentStream.showText(line); // Show the text without new line
                        contentStream.newLineAtOffset(0, -lineHeight);
                    }
                }

                // Draw the remaining lines of text
                String[] remainingLines = {
                        "",
                        "Date vehicul:",
//                        "Tip                                 :   " + insurance.getVehicle().getType(),
                        "Marca                               :   " + insurance.getVehicle().getMake(),
                        "Model                               :   " + insurance.getVehicle().getModel(),
                        "Anul                                :   " + insurance.getVehicle().getYear(),
                        "Numar certificat de inregistrare    :   " + insurance.getVehicle().getCertificateNumber(),
                        "Numar inmatriculare                 :   " + insurance.getVehicle().getRegistrationNumber(),
                        "",
                        "",
                        "Pretul                          :   " + insurance.getPrice()
                };

                for (String line : remainingLines) {
                    contentStream.showText(line); // Show the text without new line
                    contentStream.newLineAtOffset(0, -lineHeight);
                }

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
