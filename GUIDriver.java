import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.ActionEvent;

/**
 * Authors: Tatiana K., Edison L.
 *
 * GUIDriver is a javafx-based interface that allows a user to
 * create, remove, and print Post objects that resembles a post
 * from social media networks like Facebook, Twitter, and
 * Instagram.
 */
public class GUIDriver extends Application
{
    private static Scanner scan = new Scanner(System.in);
    private GUIView tableView;
    private PostsCollection posts;
    private ActionEvent event;

    public GUIDriver()
    {
        posts = new PostsCollection();
        tableView = new GUIView();

        tableView.setPostAction(this::post);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GUIDriver controller = new GUIDriver();

        Scene scene = new Scene(
            controller.tableView.getParent(),
            1200,
            800
        );

        scene.getStylesheets().add("assets/style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Social Media");
        primaryStage.show();

    }

    public static void main (String [] args)
    {
        launch(args);
    }

    public void post(ActionEvent event)
    {
        this.event = event;
        String name = tableView.getNameField();
        String content = tableView.getMessage();
        int siteNumber = tableView.getSiteNumber();
        Privacy privacy = tableView.getPrivacy();
        boolean saveToCollection = tableView.getSaveToCollection();
        String userName = tableView.getUserName();

        posts.addPost(name, content, siteNumber, privacy,
                saveToCollection, userName);

        this.tableView.show(posts.getPosts());
    }

}//Driver Program

/**
 * TODO:
 *  - read post data from a text file (change to api later?)
 *  - input validation
 */

