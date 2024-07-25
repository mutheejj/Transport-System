import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Date;



public class MainGUI {
    private JFrame frame;
    private JButton btnAddVehicle;
    private JButton btnPlanRoute;
    private JButton btnScheduleTrip;
    private JButton btnTrackLocation;
    private JTextField txtVehicleType;
    private JTextField txtCapacity;
    private JTextField txtOrigin;
    private JTextField txtDestination;
    private JTextField txtDepartureTime;
    private JTextField txtArrivalTime;
    private DatabaseManager databaseManager;
    private FleetManager fleetManager;
    private RoutePlanner routePlanner;

    public MainGUI() {
        databaseManager = new DatabaseManager();
        fleetManager = new FleetManager();
        routePlanner = new RoutePlanner(databaseManager);

        frame = new JFrame("Transport Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create custom JPanel for background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(new ImageIcon("img/logo.jpeg").getImage());
        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel);

// Create logo panel
JPanel panelLogo = new JPanel(new BorderLayout());
panelLogo.setBackground(Color.WHITE); // or any other background color
panelLogo.setOpaque(true); // make sure the panel is opaque
panelLogo.setPreferredSize(new Dimension(1000, 1000)); // or any other size
panelLogo.setMinimumSize(new Dimension(100, 100)); // or any other minimum size
panelLogo.setMaximumSize(new Dimension(1000, 1000)); // or any other maximum size
panelLogo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // or any other border style and color

File file = new File("img/logo.png");
if (!file.exists()) {
    System.out.println("Image file not found!");
} else {
    try {
        BufferedImage image = ImageIO.read(file);
        JLabel logoLabel = new JLabel(new ImageIcon(image));
        logoLabel.setPreferredSize(new Dimension(100, 100)); // or any other size
        JScrollPane scrollPane = new JScrollPane(logoLabel);
        panelLogo.add(scrollPane, BorderLayout.CENTER);
    } catch (IOException e) {
        System.out.println("Error loading image: " + e.getMessage());
    }
}

backgroundPanel.add(panelLogo, BorderLayout.NORTH);
        JPanel panelNorth = new JPanel(new FlowLayout());
        panelNorth.setBackground(new Color(52, 152, 219, 200)); // Semi-transparent background

        JPanel panelCenter = new JPanel(new GridBagLayout());
        panelCenter.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel panelSouth = new JPanel(new FlowLayout());
        panelSouth.setBackground(new Color(52, 152, 219, 200)); // Semi-transparent background

        // Create buttons
        btnAddVehicle = new JButton("Add Vehicle");
        btnAddVehicle.setPreferredSize(new Dimension(150, 30));
        btnAddVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVehicle();
            }
        });

        btnPlanRoute = new JButton("Plan Route");
        btnPlanRoute.setPreferredSize(new Dimension(150, 30));
        btnPlanRoute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                planRoute();
            }
        });

        btnScheduleTrip = new JButton("Schedule Trip");
        btnScheduleTrip.setPreferredSize(new Dimension(150, 30));
        btnScheduleTrip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleTrip();
            }
        });

        btnTrackLocation = new JButton("Track Location");
        btnTrackLocation.setPreferredSize(new Dimension(150, 30));
        btnTrackLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackLocation();
            }
        });

        Color labelColor = new Color(255, 255, 255); // Color for labels (Super Black)
Color textFieldColor = new Color(255, 255, 255); // Color for text fields (White)

// Create text fields
txtVehicleType = new JTextField(15);
txtCapacity = new JTextField(15);
txtOrigin = new JTextField(15);
txtDestination = new JTextField(15);
txtDepartureTime = new JTextField(15);
txtArrivalTime = new JTextField(15);

txtVehicleType.setBackground(textFieldColor);
txtCapacity.setBackground(textFieldColor);
txtOrigin.setBackground(textFieldColor);
txtDestination.setBackground(textFieldColor);
txtDepartureTime.setBackground(textFieldColor);
txtArrivalTime.setBackground(textFieldColor);

JLabel lblVehicleType = new JLabel("Vehicle Type:");
lblVehicleType.setForeground(labelColor);

JLabel lblCapacity = new JLabel("Capacity:");
lblCapacity.setForeground(labelColor);

JLabel lblOrigin = new JLabel("Origin:");
lblOrigin.setForeground(labelColor);

JLabel lblDestination = new JLabel("Destination:");
lblDestination.setForeground(labelColor);

JLabel lblDepartureTime = new JLabel("Departure Time:");
lblDepartureTime.setForeground(labelColor);

JLabel lblArrivalTime = new JLabel("Arrival Time:");
lblArrivalTime.setForeground(labelColor);

