import com.google.gson.annotations.SerializedName;

public class Review {
    @SerializedName("review_id")
    private String reviewID;

    @SerializedName("stars")
    private int stars;

    @SerializedName("user_id")
    private String userID;

    @SerializedName("business_id")
    private String businessID;

    @SerializedName("useful")
    private int useful;

    @Override
    public String toString() {
        return "Review{" +
                "reviewID = '" + reviewID + '\'' +
                ", stars = " + stars +'\'' +
                ", userID = " + userID +'\'' +
                ", businessID = " + businessID + '\'' +
                ", useful = " + useful +
                '}';
    }
}


