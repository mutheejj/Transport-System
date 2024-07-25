import javax.swing.*;
import java.awt.*;

public class RoutePlanner extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private JLabel mapLabel;
    private JLabel routeLabel;
    private JTextField fromField;
    private JTextField toField;
    private JButton planRouteButton;

    public RoutePlanner() {
        setLayout(new BorderLayout());

        // Set a background image
        JLabel backgroundImage = new JLabel(new ImageIcon("background_image.jpg"));
        backgroundImage.setLayout(new BorderLayout());
        add(backgroundImage, BorderLayout.CENTER);

        // Create a panel for the map
        JPanel mapPanel = new JPanel();
        mapPanel.setLayout(new BorderLayout());
        mapLabel = new JLabel();
        mapLabel.setIcon(new ImageIcon("nairobi_map.jpg")); // Load a map of Nairobi
        mapPanel.add(mapLabel, BorderLayout.CENTER);
        backgroundImage.add(mapPanel, BorderLayout.CENTER);

        // Create a panel for the route planning controls
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));
        controlPanel.setBackground(Color.WHITE); // Set a background color
        controlPanel.add(new JLabel("From:"));
        fromField = new JTextField();
        controlPanel.add(fromField);
        controlPanel.add(new JLabel("To:"));
        toField = new JTextField();
        controlPanel.add(toField);
        planRouteButton = new JButton("Plan Route");
        planRouteButton.addActionListener(e -> planRoute());
        controlPanel.add(planRouteButton);
        backgroundImage.add(controlPanel, BorderLayout.NORTH);

        // Create a panel for the route display
        JPanel routePanel = new JPanel();
        routePanel.setLayout(new BorderLayout());
        routeLabel = new JLabel();
        routeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        routePanel.add(routeLabel, BorderLayout.CENTER);
        backgroundImage.add(routePanel, BorderLayout.SOUTH);
    }

    private void planRoute() {
        String from = fromField.getText();
        String to = toField.getText();
        // Call the planRoute method from your database or algorithm
        String route = planRoute(from, to);
        routeLabel.setText("Route: " + route);
    }

    // This method should be implemented to return the route from the database or algorithm
    private String planRoute(String from, String to) {
        // Implement your route planning algorithm or database query here
        return "Route from " + from + " to " + to;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Route Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RoutePlanner());
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}