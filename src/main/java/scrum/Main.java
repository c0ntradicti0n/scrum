package scrum;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    Gson gson = new Gson();

    public void main() throws IOException {
        String filePath = "murcs_gmbh.json";
        String json = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        Company murcs =  gson.fromJson(json, Company.class);
        murcs.scrumTeam.addSprintSchedule();
        murcs.run();
    }

}
