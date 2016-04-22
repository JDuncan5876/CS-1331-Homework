import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * I worked on this assignment alone, using only course materials
 * @author Jared Duncan (jduncan45)
 * @version 1.0
 */
public class Twitter extends Application {
    private User burdell;
    private TwitterServer server;
    private GridPane tweetMakeBox;
    private ArrayList<Tweet> tweets;
    private ScrollPane feedScroller;
    private int numTweets;
    private Text numTweetText;

    /**
     * Override of start method. Sets up GUI.
     * @param primaryStage The primary window of the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        burdell = new User("George P. Burdell", "@gpburdell", "burdell.jpg",
            "Army veteran and exemplary student.");
        server = new TwitterServer();
        tweets = new ArrayList<Tweet>();
        feedScroller = new ScrollPane();
        feedScroller.setStyle("-fx-background-color: LightSkyBlue");
        numTweets = 0;
        numTweetText = new Text("     0");

        BorderPane primaryPane = new BorderPane();

        primaryPane.setTop(makeTopBar());
        primaryPane.setLeft(makeLeftBar());
        makeFeed();
        primaryPane.setCenter(feedScroller);
        primaryPane.setStyle("-fx-background-color: LightSkyBlue");

        Scene primaryScene = new Scene(primaryPane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Twitter");
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(700);
        primaryStage.setMinWidth(1000);
        primaryStage.show();
    }

    private HBox makeTopBar() {
        HBox topBar = new HBox(460);
        topBar.setPadding(new Insets(5, 0, 10, 80));

        ImageView refreshImage = new ImageView(new Image("refresh.png"));
        refreshImage.setFitHeight(25);
        refreshImage.setFitWidth(25);
        Button refreshButton = new Button("", refreshImage);
        refreshButton.setOnAction(e -> {
                refresh();
                makeFeed();
            });

        ImageView logo = new ImageView(new Image("twitterLogo.png"));
        logo.setFitHeight(40);
        logo.setFitWidth(40);

        topBar.getChildren().add(new Pane());
        topBar.getChildren().add(logo);
        topBar.getChildren().add(refreshButton);

        topBar.setStyle("-fx-background-color: LightSkyBlue");

        return topBar;
    }

    private VBox makeLeftBar() {
        VBox leftBar = new VBox(40);

        GridPane profile = new GridPane();
        profile.setHgap(10);
        profile.setPadding(new Insets(5, 10, 5, 10));

        ImageView profilePicture = new ImageView(new Image("burdell.jpg"));
        profilePicture.setFitHeight(60);
        profilePicture.setFitWidth(60);
        profile.add(profilePicture, 0, 0, 3, 3);

        Text nameText = new Text(burdell.getName());
        nameText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        profile.add(nameText, 3, 0, 5, 1);
        profile.add(new Text(burdell.getTwitterHandle()), 3, 1, 5, 1);
        profile.add(new Text("Tweets"), 0, 4, 2, 1);
        profile.add(numTweetText, 0, 5, 2, 1);
        profile.add(new Text("Following"), 3, 4, 2, 1);
        profile.add(new Text("      " + server.getUsers().size()), 3, 5, 2, 1);
        profile.add(new Text("Followers"), 6, 4, 2, 1);
        profile.add(new Text("    9001"), 6, 5, 2, 1);
        profile.setStyle("-fx-background-color: White");
        leftBar.getChildren().add(profile);

        leftBar.getChildren().add(new Text(burdell.getDescription()));

        VBox trendBox = new VBox(10);
        Text trendingTitle = new Text("Trending Now: ");
        trendingTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        trendBox.getChildren().add(trendingTitle);

        String[] trends = new String[8];
        trends[0] = "#Atlanta";
        trends[1] = "#BuzzIsLove";
        trends[2] = "#BuzzIsLife";
        trends[3] = "#DarkSouls3";
        trends[4] = "#PresidentialElection";
        trends[5] = "#SpaceX";
        trends[6] = "#Java";
        trends[7] = "#CS1331";

        for (String trend : trends) {
            Text trendText = new Text(trend);
            trendBox.getChildren().add(trendText);
        }

        trendBox.setStyle("-fx-background-color: White");
        trendBox.setPadding(new Insets(10, 10, 10, 10));

        leftBar.getChildren().add(trendBox);

        leftBar.setStyle("-fx-background-color: LightSkyBlue");

        leftBar.setPadding(new Insets(10, 5, 0, 5));

        return leftBar;
    }

    private void makeFeed() {
        VBox feed = new VBox(20);

        if (tweetMakeBox == null) {
            tweetMakeBox = new GridPane();
            tweetMakeBox.setHgap(10);
            tweetMakeBox.setPadding(new Insets(10, 10, 5, 10));
            ImageView profilePicture = new ImageView(new Image("burdell.jpg"));
            profilePicture.setFitHeight(60);
            profilePicture.setFitWidth(60);
            tweetMakeBox.add(profilePicture, 0, 0, 3, 3);

            Text characterCount = new Text("0");
            TextArea tweetTextArea = new TextArea();
            tweetTextArea.setPromptText("What's the good word?");
            tweetTextArea.setWrapText(true);
            tweetTextArea.setPrefRowCount(2);
            tweetTextArea.setPrefColumnCount(35);
            tweetTextArea.textProperty().addListener(e -> {
                    String contents = tweetTextArea.getText();
                    int numCharacters = contents.length();
                    if (numCharacters > 140) {
                        tweetTextArea.setText(contents.substring(0, 140));
                        characterCount.setText("" + 140);
                    } else {
                        characterCount.setText("" + numCharacters);
                    }
                });
            tweetMakeBox.add(tweetTextArea, 4, 0, 10, 5);
            tweetMakeBox.add(characterCount, 4, 10, 1, 1);
            Button tweetButton = new Button("Tweet!");
            tweetButton.setOnAction(e -> {
                    String text = tweetTextArea.getText();
                    if (text.length() == 0) {
                        return;
                    }

                    refresh();
                    Tweet tweet = new Tweet(burdell, text);

                    ImageView deleteImage = new ImageView(
                        new Image("trash.png"));
                    deleteImage.setFitWidth(10);
                    deleteImage.setFitHeight(10);

                    Button deleteButton = new Button("", deleteImage);
                    deleteButton.setOnAction(e2 -> {
                            tweets.remove(tweet);
                            makeFeed();
                            numTweetText.setText("     " + (--numTweets));
                        });
                    tweet.addButton(deleteButton);

                    tweets.add(0, tweet);
                    makeFeed();
                    numTweetText.setText("     " + (++numTweets));
                });
            tweetMakeBox.add(tweetButton, 15, 0, 6, 5);
            tweetMakeBox.setStyle("-fx-background-color: White");
            refresh();
        }

        feed.getChildren().add(tweetMakeBox);

        feed.setStyle("-fx-background-color: LightSkyBlue");
        feed.setPadding(new Insets(10, 10, 10, 5));

        for (int i = 0; i < tweets.size(); i++) {
            feed.getChildren().add(tweets.get(i));
        }

        feedScroller.setContent(feed);
    }

    private void refresh() {
        Random rand = new Random();
        int numNewTweets = rand.nextInt(3) + 2;
        for (int i = 0; i < numNewTweets; i++) {
            Tweet tweet = server.randTweet();

            ImageView retweetImage = new ImageView(new Image("retweet.png"));
            retweetImage.setFitWidth(10);
            retweetImage.setFitHeight(10);

            Button retweet = new Button("", retweetImage);
            retweet.setOnAction(e -> {
                    refresh();
                    Tweet newTweet = tweet.deepCopy();
                    Text retweetText = new Text(burdell.getName()
                        + " retweeted");
                    retweetText.setFont(Font.font("Arial", FontWeight.LIGHT,
                        12));
                    newTweet.add(retweetText, 2, 2);
                    tweets.add(0, newTweet);
                    makeFeed();
                });
            tweets.add(0, tweet);

            tweet.addButton(retweet);
        }
    }

    /**
     * Main method which launches the GUI
     * @param args Input arguments (unused)
     */
    public static void main(String[] args) {
        launch(args);
    }
}