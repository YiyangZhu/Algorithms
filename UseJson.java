import com.google.gson.Gson;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UseJson {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        List<Review> reviews = new ArrayList<>();
        String fileName = "src/yelp_academic_dataset_review.json";
        File file = new File(fileName);
        try (Stream linesStream = Files.lines(file.toPath())) {
            linesStream.forEach(line -> {
                reviews.add(gson.fromJson(line.toString(), Review.class));
            });
        }
        System.out.println(reviews.get(0));
    }
}
