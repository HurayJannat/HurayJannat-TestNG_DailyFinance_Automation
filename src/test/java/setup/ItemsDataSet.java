package setup;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ItemsDataSet {

    @DataProvider(name = "AddItemCSV")
    public Object[][] getCSVData() throws IOException {
        String filePath = "./src/test/resources/items.csv";
        List<Object[]> data = new ArrayList<>();

        // Check if the file exists
        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            throw new IOException("CSV file not found at path: " + filePath);
        }

        // Use try-with-resources to read the file
        try (CSVParser csvParser = CSVParser.parse(Files.newBufferedReader(path),
                CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                // Fetch each column
                String itemName = csvRecord.get("itemName").trim();
                String cost = csvRecord.get("cost").trim();
                String amount = csvRecord.get("amount").trim();
                String month = csvRecord.get("month").trim();
                String remarks = csvRecord.get("remarks").trim();

                // Add to the list
                data.add(new Object[]{itemName, cost, amount, month, remarks});
            }
        }

        // Convert list to array and return
        return data.toArray(new Object[0][]);
    }
}
