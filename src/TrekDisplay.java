import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TrekDisplay extends JFrame
{
    private static final long serial = -524526543L;
    private boolean isAboard = true;
    private String destination = "";
    private JLabel destinationLabel = new JLabel("Destination: ");
    private JLabel consoleLabel = new JLabel("Console Readout: ");
    private TextField destinationText = new TextField();
    private TextArea statusText = new TextArea();
    private JButton transportButton = new JButton("Transport Crew");
    private JButton retrieveButton = new JButton("Retrieve Crew");


    private class transCrew implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(isAboard == false)
            {
                statusText.setText("The crew is not aboard the ship! Bring them back before transporting.");
            }
            else
            {
                if(destination.isEmpty() || Character.isDigit(destination.charAt(0)) == true)
                {
                    statusText.setText("You don't want to transport there, trust me...");
                }
                else
                {
                    statusText.setText("Transporting crew to destination: " + destination);
                    isAboard = false;
                }

            }
        }
    }

    private class getDestination implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            destination = destinationText.getText();
        }
    }

    private class retCrew implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(isAboard == true)
            {
                statusText.setText("The crew is already aboard and quite bored. Try sending them somewhere.");
            }
            else
            {
                statusText.setText("Bringing the crew back with haste!");
                isAboard = true;
            }

        }
    }


    private TrekDisplay()
    {
        super("Enterprise Control Panel");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(transportButton);
        buttonPanel.add(retrieveButton);

        JPanel destPanel = new JPanel();
        destPanel.add(destinationLabel);
        destPanel.add(destinationText);

        JPanel consPanel = new JPanel();
        consPanel.add(consoleLabel);
        consPanel.add(statusText);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(destPanel, BorderLayout.CENTER);
        getContentPane().add(consPanel, BorderLayout.NORTH);
        transportButton.addActionListener(new transCrew());
        retrieveButton.addActionListener(new retCrew());
        destinationText.setText("Enter target destination and hit enter...");
        destinationText.addActionListener(new getDestination());
        statusText.setText("The Crew is ready for departure.");
        statusText.setEditable(false);

        setVisible(true);
    }

    public static void main(String [] args)
    {
        new TrekDisplay();
    }

}