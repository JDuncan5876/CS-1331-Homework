import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


/**
 * This class is the Tweet class for Twitter Homework.
 * @author Megan Yang
 * @version 1.0
 **/
public class Tweet extends GridPane implements Comparable<Tweet> {

    private String dateAndTime;
    private String message;
    private User user;
    private boolean likes;
    private HBox buttons;

    /**
     * Constructs a Tweet by taking in a User and a String
     * representation of a message
     * @param user a User
     * @param message a String representation of a message
     **/
    public Tweet(User user, String message) {
        this.user = user;
        this.message = message;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateAndTime = dateFormat.format(date);
        likes = false;

        this.setHgap(10);
        this.setVgap(2);
        this.setPadding(new Insets(5, 10, 5, 10));
        this.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        Text tempuser = new Text(user.getName());
        tempuser.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        this.add(tempuser, 1, 0);

        Text handledate = new Text(user.getTwitterHandle() + " "
            + getDateAndTime());
        handledate.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
        this.add(handledate, 2, 0);

        Text text = new Text(message);
        text.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        text.setWrappingWidth(600);
        this.add(text, 1, 1, 2, 1);

        ImageView tempim = new ImageView();
        tempim.setImage(new Image(user.getImage()));
        tempim.setFitWidth(70);
        tempim.setPreserveRatio(true);
        tempim.setSmooth(true);
        tempim.setCache(true);
        this.add(tempim, 0, 0, 1, 3);

        ImageView emptyHeart = new ImageView(new Image("emptyHeart.png"));
        emptyHeart.setFitWidth(10);
        emptyHeart.setFitHeight(10);
        ImageView fullHeart = new ImageView(new Image("fullHeart.png"));
        fullHeart.setFitWidth(10);
        fullHeart.setFitHeight(10);

        buttons = new HBox(10);
        Button likeButton = new Button("", emptyHeart);
        likeButton.setOnAction(e -> {
                if (!likes) {
                    likeTweet();
                    likeButton.setGraphic(fullHeart);
                } else {
                    unlikeTweet();
                    likeButton.setGraphic(emptyHeart);
                }
            });
        buttons.getChildren().add(likeButton);
        this.add(buttons, 1, 2, 2, 1);
        this.setStyle("-fx-background-color: White");
    }

    /**
     * Getter for message
     * @return the message of the Tweet
     **/
    public String getMessage() {
        return message;
    }

    /**
     * Getter for Date and Time
     * @return the String representation of date and time
     **/
    public String getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Getter for User
     * @return the User
     **/
    public User getUser() {
        return user;
    }

    /**
     * mark the Tweet as "liked"
     * @return
     **/
    public void likeTweet() {
        likes = true;
    }

    /**
     * mark the Tweet as "unliked"
     * @return
     **/
    public void unlikeTweet() {
        likes = false;
    }

    /**
     * Compares this Tweet to another Tweet by the date and time
     * @param other another Tweet
     * @return an int value that tells you whether this Tweet is greater,
     * less than or equal to another tweet.
     **/
    public int compareTo(Tweet other) {
        return dateAndTime.compareTo(other.dateAndTime);
    }

    /**
     * Creates a deep copy of the Tweet object
     * @return A deep copy of the Tweet
     */
    public Tweet deepCopy() {
        return new Tweet(user, message);
    }

    /**
     * Adds a button to the tweet, starting from directly right of the
     * like button.
     * @param b Button object to be added to the buttons on the Tweet.
     */
    public void addButton(Button b) {
        buttons.getChildren().add(b);
    }
}