package com.asig.casco.pdfGenerator;

import com.asig.casco.insurance.insurance.Insurance;
import com.asig.casco.insurance.insurance.InsuranceService;
import com.asig.casco.insurance.insurance.dto.insurance.InsuranceDTO;
import com.asig.casco.insurance.person.PersonMapper;
import com.asig.casco.insurance.vehicle.VehicleMapper;
import com.asig.casco.pdfGenerator.amazon.StorageService;
import com.asig.casco.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/pdf")
@AllArgsConstructor
public class PDFController {
    private final InsuranceService insuranceService;
    private final PersonMapper personMapper;
    private final VehicleMapper vehicleMapper;
    private final UserService userService;
    private final StorageService storageService;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final PdfGenerator pdfGenerator;

    @PostMapping("/generate")
    public ResponseEntity<Map<String, String>> generatePdf(@RequestBody Map<String, Object> request) throws IOException {
        String user = (String) request.get("user");
        String date = (String) request.get("date");
        String priceStr = (String) request.get("price");
        Float price = Float.parseFloat(priceStr);

        Insurance insurance = insuranceService.findInsuranceForPDF(
                userService.getUserByEmail(user),
                LocalDate.parse(date, dateFormatter),
                price
        );

/*        if (insurance.getPdfLink() != null && !insurance.getPdfLink().isBlank()) {
            return ResponseEntity.ok(insurance.getPdfLink());
        }*/

        InsuranceDTO dto = new InsuranceDTO(
                vehicleMapper.toDTO(insurance.getVehicle()),
                insurance.getPersons().stream().map(personMapper::toDTO).collect(Collectors.toList()),
                insurance.getInsuranceType().getTypeName(),
                insurance.getPrice().toString(),
                insurance.getVehicle().getId().toString(),
                insurance.getInsurer().getId().toString(),
                insurance.getEffectiveDate().toString(),
                insurance.getExpireDate().toString(),
                insurance.getUser().getEmail(),
                insurance.getPrice()
        );

        byte[] pdfContent = pdfGenerator.generatePdf(dto);

        // Generate a unique file name (e.g., using UUID or timestamp)

        // Upload the PDF to AWS S3
        String fileName = storageService.uploadFile(pdfContent);


        // Generate the public URL for the uploaded file

        // Update the Insurance object with the PDF link and save it
        insurance.setPdfLink("https://casco-md-asets.s3.eu-north-1.amazonaws.com/pdfinsurance/"  + fileName);
        insuranceService.saveInsurance(insurance);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("url", "https://casco-md-asets.s3.eu-north-1.amazonaws.com/pdfinsurance/" + fileName);
        // Return the public URL in the response
        return ResponseEntity.ok(responseMap);
    }
}