// Add components to panels
panelNorth.add(btnAddVehicle);
panelNorth.add(btnPlanRoute);
panelNorth.add(btnScheduleTrip);
panelNorth.add(btnTrackLocation);

GridBagConstraints gridBagConstraints = new GridBagConstraints();

gridBagConstraints.anchor = GridBagConstraints.LINE_START; // Align components to the left



addToPanel(panelCenter, lblVehicleType, gbc, 0, 0);
addToPanel(panelCenter, txtVehicleType, gbc, 1, 0);
addToPanel(panelCenter, lblCapacity, gbc, 0, 1);
addToPanel(panelCenter, txtCapacity, gbc, 1, 1);
addToPanel(panelCenter, lblOrigin, gbc, 0, 2);
addToPanel(panelCenter, txtOrigin, gbc, 1, 2);
addToPanel(panelCenter, lblDestination, gbc, 0, 3);
addToPanel(panelCenter, txtDestination, gbc, 1, 3);
addToPanel(panelCenter, lblDepartureTime, gbc, 0, 4);
addToPanel(panelCenter, txtDepartureTime, gbc, 1, 4);
addToPanel(panelCenter, lblArrivalTime, gbc, 0, 5);
addToPanel(panelCenter, txtArrivalTime, gbc, 1, 5);
        

        panelSouth.add(new JLabel("Transport Management System"));

        // Add panels to frame
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelSouth, BorderLayout.SOUTH);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Transport Management System\nVersion 1.0", "About", JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        // Set frame properties
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addToPanel(JPanel panel, Component component, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }

    private void addVehicle() {
        try {
            String vehicleType = txtVehicleType.getText();
            int capacity = Integer.parseInt(txtCapacity.getText());
            Vehicle vehicle = new Vehicle(vehicleType, capacity);
            fleetManager.addVehicle(vehicle);
            databaseManager.addVehicle(vehicle);
            JOptionPane.showMessageDialog(frame, "Vehicle added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid capacity.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "An error occurred while adding the vehicle.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void planRoute() {
        try {
            String origin = txtOrigin.getText();
            String destination = txtDestination.getText();
            int passengers = Integer.parseInt(txtCapacity.getText()); // Assuming capacity as the number of passengers for simplicity
    
            Trip trip = new Trip(passengers, origin, destination, 0, "", "");
            List<Route> routes = routePlanner.planRoute(trip);
    
            if (routes.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No suitable routes found.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Create a new JFrame for the route details
                JFrame routeFrame = new JFrame("Route Details");
                routeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
                // Create a JPanel to hold the route details
                JPanel routePanel = new JPanel();
                routePanel.setLayout(new BorderLayout());
    
                // Create a JTextArea to display the route details
                JTextArea routeDetailsArea = new JTextArea();
                routeDetailsArea.setEditable(false);
    
                StringBuilder routeDetails = new StringBuilder("Planned Routes:\n");
                for (Route route : routes) {
                    routeDetails.append(route).append("\n");
                }
                routeDetailsArea.setText(routeDetails.toString());
    
                // Add the JTextArea to the JPanel
                routePanel.add(new JScrollPane(routeDetailsArea), BorderLayout.CENTER);
    
                // Add the JPanel to the JFrame
                routeFrame.add(routePanel, BorderLayout.CENTER);
    
                // Set the size of the JFrame
                routeFrame.setSize(400, 300);
    
                // Center the JFrame on the screen
                routeFrame.setLocationRelativeTo(null);
    
                // Make the JFrame visible
                routeFrame.setVisible(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number of passengers.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "An error occurred while planning the route: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Print the stack trace to the console for debugging
        }
    }

    private void scheduleTrip() {
        try {
            String origin = txtOrigin.getText();
            String destination = txtDestination.getText();
            String departureTime = txtDepartureTime.getText();
            String arrivalTime = txtArrivalTime.getText();
            int capacity = Integer.parseInt(txtCapacity.getText());
    
            java.sql.Date departureDate = java.sql.Date.valueOf(departureTime);
            java.sql.Date arrivalDate = java.sql.Date.valueOf(arrivalTime);
    
            Trip trip = new Trip(0, origin, destination, capacity, departureDate, arrivalDate);
    
            Vehicle suitableVehicle = fleetManager.findSuitableVehicle(capacity);
            if (suitableVehicle != null) {
                databaseManager.scheduleTrip(trip, suitableVehicle);
                JOptionPane.showMessageDialog(frame, "Trip scheduled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "No suitable vehicle available.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid capacity.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "An error occurred while scheduling the trip.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void trackLocation() {
        JOptionPane.showMessageDialog(frame, "Track Location functionality is not implemented yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
    }
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
